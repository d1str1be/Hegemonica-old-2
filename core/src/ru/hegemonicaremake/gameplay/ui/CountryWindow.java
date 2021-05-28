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
    
    Label lC1;
    Label lCountryName;
    Label lC2;
    Label lCountryPopulation;
    Label lC3;
    Label lScienceProgress;
    HegeProgressBar scienceProgress;
    TextButton bCHide;
    
    ChooseTechWindow techWindow;
    
    public CountryWindow(Stage stage) {
        super("Province Info", HegeGame.skinManager.shimmerSkin);
        setPosition(HegeGame.width * 0.05f, HegeGame.height * 0.4f);
        setSize(HegeGame.width * 0.15f / HegeGame.uiFactor, HegeGame.width * 0.15f / HegeGame.uiFactor);
        setVisible(false);
        setResizable(true);
        skinManager = HegeGame.skinManager;
        stage.addActor(this);
        
        init();
        
        techWindow = new ChooseTechWindow(stage);
    }
    
    
    public void init(){
        this.setMovable(true);
        this.setPosition(HegeGame.width * 0.3f, HegeGame.height * 0.6f);
        this.setSize(HegeGame.width * 0.15f / HegeGame.uiFactor, HegeGame.width * 0.125f / HegeGame.uiFactor);
        this.setVisible(false);
        this.align(Align.top);
    
        lC1 = new Label("Country Name:", skinManager.glassySkin);
        lCountryName = new Label("Null", skinManager.glassySkin);
        lC2 = new Label("Population:", skinManager.glassySkin);
        lCountryPopulation = new Label("Null", skinManager.glassySkin);
        lC3 = new Label("Science points:", skinManager.glassySkin);
        lScienceProgress = new Label("Null", skinManager.defaultSkin);
        scienceProgress = new HegeProgressBar(this.getWidth() * 0.15f, this.getWidth() * 0.02f, HegeProgressBar.ID.SCIENCE);
    
        bCHide = new TextButton("Hide", skinManager.defaultSkin);
        bCHide.setSize(this.getWidth(), this.getHeight() * 0.3f);
        bCHide.setRound(true);
        bCHide.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                bCHide.setVisible(false);
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
        this.add(scienceProgress);
        this.add(lScienceProgress);
        this.row();
        this.add(bCHide).width(this.getWidth()).height(this.getHeight() * 0.3f);;
    }
    
    public void setupCountryInfo(Country turnCountry) {
        lCountryName.setText(turnCountry.name);
        lCountryPopulation.setText(turnCountry.population);
        lScienceProgress.setText(turnCountry.sciencePoints + " / " + turnCountry.technologyInProcess.cost);
        scienceProgress.setRange(0, turnCountry.technologyInProcess.cost);
        scienceProgress.setValue((float) turnCountry.sciencePoints);
        
        if (turnCountry.technologyInProcess!=null) {
            techWindow.setupTechInfo();
            techWindow.setVisible(true);
            techWindow.setMovable(true);
        }
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
