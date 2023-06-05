package com.taskperformance.emoney;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

public class QRcode extends AppCompatActivity {
    private CodeScanner mCodeScanner;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        // Get the scanner view and result text view from the layout
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mResultTextView = findViewById(R.id.scanner_text);


        // Create a new CodeScanner object
        mCodeScanner = new CodeScanner(this, scannerView);

        // Set the decoding callback
        mCodeScanner.setDecodeCallback(new DecodeCallback() {

            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        // Check if the scanned format is QR code
                        if (result.getBarcodeFormat() == BarcodeFormat.QR_CODE) {



                            // Show a dialog box with the scanned text and a copy button
                            AlertDialog.Builder builder = new AlertDialog.Builder(QRcode.this);
                            builder.setTitle("Scan Result");
                            builder.setMessage(result.getText());
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Stop the current preview
                                    mCodeScanner.stopPreview();

                                    // Start the scanner again
                                    mCodeScanner.startPreview();
                                }
                            });
                            builder.setNegativeButton("Copy", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Copy the scanned text to the clipboard
                                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                    ClipData clip = ClipData.newPlainText("Scan Result", result.getText());
                                    clipboard.setPrimaryClip(clip);

                                    // Show a toast message indicating that the text was copied to the clipboard
                                    Toast.makeText(QRcode.this, "Scan result copied to clipboard", Toast.LENGTH_SHORT).show();
                                }
                            });
                            builder.show();



                        } else {
                            mResultTextView.setText("Scan result is not a QR code.");
                        }
                    }
                });
            }
        });

        // Set the scan format to all formats
        mCodeScanner.setFormats(CodeScanner.ALL_FORMATS);

        // Start the scanner
        mCodeScanner.startPreview();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resume the scanner when the activity is resumed
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        // Pause the scanner when the activity is paused
        mCodeScanner.releaseResources();
        super.onPause();
    }
}