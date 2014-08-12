package com.me.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.me.game.jump.ScreenFactory;

/**
 * Created by Black on 2014/8/6.
 */
public class MyJumpGame extends Game {

    private Screen mCurScreen = null;

    @Override
    public void create() {

        mCurScreen = ScreenFactory.createScreen(ScreenFactory.SCREEN_MENU);
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
    }
}
