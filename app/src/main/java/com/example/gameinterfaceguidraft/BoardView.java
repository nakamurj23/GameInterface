package com.example.gameinterfaceguidraft;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

public class BoardView extends SurfaceView {

    //measurements of board
    float boardWidth = 1780.0f;
    float boardHeight = 480.0f;
    float boardOutterLeft = 100.0f; //spelled wrong?
    float boardInnerLeft = 110.0f;
    float boardOutterRight = 1900.0f;
    float boardInnerRight = 1890.0f;
    float boardOutterTop = 200.0f;
    float boardInnerTop = 210.0f;
    float boardOutterBottom = 685.0f;
    float boardInnerBottom = 675.0f;

    //centers of Stores
    float cxLeftStore = ((boardOutterLeft+(boardWidth/45))+(boardOutterLeft+(boardWidth/7)))/2;
    float cyLeftStore = ((boardOutterTop+(boardHeight/10))+boardOutterBottom-(boardHeight/10))/2;
    float cxRightStore = ((boardOutterRight-(boardWidth/45))+(boardOutterRight-boardWidth/7))/2;
    float cyRightStore = ((boardOutterTop+(boardHeight/10))+boardOutterBottom-(boardHeight/10))/2;

    //centers of Pits

    //colors
    Paint black = new Paint();
    Paint brown = new Paint();
    Paint lightBrown = new Paint();
    Paint lightBlue = new Paint();
    Paint number = new Paint();



    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);

        black.setColor(Color.BLACK);
        brown.setColor(Color.rgb(117,65,45));
        lightBrown.setColor(Color.rgb(205,133,63));
        lightBlue.setColor(Color.rgb(74,164,176));
        number.setColor(Color.BLACK);
        number.setTextSize(35);


    }

    //draws blue marble outlined in black
    public void drawMarble(float cx, float cy, Canvas canvas){
        canvas.drawCircle(cx,cy,22.0f,black);
        canvas.drawCircle(cx,cy,20.0f,lightBlue);
    }

    //draws marbles for each pit
    //all same distance from center of pit
    public void drawPitMarbles(float cx, float cy, int numMarbles, Canvas canvas) {
        float radius = 50.0f;
        double angle = 0.0;
        for(int i = 0; i < numMarbles; i++) {
            drawMarble((float) (cx + radius*Math.cos(angle)), (float) (cy + radius*Math.sin(angle)), canvas);
            angle += 2*Math.PI/numMarbles;
        }
    }

    //spreads marbles out more since more marbles will be in the 2 stores at either end
    //uses random arrangement instead of circular
    public void drawStoreMarbles(float cx, float cy, int numMarbles, Canvas canvas) {
        float radius = 80.0f;
        double angle = 0.0;
        for(int i = 0; i < numMarbles; i++) {
            float centerx = (float) (cx + radius*Math.random()*Math.cos(angle));
            float centery = (float) (cy + radius*Math.random()*Math.sin(angle));
            drawMarble(centerx,centery,canvas);
            angle += 2*Math.PI/(Math.random()*15);
        }
    }

    //draws the number of marbles
    public void drawPitMarblesNumber(float cx, float cy, int numMarbles, Canvas canvas){
        for(int i = 0; i < numMarbles; i++) {
            String numStr = new Integer(numMarbles).toString();
            drawMarblesNumber(cx, cy, numStr, canvas);
        }
    }

    //draw the number
    public void drawMarblesNumber(float cx, float cy, String numberStr, Canvas canvas){
        canvas.drawText(numberStr, cx, cy, number);
    }

    public void onDraw(Canvas canvas){
        float width = canvas.getWidth();
        float height = canvas.getHeight();

        canvas.drawRect(boardOutterLeft,boardOutterTop,boardOutterRight, boardOutterBottom, black);
        canvas.drawRect(boardInnerLeft,boardInnerTop, boardInnerRight, boardInnerBottom, brown);

        canvas.drawOval(boardOutterLeft+(boardWidth/45), boardOutterTop+(boardHeight/10), boardOutterLeft+(boardWidth/7), boardOutterBottom-(boardHeight/10), black);
        canvas.drawOval(boardOutterRight-(boardWidth/45), boardOutterTop+(boardHeight/10), boardOutterRight-(boardWidth/7), boardOutterBottom-(boardHeight/10), black);

        canvas.drawOval(boardOutterLeft+(boardWidth/40f), boardOutterTop+(boardHeight/9), boardOutterLeft+(boardWidth/7.18f), boardOutterBottom-(boardHeight/9), lightBrown);
        canvas.drawOval(boardOutterRight-(boardWidth/40f), boardOutterTop+(boardHeight/9), boardOutterRight-(boardWidth/7.18f), boardOutterBottom-(boardHeight/9), lightBrown);


        drawPitMarbles(cxRightStore, cyRightStore, 15, canvas);
        drawStoreMarbles(cxLeftStore, cyLeftStore, 25, canvas);
        drawPitMarblesNumber(cxRightStore + 50, cyRightStore, 15, canvas);
        drawPitMarblesNumber(cxLeftStore - 120, cyLeftStore, 25, canvas);
    }

}
