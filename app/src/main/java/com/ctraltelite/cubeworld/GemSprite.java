package com.ctraltelite.cubeworld;

/**
 * Created by jshodd on 5/3/16.
 */
public class GemSprite extends Sprite {

    public GemSprite(Vec2d p){
        super(p,true);
        BitmapSequence s = new BitmapSequence();
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.gem_one), .1);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.gem_two), .1);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.gem_three), .1);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.gem_four), .1);
        setBitmaps(s);
    }

    @Override
    public boolean isActive() {
        return false;
    }
}
