package com.example.chaitnya.gallery.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chaitnya.gallery.R;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

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
    private int num;
    private ArrayList listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clg_event_detail);

        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);
        ((TextView)findViewById(R.id.totaldate)).setText(extras.getString(EXTRA_QUOTE));
        ((TextView)findViewById(R.id.time)).setText(extras.getString(TIME));
        ((ImageView)findViewById(R.id.imageViewEventDetail)).setImageResource(extras.getInt(EXTRA_ATTR));
        ((TextView)findViewById(R.id.venue)).setText(extras.getString(VENUE));
        ((TextView)findViewById(R.id.email)).setText(extras.getString(EMAIL));
        ((TextView)findViewById(R.id.detail)).setText(extras.getString(DETAILS));
        ((TextView)findViewById(R.id.fee)).setText(extras.getString(FEE));
        ((TextView)findViewById(R.id.event_title)).setText(extras.getString(EVENT));
        ((TextView)findViewById(R.id.participant_No)).setText(extras.getString(PARTICIPANT));
        num = extras.getInt(ADPT_POS);
        
    }
    
    public void onClick(View v){

    ListActivity la=new ListActivity();
    la.onSecondaryIconClick(num);
    }


}
