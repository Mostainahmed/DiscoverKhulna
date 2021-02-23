package com.mostainahmed.discoverkhulna.website;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mostainahmed.discoverkhulna.ItemClickListener;
import com.mostainahmed.discoverkhulna.R;

import java.util.List;

public class WebListAdapter extends RecyclerView.Adapter<WebListAdapter.WebViewHolder>{

    Context mCtx;
    List<Web> webList;

    public WebListAdapter(Context mCtx, List<Web> webList) {
        this.mCtx = mCtx;
        this.webList = webList;
    }

    @NonNull
    @Override
    public WebViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View v = inflater.inflate(R.layout.layout_web_list, null);
        return new WebViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WebViewHolder webViewHolder, int i) {
        final Web web = webList.get(i);

        final String url = webList.get(i).getWebUrl();
        final String urlTitle = webList.get(i).getWebName();

        webViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(web.getWebImage()));
        webViewHolder.textViewTitle.setText(web.getWebName());
        webViewHolder.textViewShortDesc.setText(web.getWebDescription());
        webViewHolder.textViewPrice.setText(web.getWebUrl());

        webViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                passData(url, urlTitle);
            }
        });
    }
    public void passData(String url, String urlTitle){
        Intent intent = new Intent(mCtx, WebActivity.class);

        intent.putExtra("url", url);
        intent.putExtra("urlname",urlTitle);
        mCtx.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return webList.size();
    }

    class WebViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewTitle, textViewShortDesc, textViewPrice;
        ImageView imageView;
        ItemClickListener itemClickListener;

        public WebViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }
    }

}
