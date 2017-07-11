package com.cmps115.trades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Daniel on 6/1/2017.
 */

public class ListingAdapter extends ArrayAdapter<ListingEntry> {
    //Constructor
    public ListingAdapter(Context context, ArrayList<ListingEntry> objects){
        super(context, 0, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ListingEntry listing = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_listing, parent, false);
        }

        TextView skill = (TextView) convertView.findViewById(R.id.Name);
        TextView username = (TextView) convertView.findViewById(R.id.User);
        TextView description = (TextView) convertView.findViewById(R.id.Desc);

        skill.setText(listing.getName());

        username.setText(listing.getLister().getEmail()+".edu");

        description.setText(listing.getDesc());


        return convertView;
    }
}