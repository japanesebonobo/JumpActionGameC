package jp.techacademy.yuta.yoshitomi.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by yoshitomi on 4/1/2018.
 */

public class Enemy extends GameObject
{
    public static final float ENEMY_WIDTH = 0.8f;
    public static final float ENEMY_HEIGHT = 0.8f;

    public static final int ENEMY_EXIST = 0;

    public static final int ENEMY_TYPE_STATIC = 0;
    public static final int ENEMY_TYPE_MOVING = 1;

    public static final float ENEMY_VELOCITY = 1.0f;

    int mState;
    int mType;

    public Enemy(int type, Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        mState = ENEMY_EXIST;
        mType = type;
        if (mType == ENEMY_TYPE_MOVING) {
            velocity.x = ENEMY_VELOCITY;
        }
    }

    public void update2(float deltaTime) {
        if (mType == ENEMY_TYPE_MOVING) {
            setX(getX() + velocity.x * deltaTime);

            if (getX() < ENEMY_WIDTH / 2) {
                velocity.x = -velocity.x;
                setX(ENEMY_WIDTH / 2);
            }
            if (getX() > GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2) {
                velocity.x = -velocity.x;
                setX(GameScreen.WORLD_WIDTH - ENEMY_WIDTH /2);
            }
        }
    }
}