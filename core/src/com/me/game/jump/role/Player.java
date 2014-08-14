package com.me.game.jump.role;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.me.game.MyJumpGame;
import com.me.game.jump.SpriteFactory;

/**
 * Created by user on 2014/8/12.
 */
public class Player extends Actor{

    private Animation mRole = null;

    public Player() {

        mRole = new Animation(0.05f, SpriteFactory.createRole());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        //TODO 刷新
        if(batch != null) {
           if (mRole != null) {
               batch.draw(mRole.getKeyFrame(MyJumpGame.gCurDelayTime), getX(), getY(), getOriginX(), getOriginY(),getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
           }
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //TODO 启动
        if(mRole != null) {
            mRole.setPlayMode(Animation.PlayMode.LOOP);
            init();
        }
    }

    private void init() {
        setX(100);
        setY(100);
        setOrigin(70,70);
        setSize(140,140);
        setScale(70,70);
    }
}
