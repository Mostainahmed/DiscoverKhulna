package com.mostainahmed.discoverkhulna.fireservice;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
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
import java.util.zip.Inflater;

public class FireServiceAdapter extends RecyclerView.Adapter<FireServiceAdapter.FireServiceViewHolder>{

    private Context mCtx;
    private List<FireService> fireServiceList;

    public FireServiceAdapter(Context mCtx, List<FireService> fireServiceList) {
        this.mCtx = mCtx;
        this.fireServiceList = fireServiceList;
    }

    @NonNull
    @Override
    public FireServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_fire_service,null);
        return new FireServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FireServiceViewHolder fireServiceViewHolder, int i) {

        FireService fireService = fireServiceList.get(i);

        final String number = fireServiceList.get(i).getFireServiceNumber();


        fireServiceViewHolder.textViewTitle.setText(fireService.getFireServiceName());
        fireServiceViewHolder.textViewShortDesc.setText(fireService.getFireServiceNumber());
        fireServiceViewHolder.textViewPrice.setText(fireService.getFireLocation());
        fireServiceViewHolder.fireImage.setImageDrawable(mCtx.getResources().getDrawable(fireService.getFireImage()));

        fireServiceViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                passData(number);
            }
        });

    }
    public void passData(String number){

        String uri = "tel:" + number;
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse(uri));
        mCtx.startActivity(i);

//        Intent intent = new Intent(mCtx, DialerActivity.class);
//        intent.putExtra("number", number);
//        mCtx.startActivity(intent);
//        Toast.makeText(mCtx, number, Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return fireServiceList.size();
    }

    class FireServiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewTitle, textViewShortDesc, textViewPrice;
        ImageView fireImage;
        ItemClickListener itemClickListener;

        public FireServiceViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            fireImage = itemView.findViewById(R.id.imageView);
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
