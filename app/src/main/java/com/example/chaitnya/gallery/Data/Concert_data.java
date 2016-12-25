package com.example.chaitnya.gallery.Data;

import com.example.chaitnya.gallery.List_item.Concerts_list;
import com.example.chaitnya.gallery.List_item.Sports_list;
import com.example.chaitnya.gallery.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHAITNYA on 12/24/2016.
 */

public class Concert_data {

    private static final String[] titles = {"PAINTBALL","TECHNOQUIZ","SPORTS","ONE DAY WORKSHOP ON HACKING"};

    private static final String[] participant ={"3","2","5","1"};

    private static final String[] subTitles = {"",
            "",
            "",
            ""};
    private static final String[] month = {"Dec",
            "Jan",
            "Dec",
            "Feb"};
    private static final String[] day = {"Sun",
            "Mon",
            "Tue",
            "Sat"};
    private static final String[] address = {"Khamla Chowk",
            "YCCE Hingna road , Wanadongri ",
            "Raisoni college",
            "Ramdeobaba college"};
    private static final String[] date= {"1","9","30","12"};

    private static final String[] fee= {"200","100","150","100"};

    private static final int[] icon = {R.drawable.img11,R.drawable.img22,R.drawable.img44,R.drawable.img33};

    private static final String[] totaldate = {"1 Dec 2016","9 Jan 2017","30 Dec 2016","12 Feb 2017"};

    private static final String[] time ={"9  AM","10 Onwards","12 PM","3 PM"};

    private static final String[] email ={"hihi@jaiho.com",
            "haha@yoyo.com","hoho@yahoo.com",
            "yumyum@gmail.com"};

    private static final String[] detail = {" our event is awesome u are welcome jsge fhhfhh fehoieihf fufehh \n fvvukeyvv gagggg gfyeuv \n yewv",
            "hihihi aeee hihi yagu iibi iuu \n \t yyfyeyebuy bbyyvhe hfh fieue9 ", "kjdhiuhiu uiubewew iubeuo iuewoiewo onneoe oeewoeoe feee uuewueo oeeobewb biuubi ibbiueiu \n iibiew fiuibeb iuibiebrrb ubgirrbrib eibrir iribbreibri rirbrirb erbreeir ubrb irir  iebreb iuui rurbbi eibreb irbier ibbreii iuubebb ",
            "ya ya tumcha swagat ahe amcha event madhe you are welcome \n jai matat dii"};

    public static List<Concerts_list> getListData() {
        List<Concerts_list> data = new ArrayList<>();

        //Repeat process 4 times, so that we have enough data to demonstrate a scrollable
        //RecyclerView

        //create ListItem with dummy data, then add them to our List
        for (int i = 0; i < titles.length; i++) {
            Concerts_list item = new Concerts_list(icon[i],subTitles[i],titles[i],month[i],date[i],day[i],fee[i],address[i],totaldate[i],
                    time[i],email[i],detail[i],participant[i]);
            data.add(item);
        }

        return data;
    }
}
