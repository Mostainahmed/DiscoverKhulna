package com.mostainahmed.discoverkhulna.hotel;

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

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder>{
    Context mCtx;
    List<Hotel> hotelList;

    public HotelAdapter(Context mCtx, List<Hotel> hotelList) {
        this.mCtx = mCtx;
        this.hotelList = hotelList;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_hotels, null);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int i) {
        Hotel hotel = hotelList.get(i);

        final String hotelName = hotelList.get(i).getHotelName();
        final String hotelDescription = hotelList.get(i).getHotelDescription();
        final String hotelPrice = hotelList.get(i).getHotelPrice();
        final int imageViewOnew = hotelList.get(i).getHotelImageView();
        final String location = hotelList.get(i).getHotelLocation();
        final String number = hotelList.get(i).getHotelNumber();

        hotelViewHolder.textViewTitle.setText(hotel.getHotelName());
        hotelViewHolder.textViewShortDesc.setText(hotel.getHotelDescription());
        hotelViewHolder.textViewRating.setText(hotel.getHotelRating());
        hotelViewHolder.textViewPrice.setText(hotel.getHotelPrice());
        hotelViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(hotel.getHotelImageView()));
        hotelViewHolder.textViewWeb.setText(hotel.getHotelWebUrl());

        hotelViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                passData(hotelName, hotelDescription, hotelPrice, imageViewOnew, location, number);
            }
        });
    }
    public void passData(String name, String Desc, String price, int image, String location, String number){

//        Intent i = new Intent(mCtx, HotelDetailActivity.class);
//        i.putExtra("name", name);
//        i.putExtra("desc", Desc);
//        i.putExtra("price", price);
//        i.putExtra("image", image);
//        i.putExtra("location", location);
//        i.putExtra("number", number);
//
//        mCtx.startActivity(i);

    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    class HotelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice, textViewWeb;
        ImageView imageView;
        ItemClickListener itemClickListener;
        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle= itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
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
