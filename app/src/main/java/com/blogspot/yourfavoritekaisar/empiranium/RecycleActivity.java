package com.blogspot.yourfavoritekaisar.empiranium;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    String[] namaKerajaan,detailKerajaan;
    int[] gambarKerajaan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        namaKerajaan = getResources().getStringArray(R.array.mNamaKerajaan);
        detailKerajaan = getResources().getStringArray(R.array.mDetailKerjanaan);
        gambarKerajaan = new int[]{R.drawable.abbasid,R.drawable.britishpng
                ,R.drawable.french,R.drawable.mongol,R.drawable.qing,R.drawable.ottoman
                ,R.drawable.spanishmp,R.drawable.roman,R.drawable.russianemp};

        AdapterKerajaan MadapterKerajaan = new AdapterKerajaan(RecycleActivity.this, gambarKerajaan,namaKerajaan,detailKerajaan);


        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecyclerView.setAdapter((RecyclerView.Adapter) MadapterKerajaan);


    }
}
