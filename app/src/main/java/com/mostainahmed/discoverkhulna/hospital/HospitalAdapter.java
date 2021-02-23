package com.mostainahmed.discoverkhulna.hospital;

import android.content.Context;
import android.content.Intent;
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

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>{

    private Context mCtx;
    private List<Hospital> hospitalList;

    public HospitalAdapter(Context mCtx, List<Hospital> hospitalList) {
        this.mCtx = mCtx;
        this.hospitalList = hospitalList;
    }

    @NonNull
    @Override
    public HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_hospital, null);
        return new HospitalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalViewHolder hospitalViewHolder, int i) {
        Hospital hospital = hospitalList.get(i);

        final String number = hospitalList.get(i).getHospitalNumber();

        hospitalViewHolder.textViewTitle.setText(hospital.getHospitalName());
        hospitalViewHolder.textViewShortDesc.setText(hospital.getHospitalNumber());
        hospitalViewHolder.textViewPrice.setText(hospital.getHospitalLocation());
        hospitalViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(hospital.getHospitalImage()));

        hospitalViewHolder.setItemClickListener(new ItemClickListener() {
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
        return hospitalList.size();
    }

    class HospitalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewTitle, textViewShortDesc, textViewPrice;
        ImageView imageView;
        ItemClickListener itemClickListener;

        public HospitalViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle= itemView.findViewById(R.id.textViewTitle);
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
