package com.blogspot.yourfavoritekaisar.empiranium;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterKerajaan extends RecyclerView.Adapter<AdapterKerajaan.ViewHolder> {
    Context context;
    int[] gambarKerajaan;
    String[] namaKerajaan,detailKerajaan;

    public AdapterKerajaan(Context context, int[] gambarKerajaan, String[] namaKerajaan, String[] detailKerajaan) {
        this.context = context;
        this.gambarKerajaan = gambarKerajaan;
        this.namaKerajaan = namaKerajaan;
        this.detailKerajaan = detailKerajaan;
    }


    @NonNull
    @Override
    public AdapterKerajaan.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listkerajaan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKerajaan.ViewHolder viewHolder, final int i) {
        viewHolder.namaKerajaan.setText(namaKerajaan[i]);
        Glide.with(context).load(gambarKerajaan[i]).into(viewHolder.logo);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context,DetailActivity.class);
                pindah.putExtra("nk", namaKerajaan[i]);
                pindah.putExtra("dk", detailKerajaan[i]);
                pindah.putExtra("gk", gambarKerajaan[i]);
                context.startActivity(pindah);
            }
        });


    }

    @Override
    public int getItemCount() { return gambarKerajaan.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView logo;
        TextView namaKerajaan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.imgList);
            namaKerajaan = itemView.findViewById(R.id.namalist);
        }
    }
}
