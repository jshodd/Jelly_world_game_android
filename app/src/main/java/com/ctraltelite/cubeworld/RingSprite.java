package com.ctraltelite.cubeworld;

/**
 * Created by jshodd on 5/4/16.
 */
public class RingSprite extends Sprite{
    public RingSprite(Vec2d p){
        super(p,true);
        BitmapSequence s = new BitmapSequence();
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.ring_one), .05);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.ring_two), .05);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.ring_three), .05);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.ring_four), .05);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.ring_five), .05);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.ring_six), .05);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.ring_five), .05);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.ring_four), .05);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.ring_three), .05);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.ring_two), .05);
        setBitmaps(s);
    }

    @Override
    public boolean isActive() {
        return false;
    }

}
