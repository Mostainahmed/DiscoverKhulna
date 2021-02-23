package com.mostainahmed.discoverkhulna.policestation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mostainahmed.discoverkhulna.DialerActivity;
import com.mostainahmed.discoverkhulna.ItemClickListener;
import com.mostainahmed.discoverkhulna.R;

import java.util.List;

public class PoliceStationAdapter extends RecyclerView.Adapter<PoliceStationAdapter.PoliceStationViewHolder>{

    private Context mCtx;
    List<PoliceStation> policeStationList;

    public PoliceStationAdapter(Context mCtx, List<PoliceStation> policeStationList) {
        this.mCtx = mCtx;
        this.policeStationList = policeStationList;
    }

    @NonNull
    @Override
    public PoliceStationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_police_station,null);
        return new PoliceStationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PoliceStationViewHolder policeStationViewHolder, int i) {
        final PoliceStation policeStation = policeStationList.get(i);

        final String number = policeStationList.get(i).getPoliceStationNumber();

        policeStationViewHolder.textViewTitle.setText(policeStation.getPoliceStationName());
        policeStationViewHolder.textViewShortDesc.setText(policeStation.getPoliceStationNumber());
        policeStationViewHolder.textViewPrice.setText(policeStation.getPoliceLocation());
        policeStationViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(policeStation.getPoliceImage()));

        policeStationViewHolder.setItemClickListener(new ItemClickListener() {
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
        return policeStationList.size();
    }

    class PoliceStationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewTitle, textViewShortDesc, textViewPrice;
        ImageView imageView;
        ItemClickListener itemClickListener;

        public PoliceStationViewHolder(@NonNull View itemView) {
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
