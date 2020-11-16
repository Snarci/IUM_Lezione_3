package com.example.ium_lezione_3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.List;

public class PieChartView extends View {
    private int backgroundColor = Color.WHITE;
    private List<Float> percent;
    private List<Integer> segmentColor;
    private RectF enclosing = new RectF();
    private PointF center = new PointF();
    private int radadius =100;
    private int strokeColor;
    private int strokeWidth;
    private int selectedIndex =2;
    private float selectedStartAngle= 0.0f;

    private PointF previousTouch = new PointF (0,0);
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();

        paint.setFlags(Paint.ANTI_ALIAS_FLAG);

        paint.setColor(this.getBackgroundColor());

        Rect rect=new Rect();
        rect.left =0;
        rect.right=getWidth();
        rect.top=0;
        rect.bottom=getHeight();

        canvas.drawRect(rect,paint);
        //percentuale e colore della singola fetta
        float p;
        int c;
        center.x= canvas.getWidth() /2;
        center.y =canvas.getHeight() /2;
        enclosing.top=center.y-radadius;
        enclosing.bottom=center.y+radadius;
        enclosing.left=center.x-radadius;
        enclosing.right=center.x+radadius;

        float alpha = -90.0f;

        float p2a = 360.0f/100.0f;
        //riempie le fette
        for(int i= 0;i < percent.size();i++){
            p=percent.get(i);
            c=segmentColor.get(i);
            paint.setColor(c);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawArc(enclosing,alpha,p*p2a,true,paint);
            alpha+=p*p2a;
        }
        alpha = -90.0f;
        for(int i= 0;i < percent.size();i++){
            p=percent.get(i);
            c=segmentColor.get(i);
            paint.setColor(strokeColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(strokeWidth);
            if(i==selectedIndex){
                selectedStartAngle =alpha;
            }
            canvas.drawArc(enclosing,alpha,p*p2a,true,paint);
            alpha+=p*p2a;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float tx = event.getX();
        float ty = event.getY();

      //  float x = (tx / getZoom()) -getTranslate().x;
       // float y = (ty / getZoom()) -getTranslate().y;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(event.getPointerCount()==1){
                   // selectedIndex =this.pickCorrelation(x,y);
                    this.invalidate();
                    this.previousTouch.x =tx;
                    this.previousTouch.y =ty;
                    return true;
                }
                break;

        }
        return false;
    }

    public PieChartView(Context context) {
        super(context);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public List<Float> getPercent() {
        return percent;
    }

    public void setPercent(List<Float> percent) {
        this.percent = percent;
    }

    public List<Integer> getSegmentColor() {
        return segmentColor;
    }

    public void setSegmentColor(List<Integer> segmentColor) {
        if(segmentColor.size()!= percent.size()){

            throw new  IllegalArgumentException("Liste con differenti dimensioni");

        }
        this.segmentColor = segmentColor;
    }

    public PointF getCenter() {
        return center;
    }

    public void setCenter(PointF center) {
        this.center = center;
    }

    public int getRadadius() {
        return radadius;
    }

    public void setRadadius(int radadius) {
        this.radadius = radadius;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public float getSelectedStartAngle() {
        return selectedStartAngle;
    }

    public void setSelectedStartAngle(float selectedStartAngle) {
        this.selectedStartAngle = selectedStartAngle;
    }
}
