package com.example.chaitnya.gallery.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chaitnya.gallery.Data.Camp_data;
import com.example.chaitnya.gallery.Event_detail.Camp_detail;
import com.example.chaitnya.gallery.List_item.Camp_list;
import com.example.chaitnya.gallery.adapter.CampAdapter;
import com.example.chaitnya.gallery.adapter.CustomSwipeAdapter;
import com.example.chaitnya.gallery.R;
import com.example.chaitnya.gallery.cutomer_info;

import java.util.ArrayList;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;

public class camps extends AppCompatActivity implements CampAdapter.ItemClickCallback {
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";
    private static final String EMAIL = "EMAIL";
    private static final String DETAILS = "DETAILS";
    private static final String VENUE = "VENUE";
    private static final String FEE = "FEE";
    private static final String TIME = "TIME";
    private static final String EVENT = "EVENT";
    private static final String PARTICIPANT = "PARTICIPANT";
    private static final String NO_PARTICIPANT = "NO_PARTICIPANT";
    private static final String ADPT_POS = "ADPT_POS";

    private RecyclerView recView;
    private CampAdapter adapter;
    private ArrayList listData;


   // ViewPager viewPager1;
   // CustomSwipeAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);
        listData = (ArrayList) Camp_data.getListData();

        recView = (RecyclerView)findViewById(R.id.rec_list);
        //Check out GridLayoutManager and StaggeredGridLayoutManager for more options
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CampAdapter(Camp_data.getListData(), this);
        recView.setAdapter(adapter);
        adapter.setItemClickCallback(this);

        /////////*******----Swipe View----******///////////////
       // viewPager1=(ViewPager)findViewById(R.id.view_pager1);
       // adapter1 = new CustomSwipeAdapter(this);
        //viewPager1.setAdapter(adapter1);
    }

    public void onItemClick(int p) {

        Camp_list item = (Camp_list) listData.get(p);

        Intent i = new Intent(this,Camp_detail.class);
        Bundle extras = new Bundle();
        extras.putString(EXTRA_QUOTE,item.getTotaldate());
        extras.putString(TIME,item.getTime());
        // this is added
        extras.putInt(EXTRA_ATTR,item.getImageResId());
        extras.putString(VENUE,item.getAddress());
        extras.putString(EMAIL,item.getEmail());
        extras.putString(DETAILS,item.getDetail());
        extras.putString(FEE,item.getFee());
        extras.putString(EVENT,item.getTitle());
        extras.putString(PARTICIPANT,item.getParticipant());
        extras.putInt(ADPT_POS,p);
        i.putExtra(BUNDLE_EXTRAS,extras);
        startActivity(i);
    }

    @Override
    public void onSecondaryIconClick(int p) {

        Camp_list item = (Camp_list) listData.get(p);

        int n = Integer.parseInt(item.getParticipant());
        Intent intent = new Intent(getApplicationContext(),cutomer_info.class);
        Bundle extras = new Bundle();
        extras.putInt(NO_PARTICIPANT,n);
        intent.putExtra(BUNDLE_EXTRAS,extras);
        startActivity(intent);

    }


}
