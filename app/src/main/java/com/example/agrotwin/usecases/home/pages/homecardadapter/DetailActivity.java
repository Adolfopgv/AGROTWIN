package com.example.agrotwin.usecases.home.pages.homecardadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.agrotwin.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Actividad que muestra los detalles de un elemento en la aplicación.
 * Permite al usuario ver información detallada y gráficos relacionados.
 * @author Adrián Carmona Gálvez
 */
public class DetailActivity extends AppCompatActivity {
    private ArrayList<TextView> textViews;
    private ArrayList<Switch> switchs;
    private ArrayList<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        textViews = new ArrayList<>();
        textViews.add(findViewById(R.id.detailTitle));
        textViews.add(findViewById(R.id.Number));

        switchs = new ArrayList<>();
        switchs.add(findViewById(R.id.t_aire));
        switchs.add(findViewById(R.id.t_agua));
        switchs.add(findViewById(R.id.humedad_texto));

        buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.btn_t_agua));
        buttons.add(findViewById(R.id.btn_t_aire));
        buttons.add(findViewById(R.id.btn_humedad));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            textViews.get(0).setText(bundle.getString("Title"));
        }

        configureTopNumbers();
        configureGraphView(switchs);
    }

    private void configureTopNumbers() {
        // Texto cuando se ejecuta la aplicación
        textViews.get(1).setText("53º");

        // Botón de temperatura del aire
        buttons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViews.get(1).setText("42º");
            }
        });

        // Botón de temperatura del agua
        buttons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViews.get(1).setText("24º");
            }
        });

        // Botón de humedad
        buttons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViews.get(1).setText("42%");
            }
        });
    }

    private void configureGraphView(ArrayList<Switch> switchs) {
        // Creación del gráfico
        GraphView graph = findViewById(R.id.graph);
        graphLineal(graph, switchs);
    }

    /**
     * Genera datos aleatorios para el gráfico.
     *
     * @return Un conjunto de puntos de datos aleatorios.
     */
    private DataPoint[] generateData() {
        Random rand = new Random();
        int count = 12;
        DataPoint[] values = new DataPoint[count];
        for (int i=0; i<count; i++) {
            double x = i;
            double f = rand.nextDouble()*0.15+0.3;
            double y = Math.sin(i*f+2) + rand.nextDouble()*0.3;
            DataPoint v = new DataPoint(x, y);
            values[i] = v;
        }
        return values;
    }

    /**
     * Configura el gráfico y sus interruptores asociados.
     *
     * @param graph El objeto GraphView utilizado para mostrar el gráfico.
     * @param switchs Lista para mostrar los botones en forma de switches.
     */
    private void graphLineal(GraphView graph, ArrayList<Switch> switchs) {
        //////////// the switch we use /////////////
        Switch t_aire = switchs.get(0);
        Switch t_agua = switchs.get(1);
        Switch humedad = switchs.get(2);

        ////////// the data of the lines /////////
        DataPoint[] points = generateData();
        DataPoint[] points2 = generateData();
        DataPoint[] points3 = generateData();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(points2);
        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(points3);


        ///////////// Colors and thinknes of the lines ///////////////
        series.setColor(Color.rgb(115,64,13));
        series2.setColor(Color.rgb(255, 227, 205));
        series3.setColor(Color.rgb(188, 143, 101));
        series.setThickness(4);
        series2.setThickness(4);
        series3.setThickness(4);

        ///////////// Cheking if switch is selected ////////////
        graph.addSeries(series);
        // T.Aire
        t_aire.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (t_aire.isChecked()){
                    graph.addSeries(series);
                } else {
                    graph.removeSeries(series);
                }
            }
        });

        // T.Agua
        t_agua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (t_agua.isChecked()){
                    graph.addSeries(series2);
                } else {
                    graph.removeSeries(series2);
                }
            }
        });

        // Humedad
        humedad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (humedad.isChecked()){
                    graph.addSeries(series3);
                } else {
                    graph.removeSeries(series3);
                }
            }
        });

        /////// Configs to be configureable //////////
        graph.getViewport().setScalableY(true);// to be zoomeable
        graph.getGridLabelRenderer().setGridColor(Color.WHITE);// the grid
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);// the lines of the grid
        // the labels
        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.BLACK);
        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.BLACK);
    }
}