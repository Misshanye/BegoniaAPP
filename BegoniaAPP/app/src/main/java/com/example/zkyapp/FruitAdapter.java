package com.example.zkyapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import android.widget.TextView;


public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(FragmentActivity context, int textViewResourceId, List<Fruit> objects)
    {
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Fruit fruit=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null) {
            viewHolder=new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder.fruitImage= view.findViewById(R.id.fruit_imager);
            viewHolder.fruitName= view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }
        else
        {
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getFruitName());
        return  view;
    }
    class ViewHolder
    {
      public  ImageView fruitImage;
      public TextView fruitName;
    }
}
