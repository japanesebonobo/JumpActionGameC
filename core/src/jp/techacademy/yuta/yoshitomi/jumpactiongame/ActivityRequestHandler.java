package jp.techacademy.yuta.yoshitomi.jumpactiongame;

import javax.naming.Context;

/**
 * Created by yoshitomi on 3/31/2018.
 */

public interface ActivityRequestHandler {
    public void showAds(boolean show);

    public void YajyunoHoukou();

    public void PlayerDeath();

    public void Bgm();
}
