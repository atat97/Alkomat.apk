package com.example.adrian.alkomat;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Bundle extras = getIntent().getExtras();
        double promile = extras.getDouble("extra_promile");
        double czas = extras.getDouble("extra_czas");
        //Toast.makeText(GraphActivity.this, "promile: " + promile, Toast.LENGTH_LONG ).show();
        //Toast.makeText(GraphActivity.this, "czas: " + czas, Toast.LENGTH_SHORT ).show();

        GraphView graph = (GraphView)findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        int t =0;
        for(int i=0;i<=czas;i++){
            series.appendData(new DataPoint(t,promile),true,100);
            promile = promile - 0.12;
            t = t+1;
            if(promile<0) {
                promile = 0;
                series.appendData(new DataPoint(t,promile),true,100);
            }

        }
        graph.addSeries(series);

        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(value, isValueX) + "h";
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX) + "‰";
                }
            }
        });
    }
}
