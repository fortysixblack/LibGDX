package com.me.game.jump;

import com.badlogic.gdx.Screen;
import com.me.game.jump.screen.EndScreen;
import com.me.game.jump.screen.GameScreen;
import com.me.game.jump.screen.MenuScreen;

public class ScreenFactory {

    public static final byte SCREEN_NONE = -1;
    public static final byte SCREEN_MENU = 0;
    public static final byte SCREEN_GAME = 1;
    public static final byte SCREEN_END = 2;
    private static byte mCurScreenIndex = SCREEN_NONE;

    public static Screen createScreen(byte type) {
        Screen tmpScr = null;
        if(mCurScreenIndex != type) {
            switch (type) {
                case SCREEN_END:
                    tmpScr = new EndScreen();
                    break;
                case SCREEN_GAME:
                    tmpScr = new GameScreen();
                    break;
                case SCREEN_MENU:
                    tmpScr = new MenuScreen();
                    break;
                default:
                    break;
            }
            mCurScreenIndex = type;
        }
        return tmpScr;
    }

    /***
     * 获得当前的界面
     * @return
     */
    public static byte getCurrentScreenType() {
        return mCurScreenIndex;
    }
}