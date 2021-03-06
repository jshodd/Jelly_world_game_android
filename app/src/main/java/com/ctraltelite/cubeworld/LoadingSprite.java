package com.ctraltelite.cubeworld;

/**
 * Created by jshodd on 5/6/16.
 */
public class LoadingSprite extends Sprite{
    public LoadingSprite(Vec2d p,int x){
        super(p,true);
        BitmapSequence s = new BitmapSequence();
        if (x == 1) {
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.loading_1), .05);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.loading_2), .05);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.loading_3), .05);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.loading_4), .05);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.loading_5), .05);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.loading_6), .05);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.loading_5), .05);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.loading_4), .05);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.loading_3), .05);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.loading_2), .05);
        }else{
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.bannana_one), .1);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.bannana_two), .1);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.bannana_three),.1);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.bannana_four),.1);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.bannana_five),.1);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.bannana_six),.1);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.bannana_seven),.1);
            s.addImage(BitmapRepo.getInstance().getImage(R.drawable.bannana_eight),.1);
        }
        setBitmaps(s);
    }

    @Override
    public boolean isActive() {
        return false;
    }

}
