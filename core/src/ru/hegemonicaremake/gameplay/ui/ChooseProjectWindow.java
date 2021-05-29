package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.Country;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.utils.Hideable;
import ru.hegemonicaremake.utils.SkinManager;

public class ChooseProjectWindow extends Window implements Hideable {
    UiStage ui;
    SkinManager skinManager;
    Label lCB1;
    Label lCB2;
    
    public ChooseProjectWindow(UiStage stage) {
        super("Province Info", HegeGame.skinManager.shimmerSkin);
        this.ui = stage;
        setPosition(0, 0);
        setSize(HegeGame.width, HegeGame.height);
        setVisible(false);
        setResizable(true);
        skinManager = HegeGame.skinManager;
        stage.addActor(this);
        init();
    }
    
    public void init() {
        lCB2 = new Label("Cost", skinManager.playingInfoStyle);
        lCB1 = new Label("Project", skinManager.playingInfoStyle);
        this.add(lCB1).padRight(this.getWidth() * 0.15f);
        this.add(lCB2).padRight(this.getWidth() * 0.15f);
        this.setVisible(false);
    }
    
    public void setupBuildingsInfo(Province prov) {
        this.clear();
        if (prov.owner.id == Country.ID.NOTHING) {
            hide();
            return;
        }
        this.add(lCB1);
        this.add(lCB2);
        this.row();
        
        ProjectUi[] projects = new ProjectUi[11];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = new ProjectUi(prov, this, ui, prov.projects[i]);
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
