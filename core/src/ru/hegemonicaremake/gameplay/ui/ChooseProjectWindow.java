package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import java.util.ArrayList;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.Country;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.utils.Hideable;
import ru.hegemonicaremake.utils.SkinManager;

public class ChooseProjectWindow extends Window implements Hideable {
    
    SkinManager skinManager;
    Label lCB1;
    Label lCB2;
    ArrayList<Label> lBuildingProjects;
    ArrayList<HegeBuildButton> bBuildingBuild;
    ArrayList<Label> lUnitProjects;
    ArrayList<Label> lProdCost;
    ArrayList<HegeBuildButton> bUnitBuild;
    
    public ChooseProjectWindow(Stage stage) {
        super("Province Info", HegeGame.skinManager.shimmerSkin);
        setPosition(0,0);
        setSize(HegeGame.width, HegeGame.height);
        setVisible(false);
        setResizable(true);
        skinManager = HegeGame.skinManager;
        stage.addActor(this);
        init();
    }
    
    public void init() {
        lCB2 = new Label("Cost", skinManager.glassySkin);
        lCB1 = new Label("Project", skinManager.glassySkin);
        
        
        Label l = new Label(" ", skinManager.glassySkin);
        this.add(lCB1).padRight(this.getWidth() * 0.15f);
        this.add(lCB2).padRight(this.getWidth() * 0.15f);
        this.add(l);
        this.setVisible(false);
        lBuildingProjects = new ArrayList<>();
        bBuildingBuild = new ArrayList<>();
        lUnitProjects = new ArrayList<>();
        lProdCost = new ArrayList<>();
        bUnitBuild = new ArrayList<>();
    }
    
    public void setupBuildingsInfo(Province prov) {
        this.clear();
        if (prov.owner.id == Country.ID.NOTHING) {
            hide();
            return;
        }
        lBuildingProjects.clear();
        lUnitProjects.clear();
        bBuildingBuild.clear();
        bUnitBuild.clear();
        this.add(lCB1);
        this.add(lCB2);
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
