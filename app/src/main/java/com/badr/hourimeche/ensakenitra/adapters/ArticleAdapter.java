package com.badr.hourimeche.ensakenitra.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.badr.hourimeche.ensakenitra.R;
import com.badr.hourimeche.ensakenitra.asyncTasks.DownloadImageTask;
import com.badr.hourimeche.ensakenitra.models.Article;
import java.util.ArrayList;



public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private ArrayList<Article> dataList;

    public ArticleAdapter(ArrayList<Article> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.article_title.setText(dataList.get(position).getTitle());
        holder.article_description.setText(dataList.get(position).getDescription());
        new DownloadImageTask(holder.article_image)
                .execute(dataList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        TextView article_title, article_description, article_link;
        ImageView article_image;

        ArticleViewHolder(View itemView) {
            super(itemView);
            article_title = (TextView) itemView.findViewById(R.id.article_title);
            article_description = (TextView) itemView.findViewById(R.id.article_description);
            article_image = (ImageView) itemView.findViewById(R.id.article_image);
        }
    }

}