package com.example.chaitnya.gallery;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
   /* GridView gv;
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
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_ke_upper_ki_xml);
      //  nav_drawer();
      /*  gv = (GridView) findViewById(R.id.gridView);
        GridAdapter adapter = new GridAdapter(MainActivity.this, lettersicon);
        gv.setAdapter(adapter);


        viewPager1 = (ViewPager) findViewById(R.id.view_pager1);
        adapter1 = new CustomSwipeAdapter(this);
        viewPager1.setAdapter(adapter1);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent i = new Intent(getApplicationContext(), social_events.class);
                    startActivity(i);
                } else if (position == 1) {
                    Intent i = new Intent(getApplicationContext(), camps.class);
                    startActivity(i);
                } else if (position == 2) {
                    Intent i = new Intent(getApplicationContext(), plays.class);
                    startActivity(i);

                } else if (position == 3) {

                    listData = (ArrayList) Concert_data.getListData();


                    Concerts_list item = (Concerts_list) listData.get(3);
                    Log.d("list_item", item.getAddress());


                    Bundle extras = new Bundle();
                    extras.putString(EXTRA_QUOTE, item.getTotaldate());
                    extras.putString(TIME, item.getTime());
                    // this is added
                    extras.putInt(EXTRA_ATTR, item.getImageResId());
                    extras.putString(VENUE, item.getAddress());
                    extras.putString(EMAIL, item.getEmail());
                    extras.putString(DETAILS, item.getDetail());
                    extras.putString(FEE, item.getFee());
                    extras.putString(EVENT, item.getTitle());
                    extras.putString(PARTICIPANT, item.getParticipant());
                    extras.putInt(ADPT_POS, 3);
                    Intent intent = new Intent(MainActivity.this, concerts.class);
                    intent.putExtra(BUNDLE_EXTRAS, extras);

// Log.d("extras" ,extras.toString());

                    startActivity(intent);
                } else if (position == 4) {
                    Intent i = new Intent(getApplicationContext(), horscroll.class);
                    startActivity(i);
                } else if (position == 5) {
                    Intent i = new Intent(getApplicationContext(), sports.class);
                    startActivity(i);
                }
            }
        });
*/

        //***********************************DRAWER***************************************

        GridFragment fragment = new GridFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
        */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_MyBookings) {

        } else if (id == R.id.nav_Social_events) {
            Intent i = new Intent(getApplicationContext(), social_events.class);
            startActivity(i);
        }
        else if (id == R.id.nav_Camps) {
            Intent i = new Intent(getApplicationContext(), camps.class);
            startActivity(i);

        }
        else if (id == R.id.nav_Others) {
            Intent i = new Intent(getApplicationContext(), plays.class);
            startActivity(i);
        }
        else if (id == R.id.nav_Concerts) {
            Intent i = new Intent(getApplicationContext(), concerts.class);
            startActivity(i);
        }
        else if (id == R.id.nav_CollegeEvents) {
            Intent i = new Intent(getApplicationContext(), horscroll.class);
            startActivity(i);
        }
        else if (id == R.id.nav_sports) {
            Intent i = new Intent(getApplicationContext(), sports.class);
            startActivity(i);
        }
        else if (id == R.id.nav_Settings) {
            Intent i = new Intent(getApplicationContext(), social_events.class);
            startActivity(i);
        } else if (id == R.id.nav_Signout) {
            Intent i = new Intent(getApplicationContext(), social_events.class);
            startActivity(i);
        }
        else if (id == R.id.nav_Aboutus) {
            Intent i = new Intent(getApplicationContext(), social_events.class);
            startActivity(i);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    }




//************************************************DRAWER ENDS*************************************************************



