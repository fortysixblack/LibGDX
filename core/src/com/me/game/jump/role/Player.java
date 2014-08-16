package com.me.game.jump.role;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.me.game.MyJumpGame;
import com.me.game.jump.SpriteFactory;

/**
 * Created by user on 2014/8/12.
 */
public class Player extends Actor{

    public static final byte STATE_READY = 0;
    public static final byte STATE_RUN = 1;
    public static final byte STATE_JUMP_1 = 2;
    public static final byte STATE_JUMP_2 = 3;
    public static final byte STATE_JUMP_3 = 4;
    public static final byte STATE_FALL = 5;


    Array<Sprite> mRoleFlames = null;
    private Animation mRole = null;
    private int mLastFrameIndex = 0;
    private int mCurrentFrameIndex = 0;

    /*** 当前状态 */
    private byte mState = STATE_READY;


    public Player() {

        mRoleFlames = SpriteFactory.createRole();
        mRole = new Animation(0.05f, mRoleFlames);

        init();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        //TODO 逻辑循环
        loop();

        //TODO 刷新
        if(batch != null) {
           if (mRole != null) {
               mCurrentFrameIndex = mRole.getKeyFrameIndex(MyJumpGame.gCurDelayTime);
               if(mLastFrameIndex != mCurrentFrameIndex) {
                   if(mState == STATE_RUN) {
                       if (mCurrentFrameIndex == 0) {
                           setX(getX() + 120);
                       }
                   }
                   mLastFrameIndex = mCurrentFrameIndex;
               }
               mRoleFlames.get(mLastFrameIndex).setX(getX());
               mRoleFlames.get(mLastFrameIndex).setY(getY());
               mRoleFlames.get(mLastFrameIndex).draw(batch);
           }
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //TODO 启动
        if(mState == STATE_READY) {
            if(Gdx.input.justTouched()) {
                mState = STATE_RUN;
                mRole.setPlayMode(Animation.PlayMode.LOOP);
            }
        }
    }

    /***
     * 角色属性初始化
     */
    private void init() {
        setX(100);
        setY(100);
        setOrigin(70, 70);
        setSize(140, 140);
        if(mRole != null) {
//            mRole.setPlayMode(Animation.PlayMode.NORMAL);
            mRole.setPlayMode(Animation.PlayMode.REVERSED);
        }
    }

    /*** 逻辑循环 */
    private void loop() {
        switch (mState)
        {
            case STATE_READY:
                break;
            case STATE_RUN:
                break;
            case STATE_JUMP_1:
                break;
            case STATE_JUMP_2:
                break;
            case STATE_JUMP_3:
                break;
            case STATE_FALL:
                break;
        }
    }
}
