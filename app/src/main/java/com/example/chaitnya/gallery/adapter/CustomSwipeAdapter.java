package com.example.chaitnya.gallery.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.chaitnya.gallery.R;

/**
 * Created by hites on 12/9/2016.
 */

public class CustomSwipeAdapter extends PagerAdapter {

    private int[] image_resources = {R.drawable.a1,R.drawable.g1,R.drawable.g2,R.drawable.mv1,R.drawable.mv2,R.drawable.mv3,R.drawable.mv4,R.drawable.mv5};
    private Context ctx;
    private LayoutInflater layoutInflater ;

    public CustomSwipeAdapter(Context ctx)
    {
        this.ctx=ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view==(LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView =(ImageView)item_view.findViewById(R.id.img_view);
       // TextView textView = (TextView)item_view.findViewById(R.id.img_count);
        imageView.setImageResource(image_resources[position]);
        //textView.setText("Image : " + position);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);

    }

}
