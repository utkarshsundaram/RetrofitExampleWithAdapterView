package com.example.user.adapterviewwithretrofit.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.adapterviewwithretrofit.Model.Hero;
import com.example.user.adapterviewwithretrofit.R;

import java.util.ArrayList;

/**
 * Created by user on 25/9/17.
 */

public class MyAdpaterFlipper extends BaseAdapter
{
    public Context context;
    public ArrayList<Hero>heros;

    public MyAdpaterFlipper(Context context, ArrayList<Hero> heros) {
        this.context = context;
        this.heros = heros;
    }

    @Override
    public int getCount() {
        return heros.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hero hero= heros.get(position);
        Log.d("the name is",""+heros.get(position).getName());
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adaptive_flipper, null);
        TextView textView = (TextView) view.findViewById(R.id.textViewHerosName);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewHeros);
        textView.setText(hero.getName());
        Glide.with(context).load(hero.getUrl()).into(imageView);
        return view;
    }
}
