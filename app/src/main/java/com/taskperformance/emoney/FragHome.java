package com.taskperformance.emoney;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.taskperformance.emoney.QRcode;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragHome newInstance(String param1, String param2) {
        FragHome fragment = new FragHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_home, container, false);

        ImageButton buttonOne = view.findViewById(R.id.one);
        ImageButton buttonTwo = view.findViewById(R.id.two);
        ImageButton buttonThree = view.findViewById(R.id.three);
        ImageButton buttonFour = view.findViewById(R.id.four);
        ImageButton buttonFive = view.findViewById(R.id.five);
        ImageButton buttonSix = view.findViewById(R.id.six);
        ImageButton buttonSeven = view.findViewById(R.id.seven);
        ImageButton buttonEight = view.findViewById(R.id.eight);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Send Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Request Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Banks Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Bills Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //2nd section buttons

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Games Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Food Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Load Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Reward Button clicked", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }
}