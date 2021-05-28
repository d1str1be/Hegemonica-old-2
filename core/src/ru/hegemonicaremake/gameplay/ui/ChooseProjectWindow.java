package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.utils.Hideable;
import ru.hegemonicaremake.utils.SkinManager;

public class ChooseProjectWindow extends Window implements Hideable {
    
    SkinManager skinManager;
    
    public ChooseProjectWindow(Stage stage) {
        super("Province Info", HegeGame.skinManager.shimmerSkin);
        setPosition(HegeGame.width * 0.05f, HegeGame.height * 0.4f);
        setSize(HegeGame.width * 0.15f / HegeGame.uiFactor, HegeGame.width * 0.15f / HegeGame.uiFactor);
        setVisible(false);
        setResizable(true);
        skinManager = HegeGame.skinManager;
        stage.addActor(this);
    }
    
    
    @Override
    public void hide() {
        setVisible(false);
    }
    
    @Override
    public void show() {
        setVisible(true);
    }
}
