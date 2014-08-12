package com.me.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.me.game.jump.ScreenFactory;
import com.me.game.jump.SpriteFactory;

/**
 * Created by Black on 2014/8/6.
 */
public class MyJumpGame extends Game {

    private Screen mCurScreen = null;

    @Override
    public void create() {

        SpriteFactory.init();

        changeScreen(ScreenFactory.SCREEN_GAME);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();

        if(mCurScreen != null) {
            mCurScreen.dispose();
            mCurScreen = null;
        }

        SpriteFactory.onDestroy();
    }

    /***
     * 切换界面
     * @param screenIndex
     */
    private void changeScreen(byte screenIndex) {
        if(mCurScreen != null) {
            mCurScreen.dispose();
            mCurScreen = null;
        }
        mCurScreen = ScreenFactory.createScreen(screenIndex);
        setScreen(mCurScreen);
    }
}
