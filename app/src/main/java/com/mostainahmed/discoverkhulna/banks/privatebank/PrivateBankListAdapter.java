package com.mostainahmed.discoverkhulna.banks.privatebank;

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
import com.mostainahmed.discoverkhulna.website.WebActivity;

import java.util.List;

public class PrivateBankListAdapter extends RecyclerView.Adapter<PrivateBankListAdapter.PrivateBankViewHolder>{
    Context mCtx;
    List<PrivateBank> privateBankList;

    public PrivateBankListAdapter(Context mCtx, List<PrivateBank> privateBankList) {
        this.mCtx = mCtx;
        this.privateBankList = privateBankList;
    }

    @NonNull
    @Override
    public PrivateBankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_private_bank, null);
        return new PrivateBankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrivateBankViewHolder privateBankViewHolder, int i) {
        final PrivateBank bank = privateBankList.get(i);

        final String url = privateBankList.get(i).getBankWebUrl();
        final String title = privateBankList.get(i).getBankName();

        privateBankViewHolder.textViewTitle.setText(bank.getBankName());
        privateBankViewHolder.textViewWeb.setText(bank.getBankWebUrl());
        privateBankViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(bank.getPrivateBankImage()));

        privateBankViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                passData(url, title);
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
        return privateBankList.size();
    }


    class PrivateBankViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewTitle, textViewWeb;
        ImageView imageView;
        ItemClickListener itemClickListener;
        public PrivateBankViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle= itemView.findViewById(R.id.textViewTitle);
            textViewWeb = itemView.findViewById(R.id.textViewWeb);
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
