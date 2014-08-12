package com.me.game.jump;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by user on 2014/8/12.
 */
public class SpriteFactory {

    private static TextureAtlas mRoleTextureAtlas = null;

    /***
     * 初始化图形资源
     */
    public static void init() {
        mRoleTextureAtlas = new TextureAtlas(Gdx.files.internal("role.txt"));
    }

    /***
     * 清理资源
     */
    public static void onDestroy() {
        if(mRoleTextureAtlas != null) {
            mRoleTextureAtlas.dispose();
            mRoleTextureAtlas = null;
        }
    }
}
