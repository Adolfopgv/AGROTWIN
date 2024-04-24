package com.example.agrotwin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    private ArrayList<TextView> textViews;
    private ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        textViews = new ArrayList<>();
        textViews.add(findViewById(R.id.detailDesc));
        textViews.add(findViewById(R.id.detailTitle));
        detailImage = findViewById(R.id.detailImage);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            textViews.get(0).setText(bundle.getInt("Desc"));
            detailImage.setImageResource(bundle.getInt("Image"));
            textViews.get(1).setText(bundle.getString("Title"));
        }
    }
}