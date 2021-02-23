package com.mostainahmed.discoverkhulna.banks.nationalbank;

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

public class BankListAdapter extends RecyclerView.Adapter<BankListAdapter.BankViewHolder>{

    Context mCtx;
    List<Bank> bankList;

    public BankListAdapter(Context mCtx, List<Bank> bankList) {
        this.mCtx = mCtx;
        this.bankList = bankList;
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_bank, null);
        return new BankViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BankViewHolder bankViewHolder, int i) {

        final Bank bank = bankList.get(i);

        final String url = bankList.get(i).getWebUrl();
        final String title = bankList.get(i).getBankName();

        bankViewHolder.textViewTitle.setText(bank.getBankName());
        bankViewHolder.textViewShortDesc.setText(bank.getBankAddress());
        bankViewHolder.textViewPrice.setText(bank.getWebUrl());
        bankViewHolder.textViewWeb.setText(bank.getBankNumber());
        bankViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(bank.getBankImage()));

        bankViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                passData(url, title);
            }
        });

    }
    public void passData(String url, String urlTitle){

//        String uri = "tel:" + number;
//        Intent i = new Intent(Intent.ACTION_DIAL);
//        i.setData(Uri.parse(uri));
//        mCtx.startActivity(i);

        Intent intent = new Intent(mCtx, WebActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("urlname",urlTitle);
        mCtx.startActivity(intent);

//        Intent intent = new Intent(mCtx, DialerActivity.class);
//        intent.putExtra("number", number);
//        mCtx.startActivity(intent);
//        Toast.makeText(mCtx, number, Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return bankList.size();
    }

    class BankViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewTitle, textViewShortDesc, textViewPrice, textViewWeb;
        ImageView imageView;
        ItemClickListener itemClickListener;

        public BankViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle= itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewWeb = itemView.findViewById(R.id.textViewWeb);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);itemView.setOnClickListener(this);
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
