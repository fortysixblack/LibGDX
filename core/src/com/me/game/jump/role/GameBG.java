package com.me.game.jump.role;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/***
 * 游戏地图模块
 * Created by Black on 2014/8/16.
 */
public class GameBG {
    private Texture mBG = null;
    private Pixmap mPix = null;
    private Image mImage = null;
    private DrawHandle mDrawHandle = null;

    public GameBG(DrawHandle pen) {
        mBG = new Texture(800, 480, Pixmap.Format.RGBA8888);

        mPix = new Pixmap(800, 480, Pixmap.Format.RGBA8888);
        mPix.setColor(Color.BLACK);

        mImage = new Image(mBG);

        mDrawHandle = pen;
    }

    public Image getCurBG() {
        return mImage;
    }

    /*** 循环刷新 */
    public void loop() {
        if(mDrawHandle != null) {
            mDrawHandle.draw(mPix);
        }
        mBG.draw(mPix, 0, 0);
    }

    /*** 销毁 */
    public void dispose() {

        if(mDrawHandle != null) {
            mDrawHandle = null;
        }

        if(mImage != null) {
            mImage = null;
        }

        if(mPix != null) {
            mPix.dispose();
            mPix = null;
        }

        if(mBG != null) {
            mBG.dispose();
            mBG = null;
        }
    }

    public interface DrawHandle {
        public void draw(Pixmap pen);
    }
}
