package com.example.chaitnya.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import static java.lang.String.valueOf;

public class cutomer_info extends AppCompatActivity {

    private static final String NO_PARTICIPANT = "NO_PARTICIPANT";
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomer_info);
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.linearlayout);
        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);
        int n= extras.getInt(NO_PARTICIPANT);
        for(int i=1;i<=n;i++)
        {
            EditText editText=new EditText(this);
            if(i==n)
            {
                editText.setText("Phone No");
            }
            else {
                editText.setText("Enter Name" +" "+ valueOf(i));
            }
            linearLayout.addView(editText);
        }

    }
}
