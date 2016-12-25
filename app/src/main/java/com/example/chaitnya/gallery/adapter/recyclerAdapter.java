package com.example.chaitnya.gallery.adapter;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chaitnya.gallery.Event_detail.Sports_detail;
import com.example.chaitnya.gallery.R;
import com.example.chaitnya.gallery.ui.Dept;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hites on 12/9/2016.
 */

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder>{
    public static ArrayList<Dept> arrayList=new ArrayList<>();
    public recyclerAdapter(ArrayList<Dept> arrayList, Context context)
    {
    this.arrayList=arrayList;
        mContext=context;
    }
    public static Context mContext;


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
     holder.img_dept.setImageResource(arrayList.get(position).getDeptID());
        holder.txt_dept.setText(arrayList.get(position).getName());

       // holder.sort_category.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public  static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_dept;
        TextView txt_dept,sort_category;
        public MyViewHolder(View itemView) {
            super(itemView);

            img_dept=(ImageView)itemView.findViewById(R.id.im_item_icon);
            txt_dept=(TextView)itemView.findViewById(R.id.lbl_item_text);
            CardView cardView= (CardView) itemView.findViewById(R.id.card_item);
            cardView.setOnClickListener(this);
          //  sort_category=(TextView)itemView.findViewById(R.id.textview_sort_category);

        /*   public void eventList(View view) {
               Intent intent = new Intent(this,DerpAdapter.class);
               starActivity(intent);
           }
*/




        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(mContext, com.example.chaitnya.gallery.ui.ListActivity.class);
            arrayList.get(getLayoutPosition());
            mContext.startActivity(intent);



        }
    }
}
