package com.me.game.jump.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.me.game.jump.role.GameBG;
import com.me.game.jump.role.Player;

/**
 * Created by Black on 2014/8/6.
 */
public class GameScreen implements Screen {

    private Stage mStage = null;
    private Player mPlayer = null;
    private DrawMap mBGPen = null;

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);

        GameBG.onLoop();

        mStage.act(delta);
        mStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        mStage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
        mStage = new Stage(new ScalingViewport(Scaling.fill, 800, 480));

        mBGPen = new DrawMap();
        GameBG.onInit(mBGPen);
        mStage.addActor(GameBG.getStageHandle());

        mPlayer = new Player();
        mStage.addActor(mPlayer);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

        if(mBGPen != null) {
            mBGPen.dispose();
            mBGPen = null;
        }

        GameBG.onDestroy();

        if(mPlayer != null) {
            mPlayer = null;
        }

        if(mStage != null) {
            mStage.dispose();
            mStage = null;
        }
    }

    /***
     * 画背景
     */
    public class DrawMap implements GameBG.DrawHandle {

        public DrawMap() {
        }

        @Override
        public void draw(Pixmap pen) {
            pen.fillRectangle(0, 350, 800, 20);
        }

        /*** 销毁 */
        public void dispose() {
        }
    }
}
