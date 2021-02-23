package com.mostainahmed.discoverkhulna.places;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mostainahmed.discoverkhulna.DetailsActivity;
import com.mostainahmed.discoverkhulna.ItemClickListener;
import com.mostainahmed.discoverkhulna.R;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder>{

    Context mCtx;
    List<Places> placesList;


    public PlacesAdapter(Context mCtx, List<Places> placesList) {
        this.mCtx = mCtx;
        this.placesList = placesList;
    }

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View v = inflater.inflate(R.layout.layout_places, null);
        return new PlacesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder placesViewHolder, int i) {
        final Places places = placesList.get(i);

        final String title = placesList.get(i).getPlaceName();
        final String description = placesList.get(i).getPlaceDescription();
        final String rules = placesList.get(i).getPlaceGoingRules();
        final int imageOne = placesList.get(i).getPlaceImage1();
        final int imageTwo = placesList.get(i).getPlaceImage2();
        final int imageThree = placesList.get(i).getPlaceImage3();
        final double longitude = placesList.get(i).getPlaceLongitude();
        final double latitude= placesList.get(i).getPlaceLatitude();

        placesViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(places.getPlaceImage1()));
        placesViewHolder.textViewTitle.setText(places.getPlaceName());
        placesViewHolder.textViewShortDesc.setText(places.getPlaceDescription());

        placesViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {

                passData(title, description, rules, imageOne, imageTwo, imageThree, longitude, latitude);

            }
        });
    }
    public void passData(String title, String description, String rules, int imageone, int imagetwo, int imagethree, double longitude, double latitude){
        Intent intent = new Intent(mCtx, DetailsActivity.class);

        intent.putExtra("TITLE", title);
        intent.putExtra("DESC", description);
        intent.putExtra("RULES", rules);
        intent.putExtra("ONE", imageone);
        intent.putExtra("TWO", imagetwo);
        intent.putExtra("THREE", imagethree);
        intent.putExtra("LONG", longitude);
        intent.putExtra("LAT", latitude);

        Toast.makeText(mCtx,title,Toast.LENGTH_LONG).show();

        mCtx.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    class PlacesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textViewTitle;
        TextView textViewShortDesc;
        ItemClickListener itemClickListener;

        public PlacesViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.placesImageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);

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
