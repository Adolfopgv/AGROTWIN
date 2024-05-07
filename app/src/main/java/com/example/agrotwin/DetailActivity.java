package com.example.agrotwin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

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
            textViews.get(1).setText(bundle.getString("Title"));
        }

        graphLineal();
    }

    private void graphLineal() {
        // creando la grafica donde se va a imprimir
        GraphView graph = (GraphView) findViewById(R.id.graph);

        // 1º valor
        DataPoint[] points = {
                new DataPoint(0, 5),
                new DataPoint(1, 10),
                new DataPoint(2, 15),
                new DataPoint(3, 20),
                new DataPoint(4, 15),
                new DataPoint(5, 10),
                new DataPoint(6, 5),
                new DataPoint(7, 0),
                new DataPoint(8, 5),
                new DataPoint(9, 10),
                new DataPoint(10, 15),
                new DataPoint(11, 20)
        };
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);

        // 2º valor
        DataPoint[] points2 = {
                new DataPoint(0, 20),
                new DataPoint(1, 15),
                new DataPoint(2, 10),
                new DataPoint(3, 5),
                new DataPoint(4, 0),
                new DataPoint(5, 5),
                new DataPoint(6, 10),
                new DataPoint(7, 15),
                new DataPoint(8, 20),
                new DataPoint(9, 15),
                new DataPoint(10, 10),
                new DataPoint(11, 5)
        };
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(points2);

        // 3º valor
        DataPoint[] points3 = {
                new DataPoint(0, 10),
                new DataPoint(1, 15),
                new DataPoint(2, 20),
                new DataPoint(3, 25),
                new DataPoint(4, 20),
                new DataPoint(5, 15),
                new DataPoint(6, 10),
                new DataPoint(7, 5),
                new DataPoint(8, 10),
                new DataPoint(9, 15),
                new DataPoint(10, 20),
                new DataPoint(11, 25)
        };
        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(points3);


        // colores del primer valor
        series.setColor(Color.rgb(115,64,13));
        series.setThickness(4);

        // colores del segundo valor
        series2.setColor(Color.rgb(255, 227, 205));
        series2.setThickness(4);

        // colores del tercer valor
        series3.setColor(Color.rgb(188, 143, 101));
        series3.setThickness(4);

        // añadirmos los valores
        graph.addSeries(series);
        graph.addSeries(series2);
        graph.addSeries(series3);

        // to be zoomeable
        graph.getViewport().setScalableY(true);

        // the grid
        graph.getGridLabelRenderer().setGridColor(Color.WHITE);

        // the lines of the grid
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);

        // the labels
        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.BLACK);
        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.BLACK);
    }
}