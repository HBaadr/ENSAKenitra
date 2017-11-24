package com.badr.hourimeche.ensakenitra.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.badr.hourimeche.ensakenitra.R;
import com.badr.hourimeche.ensakenitra.WebV;
import com.badr.hourimeche.ensakenitra.models.ItemData;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<ItemData> villes;
    private Context context;

    public RecyclerViewAdapter(ArrayList<ItemData> villes, Context context) {

        this.villes = villes;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View BatmanView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(BatmanView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {


        viewHolder.BatTitle.setText(villes.get(position).getName());
        Glide.with(context).load(villes.get(position).getImgUrl()).into(viewHolder.imageView);
        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, WebV.class);
                myIntent.putExtra("name", villes.get(position).getName());
                myIntent.putExtra("url", villes.get(position).getURL());
                context.startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return villes.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        final TextView BatTitle;
        final ImageView imageView;
        final CardView cv;

        ViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.card);
            BatTitle = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.img);

        }
    }


}