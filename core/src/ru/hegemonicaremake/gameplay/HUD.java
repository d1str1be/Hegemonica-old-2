package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.operators.UnitActions;
import ru.hegemonicaremake.gameplay.provProject.WarUnit;
import ru.hegemonicaremake.gameplay.ui.ChooseProjectWindow;
import ru.hegemonicaremake.gameplay.ui.ChooseTechWindow;
import ru.hegemonicaremake.gameplay.ui.CountryButton;
import ru.hegemonicaremake.gameplay.ui.CountryWindow;
import ru.hegemonicaremake.gameplay.ui.ProvinceWindow;
import ru.hegemonicaremake.gameplay.ui.UiStage;
import ru.hegemonicaremake.utils.HegeLog;

public class HUD {
    LogicMain logic;
    
    UiStage stage;
    ProvinceWindow provInfo;
    CountryButton countryButton;
    CountryWindow countryInfo;
    ChooseProjectWindow chooseProject;
    ChooseTechWindow chooseTech;
    
    Texture knight;
    Image knightStage;
    Label info;
    
    Label whoTurnsLabel;
    TextButton turnButton;
    Label moveUnit;
    
    public HUD(LogicMain logic) {
        this.logic = logic;
        stage = new UiStage(new ScreenViewport(), this);
        countryButton = new CountryButton(stage);
        countryButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                selectCountry();
            }
        });
        provInfo = new ProvinceWindow(stage);
        chooseProject = new ChooseProjectWindow(stage);
        countryInfo = new CountryWindow(stage);
        chooseTech = new ChooseTechWindow(stage);
        
        turnButton = new TextButton("Turn", HegeGame.skinManager.shimmerSkin);
        turnButton.setSize(HegeGame.width * 0.3f * HegeGame.uiFactor, HegeGame.height * 0.3f * HegeGame.uiFactor);
        turnButton.setPosition(HegeGame.width - turnButton.getWidth(), 0);
        turnButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                onTurn();
            }
        });
        
        moveUnit = new Label("Move Unit to...", HegeGame.skinManager.mainMenuStyle);
        moveUnit.setPosition((HegeGame.width - moveUnit.getWidth()) / 2f, HegeGame.height * 0.9f - moveUnit.getHeight());
        moveUnit.setVisible(false);
        
        updateWhoTurnsLabel();
        
        stage.addActor(turnButton);
        stage.addActor(whoTurnsLabel);
        stage.addActor(moveUnit);
        
        knight = new Texture(Gdx.files.internal("knight-talking.png"));
        knightStage = new Image(knight);
        knightStage.setPosition(0, 0);
        knightStage.setSize(HegeGame.width * 0.5f, HegeGame.height);
        knightStage.setVisible(false);
        info = new Label("You have unselected projects or technology!", HegeGame.skinManager.playingInfoStyle);
        info.setPosition((HegeGame.width-info.getWidth())/2f, HegeGame.height * 0.5f);
        showKnight("You have unselected projects or technology!");
        stage.addActor(knightStage);
        stage.addActor(info);
    }
    
    public void selectProvince(Province prov) {
        hideAll();
        provInfo.setupProvinceInfo(prov);
        provInfo.show();
        HegeLog.log("Interface", "Opened Prov info window");
    }
    
    public void unselectProvince() {
        provInfo.hide();
    }
    
    public void selectCountry() {
        hideAll();
        countryInfo.setupCountryInfo();
        countryInfo.show();
        HegeLog.log("Interface", "Opened Country info window");
    }
    
    public void prepareUnitToMove(WarUnit unit) {
        if (unit.canMove()) {
            LogicMain.movingUnit = unit;
            hideAll();
            moveUnit.setVisible(true);
        }
    }
    
    public void moveUnit(WarUnit unit, Province prov) {
        UnitActions.move(unit, prov);
        moveUnit.setVisible(false);
    }
    
    public void onTurn() {
        if (logic.onTurn()) {
            updateWhoTurnsLabel();
            HegeLog.log("Logic", "turn happened");
        } else {
            showKnight("You have unselected projects or technology!");
            HegeLog.log("Logic", "turn not happened");
        }
    }
    
    public void updateWhoTurnsLabel() {
        if (whoTurnsLabel != null)
            whoTurnsLabel.remove();
        switch (LogicMain.turnCountry.id) {
            case Country.ID.BLUE:
                whoTurnsLabel = new Label("Blue turns", HegeGame.skinManager.blueTurn);
                whoTurnsLabel.setPosition(turnButton.getX(), turnButton.getHeight() + turnButton.getY());
                break;
            case Country.ID.RED:
                whoTurnsLabel = new Label("Red turns", HegeGame.skinManager.redTurn);
                whoTurnsLabel.setPosition(turnButton.getX(), turnButton.getHeight() + turnButton.getY());
                break;
            case Country.ID.GREEN:
                whoTurnsLabel = new Label("Green turns", HegeGame.skinManager.greenTurn);
                whoTurnsLabel.setPosition(turnButton.getX(), turnButton.getHeight() + turnButton.getY());
                break;
            case Country.ID.ORANGE:
                whoTurnsLabel = new Label("Orange turns", HegeGame.skinManager.orangeTurn);
                whoTurnsLabel.setPosition(turnButton.getX(), turnButton.getHeight() + turnButton.getY());
                break;
        }
        stage.addActor(whoTurnsLabel);
        
    }
    
    
    public void render() {
        stage.act();
        stage.draw();
    }
    
    public void hideAll() {
        provInfo.hide();
        chooseProject.hide();
        countryInfo.hide();
        chooseTech.hide();
    }
    
    public void showKnight(String text) {
        info.setText(text);
        info.setVisible(true);
//        knightStage.setVisible(true);
    }
    
    public void hideKnight() {
        
        info.setVisible(false);
//        knightStage.setVisible(false);
    }
    
    public void dispose() {
        stage.dispose();
    }
}
