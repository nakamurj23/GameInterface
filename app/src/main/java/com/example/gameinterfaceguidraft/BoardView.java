package com.example.gameinterfaceguidraft;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

public class BoardView extends SurfaceView {

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
    }

    public void onDraw(Canvas canvas){
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        float boardWidth = 1780.0f;
        float boardHeight = 480.0f;
        float boardOutterLeft = 100.0f;
        float boardInnerLeft = 110.0f;
        float boardOutterRight = 1900.0f;
        float boardInnerRight = 1890.0f;
        float boardOutterTop = 200.0f;
        float boardInnerTop = 210.0f;
        float boardOutterBottom = 685.0f;
        float boardInnerBottom = 675.0f;


        Paint black = new Paint();
        Paint brown = new Paint();
        Paint lightBrown = new Paint();

        black.setColor(Color.BLACK);
        brown.setColor(Color.rgb(117,65,45));
        lightBrown.setColor(Color.rgb(205,133,63));

        canvas.drawRect(boardOutterLeft,boardOutterTop,boardOutterRight, boardOutterBottom, black);
        canvas.drawRect(boardInnerLeft,boardInnerTop, boardInnerRight, boardInnerBottom, brown);

        canvas.drawOval(boardOutterLeft+(boardWidth/45), boardOutterTop+(boardHeight/10), boardOutterLeft+(boardWidth/7), boardOutterBottom-(boardHeight/10), black);
        canvas.drawOval(boardOutterRight-(boardWidth/45), boardOutterTop+(boardHeight/10), boardOutterRight-(boardWidth/7), boardOutterBottom-(boardHeight/10), black);

        canvas.drawOval(boardOutterLeft+(boardWidth/40f), boardOutterTop+(boardHeight/9), boardOutterLeft+(boardWidth/7.18f), boardOutterBottom-(boardHeight/9), lightBrown);
        canvas.drawOval(boardOutterRight-(boardWidth/40f), boardOutterTop+(boardHeight/9), boardOutterRight-(boardWidth/7.18f), boardOutterBottom-(boardHeight/9), lightBrown);

    }
}
