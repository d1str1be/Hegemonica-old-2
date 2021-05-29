package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.Country;
import ru.hegemonicaremake.utils.Hideable;
import ru.hegemonicaremake.utils.SkinManager;

public class CountryWindow extends Window implements Hideable {
    
    SkinManager skinManager;
    UiStage ui;
    Label lC1;
    Label lCountryName;
    Label lC2;
    Label lCountryPopulation;
    Label lC3;
    Label lScienceProgress;
    HegeProgressBar scienceProgress;
    TextButton bCHide;
    
    ChooseTechWindow techWindow;
    
    public CountryWindow(UiStage stage) {
        super("Country Info", HegeGame.skinManager.shimmerSkin);
        ui = stage;
        setSize(HegeGame.width * 0.5f / HegeGame.uiFactor, HegeGame.height * 0.8f);
        setPosition((HegeGame.width -getWidth())/2f, (HegeGame.height - getHeight())/2f);
        setVisible(false);
        setResizable(true);
        skinManager = HegeGame.skinManager;
        stage.addActor(this);
        
        init();
        
        techWindow = new ChooseTechWindow(stage);
    }
    
    
    public void init() {
        this.setMovable(true);
        this.setVisible(false);
        this.align(Align.top);
        
        lC1 = new Label("Country Name:", skinManager.playingInfoStyle);
        lCountryName = new Label("Null", skinManager.playingInfoStyle1);
        lC2 = new Label("Population:", skinManager.playingInfoStyle);
        lCountryPopulation = new Label("Null", skinManager.playingInfoStyle1);
        lC3 = new Label("Science points:", skinManager.playingInfoStyle);
        lScienceProgress = new Label("Null", skinManager.playingInfoStyle1);
        scienceProgress = new HegeProgressBar(this.getWidth() * 0.15f, this.getWidth() * 0.02f, HegeProgressBar.ID.SCIENCE);
        
        bCHide = new TextButton("Hide", skinManager.shimmerSkin);
        bCHide.getLabel().setStyle(skinManager.playingInfoStyle);
        bCHide.setRound(true);
        bCHide.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                ui.hideAll();
            }
        });
        
        this.add(lC1);
        this.add(lCountryName);
        this.row();
        this.add(lC2);
        this.add(lCountryPopulation);
        this.row();
        this.add(lC3);
        this.row();
        this.add(scienceProgress).width(getWidth()*0.3f);
        this.add(lScienceProgress);
        this.row();
        this.add(bCHide).width(this.getWidth()*0.3f).height(this.getHeight() * 0.3f);
        
    }
    
    public void setupCountryInfo(Country turnCountry) {
        lCountryName.setText(turnCountry.name);
        lCountryPopulation.setText(turnCountry.population);
        if (turnCountry.technologyInProcess != null) {
            lScienceProgress.setText(turnCountry.sciencePoints + " / " + turnCountry.technologyInProcess.cost);
            scienceProgress.setRange(0, turnCountry.technologyInProcess.cost);
        } else {
            lScienceProgress.setText(turnCountry.sciencePoints + " / " + "0");
            scienceProgress.setRange(0, 1);
        }
        
        scienceProgress.setValue((float) turnCountry.sciencePoints);
        
        if (turnCountry.technologyInProcess == null) {
            techWindow.setupTechInfo(turnCountry);
            techWindow.setVisible(true);
            techWindow.setMovable(true);
        }
    }
    
    @Override
    public void hide() {
        setVisible(false);
        techWindow.hide();
    }
    
    @Override
    public void show() {
        setVisible(true);
    }
}
