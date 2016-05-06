package com.ctraltelite.cubeworld;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by shaffer on 4/27/16.
 */
public class GameSurfaceView extends SurfaceView {

    private GameLoop gameLoop;
    private World world;

    public GameSurfaceView(Context context) {
        super(context);
        gameLoop = new GameLoop(this);
        world = new World(this);
        connectHolder();
    }


    private void connectHolder() {
        getHolder().addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                gameLoop.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                gameLoop.stop();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawWorld(canvas);
    }

    public void drawWorld(Canvas c) {
        world.draw(c);
    }

    public void tick(double v) {
        world.tick(v);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        TouchEventQueue.get().enqueue(e);
        return true;
    }
    public void removeSprite(Sprite sprite){
        world.removeSprite(sprite);
    }
    public void nextLevel(){
        world.nextLevel();
    }

    public void gameOver() {
        world.gameOver();
    }

    public void restart(){
        world.restart();
    }

}
