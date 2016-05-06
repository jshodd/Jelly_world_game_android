package com.ctraltelite.cubeworld;

import android.graphics.Canvas;

/**
 * Created by shaffer on 4/27/16.
 */
public class GameLoop implements Runnable {

    private final double FPS = 30;

    private Thread thread;
    private GameSurfaceView view;
    private boolean stopped;

    public GameLoop(GameSurfaceView v) {
        view = v;
        thread = new Thread(this);
        stopped = false;
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        stopped = true;
    }

    @Override
    public void run() {
        while(!stopped && !Thread.interrupted()) {
            long startTime = System.currentTimeMillis();
            updateWorld();
            updateDisplay();
            long endTime = System.currentTimeMillis();
            delay((long)(1000/FPS - (endTime-startTime)));
        }
    }

    private void delay(long v) {
        if (v <= 0) v = 5;
        try {
            Thread.sleep(v);
        } catch (InterruptedException e) {
            stopped = true;
        }
    }

    private void updateDisplay() {
        Canvas c = view.getHolder().lockCanvas();
        if (c != null) {
            try {
                view.drawWorld(c);
            } finally {
                view.getHolder().unlockCanvasAndPost(c);
            }
        }
    }

    private void updateWorld() {
        view.tick(1/FPS);
    }
}
