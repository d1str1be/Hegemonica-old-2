package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.Country;
import ru.hegemonicaremake.utils.Hideable;
import ru.hegemonicaremake.utils.SkinManager;

public class ChooseTechWindow extends Window implements Hideable {
    UiStage ui;
    SkinManager skinManager;
    
    Label lT1;
    Label lT2;
    
    public ChooseTechWindow(UiStage stage) {
        super("Choose Tech", HegeGame.skinManager.shimmerSkin);
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
        lT1 = new Label("Tech name", skinManager.playingInfoStyle);
        lT2 = new Label("Cost", skinManager.playingInfoStyle);
    }
    
    public void setupTechInfo(Country country) {
        this.clear();
        this.add(lT1);
        this.add(lT2);
        this.row();
        TechUi[] technologies = new TechUi[6];
        for (int i = 0; i < technologies.length; i++) {
            technologies[i] = new TechUi(country, this, ui, country.technologies[i]);
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
