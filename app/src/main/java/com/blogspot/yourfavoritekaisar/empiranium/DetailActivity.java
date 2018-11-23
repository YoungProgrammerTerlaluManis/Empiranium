package com.blogspot.yourfavoritekaisar.empiranium;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {


    @BindView(R.id.txtDetail)
    TextView txtDetail;
    @BindView(R.id.txt_Bio)
    TextView txtBio;
    @BindView(R.id.imgKerajaan)
    ImageView imgKerajaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        txtDetail.setText(getIntent().getStringExtra("nk"));
        txtBio.setText(getIntent().getStringExtra("dk"));
        Glide.with(this).load(getIntent().getIntExtra("gk", 0)).into(imgKerajaan);
    }
}
