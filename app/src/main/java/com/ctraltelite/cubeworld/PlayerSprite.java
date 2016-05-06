package com.ctraltelite.cubeworld;

import android.util.Log;
import android.view.MotionEvent;

public class PlayerSprite extends PhysicalSprite {

    private int gemCount;
    private int currentLevel;

    public PlayerSprite(Vec2d v) {
        super(v);
        BitmapSequence s = new BitmapSequence();
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.jelly_one), .1);
        s.addImage(BitmapRepo.getInstance().getImage(R.drawable.jelly_two), .1);
        setBitmaps(s);
        gemCount=0;
        currentLevel=1;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void tick(double dt) {
        MotionEvent e = TouchEventQueue.get().dequeue();
        if (e != null && e.getAction() == MotionEvent.ACTION_DOWN) {
            if (e.getY() < 200) {
                setVelocity((new Vec2d(0, -200)));
            } else if (e.getX() < 200) {
                setVelocity((new Vec2d(-200, 0)));
            } else if (e.getX() > 800) {
                setVelocity((new Vec2d(200, 0)));
            } else if (e.getY() > 600) {
                setVelocity((new Vec2d(0, 200)));
            }
        }
        super.tick(dt);
    }


    public void resolve(Collision collision, Sprite other) {
        if (other.isGem()) {
            MainActivity.removeSprite(other);
            gemCount++;
            if (MainActivity.getCurrentLevel()==3){
                MainActivity.restart();
            }else if (gemCount==3){
                if (MainActivity.getCurrentLevel()==1) {
                    MainActivity.nextLevel();
                }else if (MainActivity.getCurrentLevel()==2){
                    MainActivity.gameOver();
                }
            }
        } else {
            Log.w("collision","stopping");
            if (getVelocity().getX()>0){
                Log.w("collision","Right");
                setPosition(new Vec2d(getPosition().getX()-7,getPosition().getY()));
            }else if(getVelocity().getX()<0){
                setPosition(new Vec2d(getPosition().getX()+7,getPosition().getY()));
            }else if(getVelocity().getY()>0){
                setPosition(new Vec2d(getPosition().getX(),getPosition().getY()-7));
            }else if(getVelocity().getY()<0){
                setPosition(new Vec2d(getPosition().getX(),getPosition().getY()+7));

            }
            setVelocity(new Vec2d(0, 0));

            /*if (getPosition().getX() > other.getPosition().getX()) {
                if (getPosition().getY() > other.getPosition().getY()) {
                    setPosition(new Vec2d(getPosition().getX() + 1, getPosition().getY() + 1));
                } else {
                    setPosition(new Vec2d(getPosition().getX() + 1, getPosition().getY() - 1));
                }
            } else {
                if (getPosition().getY() > other.getPosition().getY()) {
                    setPosition(new Vec2d(getPosition().getX() - 1, getPosition().getY() + 1));
                } else {
                    setPosition(new Vec2d(getPosition().getX() - 1, getPosition().getY() - 1));
                }
            }*/
        }
    }

}
