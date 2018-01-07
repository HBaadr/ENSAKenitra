package com.badr.hourimeche.ensakenitra.adapters;


import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.badr.hourimeche.ensakenitra.R;
import com.badr.hourimeche.ensakenitra.asyncTasks.DownloadImageTask;
import com.badr.hourimeche.ensakenitra.models.Gallery;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private ArrayList<Gallery> dataList;

    public GalleryAdapter(ArrayList<Gallery> dataList) {
        this.dataList = dataList;
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_gallery, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        holder.gallery_name.setText(dataList.get(position).getAlbum_name());
        holder.gallery_total.setText(dataList.get(position).getAlbum_photos_number());
        new DownloadImageTask(holder.gallery_image)
                .execute(dataList.get(position).getAlbum_photo());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {

        TextView gallery_total, gallery_name;
        ImageView gallery_image ;

        GalleryViewHolder(View itemView) {
            super(itemView);
            gallery_name = (TextView) itemView.findViewById(R.id.gallery_name);
            gallery_total = (TextView) itemView.findViewById(R.id.gallery_number);
            gallery_image = (ImageView) itemView.findViewById(R.id.gallery_image);
        }
    }
}