package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.HUD;
import ru.hegemonicaremake.gameplay.LogicMain;

public class CountryButton extends TextButton {
    public CountryButton(Stage stage, final HUD hud) {
        super("Country", HegeGame.skinManager.shimmerSkin);
        getLabel().setStyle(HegeGame.skinManager.playingInfoStyle);
        setRound(true);
        setSize(HegeGame.width * 0.3f, HegeGame.height * 0.2f);
        setPosition(0, HegeGame.height - getHeight());
        stage.addActor(this);
        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
    
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                hud.openCountryInfo(LogicMain.turnCountry);
            }
        });
    }
}
