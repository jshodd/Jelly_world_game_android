package com.ctraltelite.cubeworld;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;

/**
 * Created by shaffer on 4/27/16.
 */
public abstract class Sprite {

    private BitmapSequence bitmaps;
    protected Vec2d position;
    Boolean isGem;


    public Sprite(Vec2d v,Boolean isGem) {
        setPosition(v);
        this.isGem = isGem;
    }

    public void setBitmaps(BitmapSequence b) {
        bitmaps = b;
    }

    public void setPosition(Vec2d p) {
        position = p;
    }

    public Vec2d getPosition() {
        return position;
    }

    public void draw(Canvas c) {
        bitmaps.drawCurrent(c, position.getX(), position.getY(), null);
    }

    public void tick(double dt) {
        bitmaps.tick(dt);
    }

    public boolean isGem(){
        return isGem;
    }

    public RectF getBoundingBox() {
        PointF size = bitmaps.getSize();
        return new RectF(getPosition().getX(),getPosition().getY(),getPosition().getX()+size.x,getPosition().getY()+size.y);
    }

    public boolean collidesWith(Sprite other) {
        boolean result = intersectionWith(other) != null;
        return result;
    }

    /**
     * Return null if I don't intersect with other, otherwise return the overlap of our two bounding boxes.
     *
     * @param other
     * @return
     */
    public RectF intersectionWith(Sprite other) {
        RectF r = new RectF(getBoundingBox());
        if (!r.intersect(other.getBoundingBox()))
            return null;
        else
            return r;
    }

    public abstract boolean isActive();

    public void resolve(Collision collision, Sprite other) {

    }


}
