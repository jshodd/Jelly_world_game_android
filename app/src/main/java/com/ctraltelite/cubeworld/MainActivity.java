package com.ctraltelite.cubeworld;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    private static GameSurfaceView GSV;
    private static int currentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BitmapRepo.getInstance().setContext(this);

        GSV = new GameSurfaceView(this);

        setContentView(GSV);
        currentLevel=1;

    }
    public static void removeSprite(Sprite sprite){
        GSV.removeSprite(sprite);
    }
    public static void nextLevel(){
        GSV.nextLevel();
        currentLevel++;
    }
    public static int getCurrentLevel(){
        return currentLevel;
    }

    public static void gameOver() {
        currentLevel++;
        GSV.gameOver();
    }

    public static void restart() {
        currentLevel=1;
        GSV.restart();
    }
}
