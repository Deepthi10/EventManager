package edu.ecu.cs.eventapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class Adapter extends BaseAdapter {
    String [] result;
    Context context;
    int [] imageId;
    //String[] detail;

    //This is the adapter for home page

    public Adapter(EventActivity eventActivity, String[] pgmNameList, int[] pgmImages) {
        result=pgmNameList;
        context=eventActivity;
        imageId=pgmImages;
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //  Holder holder=new Holder();
        View rowView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(R.layout.evendetail, null);
      /*  holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);*/

        ImageView img1=(ImageView)rowView.findViewById(R.id.imageView);
        TextView tv1=(TextView)rowView.findViewById(R.id.textView1);
        img1.setImageResource(imageId[position]);
        tv1.setText(result[position]);

        return rowView;
    }
}