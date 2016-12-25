package com.example.chaitnya.gallery.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chaitnya.gallery.R;
import com.example.chaitnya.gallery.adapter.TechScrollAdapter;
import com.example.chaitnya.gallery.adapter.recyclerAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Non_technical extends Fragment {


    String[] dept_name={"YCCE","Raisoni","Palloti","Priyadarshani"};
    int[] dept_img={R.drawable.img11,R.drawable.mv2,R.drawable.img22, R.drawable.img33};
    RecyclerView recyclerView1,recyclerView2,recyclerView3;
    recyclerAdapter adapter1,adapter2,adapter3;
    TechScrollAdapter adapter;
    TextView txt;
    RecyclerView.LayoutManager layoutManager1,layoutManager2,layoutManager3;
    ArrayList<Dept> arrayList = new ArrayList<>();
    public Non_technical() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_non_technical,container,false);
        recyclerView1 =(RecyclerView)rootView.findViewById(R.id.Recycler_view1);
        recyclerView2 =(RecyclerView)rootView.findViewById(R.id.Recycler_view2);
        recyclerView3 =(RecyclerView)rootView.findViewById(R.id.Recycler_view3);

        layoutManager1 =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        layoutManager2 =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        layoutManager3 =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);


        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setHasFixedSize(true);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setHasFixedSize(true);
        recyclerView3.setLayoutManager(layoutManager3);
        recyclerView3.setHasFixedSize(true);

        int count = 0;
        for(String Name:dept_name){
            arrayList.add(new Dept(Name,dept_img[count]));
            count++;

        }

        adapter1 = new recyclerAdapter(arrayList,getContext());
        adapter2 = new recyclerAdapter(arrayList,getContext());
        adapter3 = new recyclerAdapter(arrayList,getContext());
        recyclerView1.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);
        recyclerView3.setAdapter(adapter1);
     //   Button button = (Button)rootView.findViewById(R.id.sbutton1);

        return rootView;

          /*  @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Another.class);
                startActivity(intent);
            */


    }

  /*  public void onClick(View view)
    {
        Intent intent = new Intent(this,EventInfo.class);

    }
*/
}
