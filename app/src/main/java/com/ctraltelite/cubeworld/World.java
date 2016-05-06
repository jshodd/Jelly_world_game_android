package com.ctraltelite.cubeworld;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;

import java.util.ArrayList;

/**
 * Created by shaffer on 4/27/16.
 */
public class World {

    private GameSurfaceView view;
    private ArrayList<Sprite> sprites;
    private Bitmap background;
    private final Handler handler;

    public World(GameSurfaceView view) {
        sprites = new ArrayList<>();
        this.view = view;
        handler = new Handler();


        sprites.add(new PlayerSprite(new Vec2d(50,50)));
        sprites.add(new PlatformSprite(new Vec2d(0,0),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(300,0),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(600,0),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(900,0),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(1000,0),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(0,0),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(0, 200),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(160, 400),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(250, 600),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(425,0),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(425,200),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(0,300),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(0,600),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(1250,0),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(1250,300),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(1250,600),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(0,700),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(300,700),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(600,700),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(900,700),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(1000,700),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(425, 475),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(850, 500),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(685, 200),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(685, 275),"hor"));
        sprites.add(new GemSprite((new Vec2d(200,300))));
        sprites.add(new GemSprite((new Vec2d(500,625))));
        sprites.add(new GemSprite((new Vec2d(550,300))));


        background = BitmapRepo.getInstance().getImage(R.drawable.background);

    }
    public void removeSprite(Sprite sprite){
        sprites.remove(sprite);
    }

    public void draw(Canvas c) {
        // draw background
         c.drawBitmap(background,0, 0, null);

        // draw sprites
        for(Sprite s: sprites)
            s.draw(c);
    }

    public void tick(double t) {
        for(Sprite s: sprites)
            s.tick(t);
        resolve_collisions();
    }

    private void resolve_collisions() {
        ArrayList<Collision> collisions = new ArrayList<>();
        for(int i=0; i < sprites.size()-1; i++)
            for(int j=i+1; j < sprites.size(); j++) {
                Sprite s1 = sprites.get(i);
                Sprite s2 = sprites.get(j);

                if (s1.collidesWith(s2))
                    collisions.add(new Collision(s1, s2));
            }

        for(Collision c: collisions) c.resolve();
    }

    public void nextLevel() {
        sprites.clear();
        background = BitmapRepo.getInstance().getImage(R.drawable.level_one_comp);
        sprites.add(new LoadingSprite((new Vec2d(500,500)),1));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sprites.clear();
                background = BitmapRepo.getInstance().getImage(R.drawable.background2);
                sprites.add(new PlayerSprite(new Vec2d(50,50)));
                sprites.add(new PlatformSprite(new Vec2d(0,0),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(300,0),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(600,0),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(900,0),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(1000,0),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(0,700),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(300,700),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(600,700),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(900,700),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(1000,700),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(1250,0),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(1250,300),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(1250,600),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(0,0),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(0,300),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(0,600),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(200,0),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(0,500),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(200,500),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(200,300),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(700,500),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(700,500),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(500,300),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(800,300),"hor"));
                sprites.add(new RingSprite(new Vec2d(50,600)));
                sprites.add(new RingSprite(new Vec2d(800,600)));
                sprites.add(new RingSprite(new Vec2d(400,50)));


            }
        },5000);


    }

    public void gameOver() {
        sprites.clear();
        background = BitmapRepo.getInstance().getImage(R.drawable.level_two_comp);
        sprites.add(new LoadingSprite((new Vec2d(500,500)),1));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sprites.clear();
                background = BitmapRepo.getInstance().getImage(R.drawable.background3);
                sprites.add(new PlayerSprite(new Vec2d(50,50)));
                sprites.add(new PlatformSprite(new Vec2d(0,0),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(300,0),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(600,0),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(900,0),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(1000,0),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(0,700),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(300,700),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(600,700),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(900,700),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(1000,700),"hor"));
                sprites.add(new PlatformSprite(new Vec2d(1250,0),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(1250,300),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(1250,600),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(0,0),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(0,300),"vertical"));
                sprites.add(new PlatformSprite(new Vec2d(0,600),"vertical"));
                sprites.add(new RingSprite(new Vec2d(1000,500)));

            }
        },5000);

    }

    public void restart() {
        sprites.clear();
        sprites.add(new PlayerSprite(new Vec2d(50,50)));
        sprites.add(new PlatformSprite(new Vec2d(0,0),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(300,0),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(600,0),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(900,0),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(1000,0),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(0,0),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(0, 200),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(160, 400),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(250, 600),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(425,0),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(425,200),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(0,300),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(0,600),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(1250,0),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(1250,300),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(1250,600),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(0,700),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(300,700),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(600,700),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(900,700),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(1000,700),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(425, 475),"hor"));
        sprites.add(new PlatformSprite(new Vec2d(850, 500),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(685, 200),"vertical"));
        sprites.add(new PlatformSprite(new Vec2d(685, 275),"hor"));
        sprites.add(new GemSprite((new Vec2d(200,300))));
        sprites.add(new GemSprite((new Vec2d(500,625))));
        sprites.add(new GemSprite((new Vec2d(550,300))));


        background = BitmapRepo.getInstance().getImage(R.drawable.background);
    }
}
