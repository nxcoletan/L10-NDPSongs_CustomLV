package com.myapplicationdev.android.p10_ndpsongs_clv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYearsReleased);
        TextView tvSinger = rowView.findViewById(R.id.textViewSingers);

        ImageView ivNew = rowView.findViewById(R.id.imageViewNew);
        RatingBar ratingBar = rowView.findViewById(R.id.ratingBar);

        Song currentList = songList.get(position);

        tvTitle.setText(currentList.getTitle());
        tvYear.setText(currentList.getYearReleased());
        tvSinger.setText(currentList.getSingers());
        ratingBar.setRating(currentList.getStars());
        ivNew.setImageResource(R.drawable.newimg);

        if (currentList.getYearReleased() >= 2019) {
            ivNew.setVisibility(View.VISIBLE);
        } else {
            ivNew.setVisibility(View.INVISIBLE);
        }
        return rowView;
    }
}

