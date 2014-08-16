package com.me.game.jump;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

/**
 * Created by user on 2014/8/12.
 */
public class SpriteFactory {

    private static String[] ROLE = {
            "r0",
            "r1",
            "r2",
            "r3",
            "r4",
            "r5",
            "r6",
    };

    private static TextureAtlas mRoleTextureAtlas = null;

    /***
     * 初始化图形资源
     */
    public static void init() {
        mRoleTextureAtlas = new TextureAtlas(Gdx.files.internal("role.txt"));
    }

    /***
     * 创建角色帧表
     * @return
     */
    public static Array<Sprite> createRole() {
        Array<Sprite> tmpFrame = null;
        if(mRoleTextureAtlas != null) {
            tmpFrame = mRoleTextureAtlas.createSprites();
        }
        return tmpFrame;
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
