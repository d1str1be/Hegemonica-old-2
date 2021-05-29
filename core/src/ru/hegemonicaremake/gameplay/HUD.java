package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
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
import ru.hegemonicaremake.utils.FontGenerator;
import ru.hegemonicaremake.utils.HegeLog;

public class HUD {
    LogicMain logic;
    
    UiStage stage;
    ProvinceWindow provInfo;
    CountryButton countryButton;
    CountryWindow countryInfo;
    ChooseProjectWindow chooseProject;
    ChooseTechWindow chooseTech;
    
    BitmapFont youidiot;
    Texture knight;
    SpriteBatch funnybatch;
    
    Label whoTurnsLabel;
    TextButton turnButton;
    
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
                selectCountry(LogicMain.turnCountry);
            }
        });
        provInfo = new ProvinceWindow(stage);
        chooseProject = new ChooseProjectWindow(stage);
        countryInfo = new CountryWindow(stage);
        chooseTech = new ChooseTechWindow(stage);
        
        turnButton = new TextButton("Turn", HegeGame.skinManager.shimmerSkin);
        turnButton.setSize(HegeGame.width * 0.3f * HegeGame.uiFactor, HegeGame.height * 0.3f * HegeGame.uiFactor);
        turnButton.setPosition(HegeGame.width - turnButton.getWidth(), 0);
        turnButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
    
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                onTurn();
            }
        });
        
        
        updateWhoTurnsLabel();
        
        stage.addActor(turnButton);
        stage.addActor(whoTurnsLabel);
        funnybatch = new SpriteBatch();
        youidiot = FontGenerator.generateFont(Gdx.files.internal("fontsTTF/droidSans.ttf"), 50);
        knight = new Texture(Gdx.files.internal("knight-talking.png"));
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
    
    public void selectCountry(Country country) {
        hideAll();
        countryInfo.setupCountryInfo(country);
        countryInfo.show();
        HegeLog.log("Interface", "Opened Country info window");
    }
    
    public void prepareUnitToMove(WarUnit unit) {
    
    }
    
    public void onTurn() {
        if(logic.onTurn()) {
            updateWhoTurnsLabel();
            HegeLog.log("Logic", "turn happened");
        }
        else
            HegeLog.log("Logic", "turn not happened");
    }
    
    public void updateWhoTurnsLabel() {
        switch (LogicMain.turnCountry.id) {
            case Country.ID.BLUE:
                whoTurnsLabel = new Label("Blue turns", HegeGame.skinManager.blueTurn);
                whoTurnsLabel.setPosition(turnButton.getX(),turnButton.getHeight()+turnButton.getY());
                break;
            case Country.ID.RED:
                whoTurnsLabel = new Label("Red turns", HegeGame.skinManager.redTurn);
                whoTurnsLabel.setPosition(turnButton.getX(),turnButton.getHeight()+turnButton.getY());
                break;
            case Country.ID.GREEN:
                whoTurnsLabel = new Label("Green turns", HegeGame.skinManager.greenTurn);
                whoTurnsLabel.setPosition(turnButton.getX(),turnButton.getHeight()+turnButton.getY());
                break;
            case Country.ID.ORANGE:
                whoTurnsLabel = new Label("Orange turns", HegeGame.skinManager.orangeTurn);
                whoTurnsLabel.setPosition(turnButton.getX(),turnButton.getHeight()+turnButton.getY());
                break;
        }
    }
    
    public void moveUnit(WarUnit unit, Province prov) {
        UnitActions.move(unit, prov);
    }
    
    public void render() {
        stage.act();
        stage.draw();
//        funnybatch.begin();
//        funnybatch.draw(knight,0,0);
//        youidiot.draw(funnybatch,"TbI dolboeb",430,550);
//        funnybatch.end();
    }
    
    public void hideAll() {
        provInfo.hide();
        chooseProject.hide();
        countryInfo.hide();
        chooseTech.hide();
    }
    
    public void dispose() {
        stage.dispose();
    }
}
