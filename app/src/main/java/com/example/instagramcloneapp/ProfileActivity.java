package com.example.instagramcloneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;

public class ProfileActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Button button1,button2,button3,button4,button5;
    ImageButton discoverpeople;
    HorizontalScrollView horizontalScrollView;

    int i = 0;
    int x = 0;
    int p = 0;
    int q = 0;
    int r = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        tabLayout = findViewById(R.id.tabLayout);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        discoverpeople = findViewById(R.id.discoverPeople);
        horizontalScrollView = findViewById(R.id.frthfltid);


        discoverpeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                i++;
                if(i==1)
                {
                    horizontalScrollView.setVisibility(View.GONE);
                }
                else if(i == 2) {
                    horizontalScrollView.setVisibility(View.VISIBLE);
                }





            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x++;

                if (x == 1)
                {
                    button1.setText("Following");
                    button1.setBackgroundColor(Color.BLACK);
                }
                else if (x == 2)
                {
                    button1.setText("Follow");
                    button1.setBackgroundColor(Color.BLUE);
                }


            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                p++;

                if (p == 1)
                {
                    button2.setText("Following");
                    button2.setBackgroundColor(Color.BLACK);
                }
                else if (p == 2)
                {
                    button2.setText("Follow");
                    button2.setBackgroundColor(Color.BLUE);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                r++;

                if (r == 1)
                {
                    button3.setText("Following");
                    button3.setBackgroundColor(Color.BLACK);
                }
                else if (r == 2)
                {
                    button3.setText("Follow");
                    button3.setBackgroundColor(Color.BLUE);
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q++;

                if (q == 1)
                {
                    button4.setText("Following");
                    button4.setBackgroundColor(Color.BLACK);
                }
                else if (q == 2)
                {
                    button4.setText("Follow");
                    button4.setBackgroundColor(Color.BLUE);
                }



            }
        });



        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                button5.setText("following");
                button5.setBackgroundColor(Color.BLACK);
            }
        });


        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fManager.beginTransaction();
        fragmentTransaction.add(R.id.mylayout,new ImagesFragment());
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                int tabPosition = tab.getPosition();

                if(tabPosition == 0)
                {
                    FragmentManager fManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fManager.beginTransaction();
                    fragmentTransaction.add(R.id.mylayout,new ImagesFragment());
                    fragmentTransaction.commit();

                }

                if(tabPosition == 1)
                {
                    FragmentManager fManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fManager.beginTransaction();
                    fragmentTransaction.add(R.id.mylayout,new VideosFragment());
                    fragmentTransaction.commit();
                }

                if(tabPosition == 2)
                {
                    FragmentManager fManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fManager.beginTransaction();
                    fragmentTransaction.add(R.id.mylayout,new VideosFragment());
                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    
    }
}