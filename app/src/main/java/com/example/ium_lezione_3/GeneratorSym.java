package com.example.ium_lezione_3;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneratorSym {
    private final int max = 10;
    private final int min = 4;
    private  int sectors =0;

    Integer[] colors = new Integer[]{};
    public GeneratorSym(){
    }
    public  ArrayList<Float> fillPercent(){
        float filledPerc=0.0f;

        float sectorPerc=0.0f;
        while( (sectors= (int)(Math.random() * ( max - min )) + min) %2 ==1);
        ArrayList<Float> list =new ArrayList<>();
        Log.d("testing","NUmber of sectors"+sectors);
        for(int i=0;i<sectors/2;i++){
            if(i==sectors/2-1){
                sectorPerc=50-filledPerc;
            }else{
                sectorPerc=(float) ( (Math.random() * ( 50 - filledPerc ))  );
            }

            Log.d("testing",""+sectorPerc);
            list.add(sectorPerc);
            filledPerc+=sectorPerc;
        }
        list=mirror(list);
        Log.d("testing",list.toString());

        return list;
    }
    public  ArrayList<Integer> fillColors(){
        ArrayList<Integer> out = new ArrayList<Integer>();
        ArrayList<Integer> filled = new ArrayList<Integer>();
        filled.addAll(Arrays.asList(
                0xfff44336,0xffe91e63,0xff9c27b0,0xff673ab7,
                0xff3f51b5,0xff2196f3,0xff03a9f4,0xff00bcd4,
                0xff009688,0xff4caf50,0xff8bc34a,0xffcddc39,
                0xffffeb3b,0xffffc107,0xffff9800,0xffff5722,
                0xff795548,0xff9e9e9e,0xff607d8b,0xff333333
                )
        );
        for(int i=0; i< sectors;i++){
            out.add(filled.get(i));
        }
        return out;
    }
    public static ArrayList<Float> mirror(ArrayList<Float> mr) {

            for (int i = mr.size() - 1; i >= 0; i--) {
                mr.add(mr.get(i));
            }

        return mr;
    }
}
