package com.example.ium_lezione_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PieChartView pieChart =this.findViewById(R.id.piechart);
        GeneratorSym generatorSym=new GeneratorSym();
        Integer[] colors = new Integer[]{0xffedf8fb,0xffb2e2e2,0xff66c2a4,0xff66c2a4};
        pieChart.setPercent(generatorSym.fillPercent());
        pieChart.setSegmentColor(generatorSym.fillColors());

        pieChart.setRadadius(300);
        pieChart.setStrokeColor(Color.BLACK);
        pieChart.setStrokeWidth(4);
    }
}