package com.example.gameinterfaceguidraft;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class BoardView extends SurfaceView {
    // pocket circle radius
    float radius = 90f;

    // pocket circle paints
    Paint black = new Paint();
    Paint lightBrown = new Paint();

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
    }

    /** onDraw method draws the game board and pockets. */
    public void onDraw(Canvas canvas){
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
        float ovalTop = 248f;
        float ovalBottom = 637f;

        Paint black = new Paint();
        Paint brown = new Paint();
        Paint lightBrown = new Paint();

        // pallet setup
        black.setColor(Color.BLACK);
        brown.setColor(Color.rgb(117,65,45));
        lightBrown.setColor(Color.rgb(205,133,63));

        // Draws board
        canvas.drawRect(boardOutterLeft,boardOutterTop,boardOutterRight, boardOutterBottom, black);
        canvas.drawRect(boardInnerLeft,boardInnerTop, boardInnerRight, boardInnerBottom, brown);

        // Draws left oval
        canvas.drawOval(boardOutterLeft+(boardWidth/45), boardOutterTop+(boardHeight/10), boardOutterLeft+(boardWidth/7), boardOutterBottom-(boardHeight/10), black);
        canvas.drawOval(boardOutterLeft+(boardWidth/40f), boardOutterTop+(boardHeight/9), boardOutterLeft+(boardWidth/7.18f), boardOutterBottom-(boardHeight/9), lightBrown);

        // Draws right oval
        canvas.drawOval(boardOutterRight-(boardWidth/45), boardOutterTop+(boardHeight/10), boardOutterRight-(boardWidth/7), boardOutterBottom-(boardHeight/10), black);
        canvas.drawOval(boardOutterRight-(boardWidth/40f), boardOutterTop+(boardHeight/9), boardOutterRight-(boardWidth/7.18f), boardOutterBottom-(boardHeight/9), lightBrown);


        for(int i = 0; i < 6; i++){
            // Draws top row of pockets
            float cxTop = 363.78f + radius + (i * (1487.1f/7f));
            float cyTop = ovalTop + radius;
            drawPocket(canvas, cxTop, cyTop, radius);

            // Draws bottom row of pockets
            float cxBottom = 363.78f + radius + (i * (1487.1f/7f));
            float cyBottom = ovalBottom - radius;
            drawPocket(canvas, cxBottom, cyBottom, radius);
        }

    }

    /** draws pockets at coordinates cx and cy with specified radius */
    public void drawPocket(Canvas canvas, float cx, float cy, float radius){
        // Outter circle
        black.setColor(Color.BLACK);
        canvas.drawCircle(cx ,cy, radius, black);

        // Inner circle
        lightBrown.setColor(Color.rgb(205,133,63));
        canvas.drawCircle(cx ,cy, radius - 5, lightBrown);
    }
}
