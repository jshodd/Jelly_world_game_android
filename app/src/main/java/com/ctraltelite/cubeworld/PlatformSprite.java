package com.ctraltelite.cubeworld;

/**
 * Created by shaffer on 4/28/16.
 */
public class PlatformSprite extends Sprite {

    public PlatformSprite(Vec2d p, String type) {
        super(p,false);
        if (type.equals("vertical")) {
            BitmapSequence s = new BitmapSequence();
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.vertical_platform), 1);
            setBitmaps(s);
        }else{
            BitmapSequence s = new BitmapSequence();
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.platform), 1);
            setBitmaps(s);
        }
    }

    @Override
    public boolean isActive() {
        return false;
    }

}
