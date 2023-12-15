package com.example.instagramcloneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
    FrameLayout frameLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;






    RecyclerView recyclerView;

    HashMap<String,String> hashMap;
    ArrayList< HashMap<String,String>> arrayList;


    ImageView imageView1,imageView2,imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerlayout);
        materialToolbar = findViewById(R.id.materialToolbar);
        frameLayout = findViewById(R.id.framelayout);


        recyclerView = findViewById(R.id.recyclerView);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        navigationView = findViewById(R.id.navigationView);
        imageView1 = findViewById(R.id.imgg1);
        imageView2 = findViewById(R.id.imgg2);
        imageView3 = findViewById(R.id.imgg3);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bitmap bitmap = ( (BitmapDrawable) imageView1.getDrawable() ).getBitmap();
                StoryViewActivity.MyBitmap = bitmap;
                startActivity(new Intent(getApplicationContext(),StoryViewActivity.class));

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bitmap bitmap = ( (BitmapDrawable) imageView2.getDrawable() ).getBitmap();
                StoryViewActivity.MyBitmap = bitmap;
                startActivity(new Intent(getApplicationContext(),StoryViewActivity.class));

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bitmap bitmap = ( (BitmapDrawable) imageView3.getDrawable() ).getBitmap();
                StoryViewActivity.MyBitmap = bitmap;
                startActivity(new Intent(getApplicationContext(),StoryViewActivity.class));

            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(

                MainActivity.this,drawerLayout,materialToolbar,R.string.drawer_close,R.string.drawer_open);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.home)
                {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if(item.getItemId()==R.id.share)
                {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String subject = "Instagram Clone App";
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    startActivity(Intent.createChooser(intent, "share with"));

                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if(item.getItemId()==R.id.feedback)
                {

                    startActivity(new Intent(getApplicationContext(),FeedBackActivity.class));

                    drawerLayout.closeDrawer(GravityCompat.START);

                }
                else if(item.getItemId()==R.id.settings)
                {


                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();

                }

                else if(item.getItemId()==R.id.developer)
                {

                    startActivity(new Intent(getApplicationContext(),DeveloperActivity.class));

                    drawerLayout.closeDrawer(GravityCompat.START);


                }
                else if(item.getItemId()==R.id.exit)
                {

                    AlertDialog.Builder alertDialogBuilder;
                    alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setTitle(R.string.title_text);
                    alertDialogBuilder.setMessage(R.string.message_text);
                    alertDialogBuilder.setCancelable(false);


                    alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {





                            finish();


                        }
                    });

                    alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            dialog.cancel();

                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                }

                drawerLayout.closeDrawer(GravityCompat.START);



                return true;
            }
        });



        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.notification)
                {
                    startActivity( new Intent(getApplicationContext(),NotificationActivity.class));
                }

                return false;
            }
        });


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {




                if(item.getItemId()==R.id.user)
                {


                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));

                }

                if(item.getItemId()==R.id.search)
                {


                    startActivity(new Intent(getApplicationContext(),SearchActivity.class));

                }

                if(item.getItemId()==R.id.post)
                {


                    startActivity(new Intent(getApplicationContext(),PostActivity.class));

                }

                if(item.getItemId()==R.id.video)
                {


                    startActivity(new Intent(getApplicationContext(),VideoActivity.class));

                }

                return false;
            }
        });

        arrayList = new ArrayList<>();


        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://cdn.pixabay.com/photo/2014/11/14/21/24/woman-531252_960_720.jpg");
        hashMap.put("name","fenosoa");
        hashMap.put("fullpic","https://cdn.pixabay.com/photo/2014/11/14/21/24/woman-531252_960_720.jpg");
        hashMap.put("likeCount","5343446 likes");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/15569152/pexels-photo-15569152.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        hashMap.put("name","ilya go_go");
        hashMap.put("fullpic","https://images.pexels.com/photos/15569152/pexels-photo-15569152.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        hashMap.put("likeCount","6203 likes");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://cdn.pixabay.com/photo/2019/11/29/14/38/boxing-4661441_960_720.jpg");
        hashMap.put("name","john Doe");
        hashMap.put("fullpic","https://cdn.pixabay.com/photo/2019/11/29/14/38/boxing-4661441_960_720.jpg");
        hashMap.put("likeCount","634546 likes");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/14664626/pexels-photo-14664626.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        hashMap.put("name","jasmen chew");
        hashMap.put("fullpic","https://images.pexels.com/photos/14664626/pexels-photo-14664626.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        hashMap.put("likeCount","75753 likes");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/15276010/pexels-photo-15276010.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        hashMap.put("name","Gutsbyjan_N");
        hashMap.put("fullpic","https://images.pexels.com/photos/15276010/pexels-photo-15276010.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        hashMap.put("likeCount","6578 likes");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://cdn.pixabay.com/photo/2015/06/19/09/39/lonely-814631_960_720.jpg");
        hashMap.put("name","Walker");
        hashMap.put("fullpic","https://cdn.pixabay.com/photo/2015/06/19/09/39/lonely-814631_960_720.jpg");
        hashMap.put("likeCount","3434334 likes");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/15127343/pexels-photo-15127343.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        hashMap.put("name","Daisy Johnson");
        hashMap.put("fullpic","https://images.pexels.com/photos/15127343/pexels-photo-15127343.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        hashMap.put("likeCount","55758454 likes");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://cdn.pixabay.com/photo/2016/12/21/00/36/woman-1921883_960_720.jpg");
        hashMap.put("name","instagram");
        hashMap.put("fullpic","https://cdn.pixabay.com/photo/2016/12/21/00/36/woman-1921883_960_720.jpg");
        hashMap.put("likeCount","6294343 likes");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/6773303/pexels-photo-6773303.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        hashMap.put("name","ann_marie");
        hashMap.put("fullpic","https://images.pexels.com/photos/6773303/pexels-photo-6773303.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        hashMap.put("likeCount","6295334343 likes");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/15405005/pexels-photo-15405005.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        hashMap.put("name","umtiti");
        hashMap.put("fullpic","https://images.pexels.com/photos/15405005/pexels-photo-15405005.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        hashMap.put("likeCount","43494343 likes");
        arrayList.add(hashMap);









        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));



    }



    private class MyAdapter extends RecyclerView.Adapter <MyAdapter.myViewHolder>{


        private class myViewHolder extends RecyclerView.ViewHolder{

            ImageView ProfileImage,option,fullpic,like,comment,share,save;
            TextView LikeCount,Name;


            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                ProfileImage = itemView.findViewById(R.id.profileImage);
                LikeCount = itemView.findViewById(R.id.likecounttextView);
                option = itemView.findViewById(R.id.option);
                fullpic = itemView.findViewById(R.id.pictureImageView);
                like = itemView.findViewById(R.id.like);
                comment = itemView.findViewById(R.id.comment);
                share = itemView.findViewById(R.id.share);
                save = itemView.findViewById(R.id.save);

                Name = itemView.findViewById(R.id.nametextView);





            }
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.sample_view,parent,false);


            return new myViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

            hashMap = arrayList.get(position);
            String name = hashMap.get("name");
            String likeCount = hashMap.get("likeCount");
            String profileImage = hashMap.get("profile_image");
            String fullImage = hashMap.get("fullpic");

            holder.Name.setText(name);
            holder.LikeCount.setText(likeCount);

            Picasso.get()
                    .load(profileImage)
                    .into(holder.ProfileImage);

            Picasso.get()
                    .load(fullImage)
                    .into(holder.fullpic);


            holder.option.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.bottomsheetlayout);

                    dialog.show();
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                    dialog.getWindow().setGravity(Gravity.BOTTOM);
                }
            });


        }

        @Override
        public int getItemCount()
        {
            return arrayList.size();
        }



    }


}