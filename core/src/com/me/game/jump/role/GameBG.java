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

    private static GameBG instance = null;

    /*** 构造 */
    private GameBG(DrawHandle pen) {
        mBG = new Texture(800, 480, Pixmap.Format.RGBA8888);

        mPix = new Pixmap(800, 480, Pixmap.Format.RGBA8888);
        mPix.setColor(Color.BLACK);

        mImage = new Image(mBG);

        mDrawHandle = pen;
    }

    /*** 获取舞台需要的句柄 */
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

    /***
     * 创建一个地图
     * @param pen
     */
    public static void onInit(DrawHandle pen) {
        if(instance == null) {
            instance = new GameBG(pen);
        }
    }

    /***
     * 地图添加到舞台的句柄
     * @return
     */
    public static Image getStageHandle() {
        if(instance != null) {
            return instance.getCurBG();
        }
        return null;
    }

    /***
     * 地图刷新循环
     */
    public static void onLoop() {
        if(instance != null) {
            instance.loop();
        }
    }

    /***
     * 地图模块销毁
     */
    public static void onDestroy() {
        if(instance != null) {
            instance.dispose();
            instance = null;
        }
    }

    public interface DrawHandle {
        public void draw(Pixmap pen);
    }
}
