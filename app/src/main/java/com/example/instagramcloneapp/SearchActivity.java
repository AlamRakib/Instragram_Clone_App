package com.example.instagramcloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchActivity extends AppCompatActivity {

    GridView gridView;

    HashMap<String,String> hashMap;
    ArrayList< HashMap<String,String>> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        gridView = findViewById(R.id.gridViewId);


        arrayList = new ArrayList<>();


        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/14930738/pexels-photo-14930738.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/9319407/pexels-photo-9319407.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/8685412/pexels-photo-8685412.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/12454845/pexels-photo-12454845.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/14711714/pexels-photo-14711714.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/14831657/pexels-photo-14831657.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/6223230/pexels-photo-6223230.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/11596834/pexels-photo-11596834.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("profile_image","https://images.pexels.com/photos/15332212/pexels-photo-15332212.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load");
        arrayList.add(hashMap);


        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);
    }


    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View myview = layoutInflater.inflate(R.layout.sample_view2, viewGroup, false);

            ImageView imageView = myview.findViewById(R.id.imageView);

            HashMap<String,String> hashMap = arrayList.get(position);
            String profileImage = hashMap.get("profile_image");

            Picasso.get()
                    .load(profileImage)
                    .into(imageView);


            return myview;
        }
    }
}