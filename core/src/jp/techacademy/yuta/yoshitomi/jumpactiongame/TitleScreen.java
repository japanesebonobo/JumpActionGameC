package jp.techacademy.yuta.yoshitomi.jumpactiongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by yoshitomi on 4/10/2018.
 */

public class TitleScreen extends ScreenAdapter {
    static final float GUI_WIDTH = 320;
    static final float GUI_HEIGHT = 480;

    private JumpActionGame mGame;
    Sprite mBg;
    OrthographicCamera mGuiCamera;
    FitViewport mGuiViewPort;
    BitmapFont mFont;

    int mScore;

    public TitleScreen(JumpActionGame game, int score) {

        mGame = game;

        if (mGame.mRequestHandler != null) {
            mGame.mRequestHandler.showAds(true);
        }

        mScore = score;

        Texture bgTexture = new Texture("back2.png");
        mBg = new Sprite(new TextureRegion(bgTexture, 0, 0, 540, 810));
        mBg.setSize(GUI_WIDTH, GUI_HEIGHT);
        mBg.setPosition(0, 0);

        mGuiCamera = new OrthographicCamera();
        mGuiCamera.setToOrtho(false, GUI_WIDTH, GUI_HEIGHT);
        mGuiViewPort = new FitViewport(GUI_WIDTH, GUI_HEIGHT, mGuiCamera);

        mFont = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mGuiCamera.update();
        mGame.batch.setProjectionMatrix(mGuiCamera.combined);

        mGame.batch.begin();
        mFont.draw(mGame.batch, "JumpActionGame" + mScore, 0, GUI_HEIGHT / 2 + 40, GUI_WIDTH, Align.center, false);
        mFont.draw(mGame.batch, "Start?", 0, GUI_HEIGHT / 2 - 40, GUI_WIDTH, Align.center, false);
        mGame.batch.end();

        if (Gdx.input.justTouched()) {
            if (mGame.mRequestHandler != null) {
                mGame.mRequestHandler.showAds(false);
            }
            mGame.setScreen(new GameScreen(mGame));
        }
    }
}