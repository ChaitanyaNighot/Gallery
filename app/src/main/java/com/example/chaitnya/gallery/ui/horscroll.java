package com.example.chaitnya.gallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.chaitnya.gallery.R;
import com.example.chaitnya.gallery.adapter.CustomSwipeAdapter;
import com.example.chaitnya.gallery.adapter.ViewPagerAdapter;

public class horscroll extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tL;
    ViewPager viewPager1,viewpager2;
    ViewPagerAdapter viewPagerAdapter;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horscroll);

        //for swipe layout///////////////////////////
        viewPager1=(ViewPager)findViewById(R.id.view_pager1);
        adapter = new CustomSwipeAdapter(this);
        viewPager1.setAdapter(adapter);

       // toolbar=(Toolbar)findViewById(R.id.toollbar);
        setSupportActionBar(toolbar);
        tL =(TabLayout)findViewById(R.id.tablayout);
        tL.setTabTextColors(getResources().getColor(R.color.colorTextWhite),getResources().getColor(R.color.colorBrown));
        viewpager2=(ViewPager)findViewById(R.id.view_pager2);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Technical(),"Technical");
        viewPagerAdapter.addFragments(new Non_technical(),"Non-Technical");
        viewpager2.setAdapter(viewPagerAdapter);
        tL.setupWithViewPager(viewpager2);
    }

    public void nextActivity(View view){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);

    }

}
