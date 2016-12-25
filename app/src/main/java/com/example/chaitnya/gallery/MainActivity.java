package com.example.chaitnya.gallery;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chaitnya.gallery.Data.Concert_data;
import com.example.chaitnya.gallery.List_item.Concerts_list;
import com.example.chaitnya.gallery.adapter.CustomSwipeAdapter;
import com.example.chaitnya.gallery.ui.camps;
import com.example.chaitnya.gallery.ui.clg_events;
import com.example.chaitnya.gallery.Event_detail.Concerts_details;
import com.example.chaitnya.gallery.ui.concerts;
import com.example.chaitnya.gallery.ui.horscroll;
import com.example.chaitnya.gallery.ui.plays;
import com.example.chaitnya.gallery.ui.social_events;
import com.example.chaitnya.gallery.ui.sports;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    ViewPager viewPager1;
    CustomSwipeAdapter adapter1;
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
    private ArrayList listData;


    int lettersicon[] = {R.drawable.ic_account_balance_black_48dp,R.drawable.ic_android_black_48dp,R.drawable.ic_change_history_black_48dp,
    R.drawable.ic_http_black_48dp,R.drawable.ic_star_black_24dp,R.drawable.ic_star_border_black_24dp};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gridView);
        GridAdapter adapter = new GridAdapter(MainActivity.this,lettersicon);
        gv.setAdapter(adapter);

        /////////*******----Swipe View----******///////////////
        viewPager1=(ViewPager)findViewById(R.id.view_pager1);
        adapter1 = new CustomSwipeAdapter(this);
        viewPager1.setAdapter(adapter1);

           gv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           public void onItemClick(AdapterView<?> parent ,View view, int position,long id){

               if(position==0)
               {
                   Intent i = new Intent(getApplicationContext(),social_events.class);
                   startActivity(i);
               }
               else if (position==1)
               {
                   Intent i = new Intent(getApplicationContext(),camps.class);
                   startActivity(i);
               }
               else if(position==2)
               {
                   Intent i = new Intent(getApplicationContext(),plays.class);
                   startActivity(i);

               }
               else if (position==3)
               {

                   listData = (ArrayList) Concert_data.getListData();


                   Concerts_list item = (Concerts_list) listData.get(3);
                   Log.d("list_item",item.getAddress());


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
                   extras.putInt(ADPT_POS,3);
                   Intent intent=new Intent(MainActivity.this,concerts.class);
                   intent.putExtra(BUNDLE_EXTRAS,extras);

// Log.d("extras" ,extras.toString());

                   startActivity(intent);
               }
               else if (position==4)
               {
                   Intent i = new Intent(getApplicationContext(),horscroll.class);
                   startActivity(i);
               }
               else if (position==5)
               {
                   Intent i = new Intent(getApplicationContext(),sports.class);
                   startActivity(i);
               }
           }
           });

    }
}
    class GridAdapter extends BaseAdapter{

        private int[] icons;
        private Context context;
        private LayoutInflater inflater;

        public GridAdapter(Context context,int icons[]){

            this.context=context;
            this.icons=icons;
        }

        @Override
        public int getCount() {
            return icons.length;
        }

        @Override
        public Object getItem(int position) {
            return icons[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View gridview = convertView;
            if(convertView==null)
            {
                inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                gridview = inflater.inflate(R.layout.custom_layout,null);

            }

            ImageView icon = (ImageView) gridview.findViewById(R.id.img_view);
            icon.setImageResource(icons[position]);
            return gridview;
        }

    }

