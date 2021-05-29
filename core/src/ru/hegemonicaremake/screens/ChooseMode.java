package ru.hegemonicaremake.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.LogicMain;
import ru.hegemonicaremake.gameplay.PlayScreen;
import ru.hegemonicaremake.utils.HegeLog;

public class ChooseMode {
    TextButton expBtn;
    TextButton littleBtn;
    TextButton standardBtn;
    TextButton bigBtn;
    
    
    public ChooseMode(HegeGame game, Stage stage) {
        expBtn = new TextButton("Experimental", HegeGame.skinManager.shimmerSkin);
        expBtn.setSize(HegeGame.width * 0.5f, HegeGame.height * 0.2f);
        expBtn.setPosition(HegeGame.width / 4f, HegeGame.height * 0.9f - expBtn.getHeight());
        littleBtn = new TextButton("Little", HegeGame.skinManager.shimmerSkin);
        littleBtn.setSize(HegeGame.width * 0.5f, HegeGame.height * 0.2f);
        littleBtn.setPosition(HegeGame.width / 4f, expBtn.getY() - littleBtn.getHeight());
        standardBtn = new TextButton("Standard", HegeGame.skinManager.shimmerSkin);
        standardBtn.setSize(HegeGame.width * 0.5f, HegeGame.height * 0.2f);
        standardBtn.setPosition(HegeGame.width / 4f, littleBtn.getY() - standardBtn.getHeight());
        bigBtn = new TextButton("Big", HegeGame.skinManager.shimmerSkin);
        bigBtn.setSize(HegeGame.width * 0.5f, HegeGame.height * 0.2f);
        bigBtn.setPosition(HegeGame.width / 4f, standardBtn.getY() - bigBtn.getHeight());
        
        expBtn.setVisible(false);
        littleBtn.setVisible(false);
        standardBtn.setVisible(false);
        bigBtn.setVisible(false);
        addListeners(game);
        stage.addActor(expBtn);
        stage.addActor(littleBtn);
        stage.addActor(standardBtn);
        stage.addActor(bigBtn);
    }
    
    public void show(Table menuTable) {
        menuTable.setVisible(false);
        expBtn.setVisible(true);
        littleBtn.setVisible(true);
        standardBtn.setVisible(true);
        bigBtn.setVisible(true);
        
        HegeLog.log("Menu", "Choose mode now");
    }
    
    public void addListeners(final HegeGame game) {
        expBtn.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                HegeGame.screenManager.setScreen(new PlayScreen(game, LogicMain.MAPSIZEID.EXPERIMENTAL));
            }
        });
        littleBtn.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                HegeGame.screenManager.setScreen(new PlayScreen(game, LogicMain.MAPSIZEID.LITTLE));
            }
        });
        standardBtn.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                HegeGame.screenManager.setScreen(new PlayScreen(game, LogicMain.MAPSIZEID.STANDARD));
            }
        });
        bigBtn.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                HegeGame.screenManager.setScreen(new PlayScreen(game, LogicMain.MAPSIZEID.BIG));
            }
        });
    }
}
