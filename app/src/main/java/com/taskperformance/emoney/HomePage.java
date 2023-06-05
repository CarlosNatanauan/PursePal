package com.taskperformance.emoney;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class HomePage extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    FragHome home =  new FragHome();
    FragTwo two = new FragTwo();

    FragThree three = new FragThree();
    FragFour four = new FragFour();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        FloatingActionButton fab = findViewById(R.id.BTQR);
        fab.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, QRcode.class);
                startActivity(intent);
            }
        });



        bottomNavigationView = findViewById(R.id.bottomNavigationView);


        getSupportFragmentManager().beginTransaction().replace(R.id.container, home).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {



            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, home).commit();
                        return true;
                    case R.id.nav_inbox:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, two).commit();
                        return true;

                    case R.id.nav_promo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, three).commit();
                        return true;
                    case R.id.nav_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, four).commit();
                        return true;

                }
                return false;
            }
        });





    }


    public  void onBackPressed(){
        this.finishAffinity();
    }


}