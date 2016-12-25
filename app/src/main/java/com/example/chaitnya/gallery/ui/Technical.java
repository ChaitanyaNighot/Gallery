package com.example.chaitnya.gallery.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chaitnya.gallery.R;
import com.example.chaitnya.gallery.adapter.recyclerAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Technical extends Fragment {

    String[] dept_name={"CS","IT","CTECH","ETX"};
    int[] dept_img={R.drawable.img11, R.drawable.img22,R.drawable.img33,R.drawable.img44};
    String[] sort_category={"Department","College","City","IIT"};
    RecyclerView recyclerView1,recyclerView2,recyclerView3;
    TextView t1;
    recyclerAdapter adapter1,adapter2,adapter3;
   // TechScrollAdapter adapter2;
    RecyclerView.LayoutManager layoutManager1,layoutManager2,layoutManager3;
    ArrayList<Dept> arrayList = new ArrayList<>();
    ViewPager viewPager1;
    public Technical() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_technical,container,false);
        recyclerView1 =(RecyclerView)rootView.findViewById(R.id.Recycler_view1);
        recyclerView2 =(RecyclerView)rootView.findViewById(R.id.Recycler_view2);
        recyclerView3 =(RecyclerView)rootView.findViewById(R.id.Recycler_view3);
        layoutManager1 =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        layoutManager2 =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        layoutManager3 =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
       // t1=(TextView)rootView.findViewById(R.id.textview_sort_category);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setHasFixedSize(true);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setHasFixedSize(true);
        recyclerView3.setLayoutManager(layoutManager3);
        recyclerView3.setHasFixedSize(true);

        /* viewPager1=(ViewPager) container.findViewById(R.id.techscroll_view_pager);
        adapter2 = new TechScrollAdapter(this);
        viewPager1.setAdapter(adapter2); */
        int count = 0;
        for(String Name:dept_name){
            arrayList.add(new Dept(Name,dept_img[count]));
           // arrayList.add()
            count++;

        }
      /*  for(int i=0;i<4;i++)
        {
            t1.setText(sort_category[i]);


        }*/



        adapter1 = new recyclerAdapter(arrayList,getActivity().getBaseContext());
        adapter2 = new recyclerAdapter(arrayList,getActivity().getBaseContext());
        adapter3 = new recyclerAdapter(arrayList,getActivity().getBaseContext());
        recyclerView1.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);
        recyclerView3.setAdapter(adapter3);
        return rootView;

    }


}
