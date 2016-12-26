package com.example.chaitnya.gallery.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.chaitnya.gallery.List_item.Social_event_list;
import com.example.chaitnya.gallery.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHAITNYA on 12/24/2016.
 */

public class socialEventAdapter extends RecyclerView.Adapter<socialEventAdapter.DerpHolder>{

    private List<Social_event_list> listData;
    private LayoutInflater inflater;
    private Context mcontext;
    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback {
        void onItemClick(int p);
        void onSecondaryIconClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public socialEventAdapter(List<Social_event_list> listData, Context mcontext){
        inflater = LayoutInflater.from(mcontext);
        this.listData = listData;
        this.mcontext=mcontext;
    }

    @Override
    public socialEventAdapter.DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new DerpHolder(view);
    }

    @Override
    public void onBindViewHolder(DerpHolder holder, int position) {
        YoYo.with(Techniques.FadeIn).playOn(holder.cardView);
        Social_event_list item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
        holder.date.setText(item.getDate());
        holder.day.setText(item.getDay());
        holder.month.setText(item.getMonth());
        holder.fee.setText(item.getFee());
        holder.address.setText(item.getAddress());
        Glide.with(mcontext).load(item.getImageResId()).into(holder.thumbnail);

        /*if (item.isFavourite()){
            holder.secondaryIcon.setImageResource(R.drawable.ic_star_black_24dp);
        } else {
            holder.secondaryIcon.setImageResource(R.drawable.ic_star_border_black_24dp);
        }*/
    }

    public void setListData(ArrayList<Social_event_list> exerciseList) {
        this.listData.clear();
        this.listData.addAll(exerciseList);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class DerpHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView thumbnail;
        //ImageView secondaryIcon;
        TextView title,month,date, day, fee, address;
        TextView subTitle;
        View container;
        Button load;
        CardView cardView;
        Social_event_list item;


        public DerpHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView)itemView.findViewById(R.id.im_item_icon);
            // secondaryIcon = (ImageView)itemView.findViewById(R.id.im_item_icon_secondary);
            // secondaryIcon.setOnClickListener(this);
            subTitle = (TextView)itemView.findViewById(R.id.lbl_item_sub_title);
            title = (TextView)itemView.findViewById(R.id.lbl_item_text);
            month =(TextView)itemView.findViewById(R.id.txtview_month);
            day =(TextView)itemView.findViewById(R.id.txtview_day);
            date =(TextView)itemView.findViewById(R.id.txtview_date);
            address=(TextView)itemView.findViewById(R.id.txtview_address);
            fee=(TextView)itemView.findViewById(R.id.Rs);
            cardView=(CardView)itemView.findViewById(R.id.card_item);
            container = (View)itemView.findViewById(R.id.cont_item_root);
            load = (Button)itemView.findViewById(R.id.btn_card_load);
            cardView.setOnClickListener(this);
            load.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.card_item){
                itemClickCallback.onItemClick(getAdapterPosition());
                // it was else part itemClickCallback.onSecondaryIconClick(getAdapterPosition());
            } else if(v.getId()==R.id.btn_card_load){

                itemClickCallback.onSecondaryIconClick(getAdapterPosition());

            }
        }
    }
}