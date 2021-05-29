package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import ru.hegemonicaremake.HegeGame;

public class CountryButton extends TextButton {
    public CountryButton(Stage stage) {
        super("Country", HegeGame.skinManager.shimmerSkin);
        getLabel().setStyle(HegeGame.skinManager.playingInfoStyle);
        setRound(true);
        setSize(HegeGame.width * 0.3f, HegeGame.height * 0.2f);
        setPosition(0, HegeGame.height - getHeight());
        stage.addActor(this);
        
    }
}
