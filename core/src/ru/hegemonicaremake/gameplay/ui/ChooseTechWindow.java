package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import java.util.ArrayList;
import java.util.Map;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.Country;
import ru.hegemonicaremake.gameplay.Technology;
import ru.hegemonicaremake.utils.Hideable;
import ru.hegemonicaremake.utils.SkinManager;

public class ChooseTechWindow extends Window implements Hideable {
    
    SkinManager skinManager;
    
    Label lT1;
    Label lT2;
    ArrayList<Label> lTechName;
    ArrayList<Label> lTechCost;
    ArrayList<HegeTechButton> bTech;
    Map<Integer, Technology> buttonTechMap;
    
    
    public ChooseTechWindow(Stage stage) {
        super("Choose Tech", HegeGame.skinManager.shimmerSkin);
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
        TechUi[] technologies = new TechUi[6];
        for (int i = 0; i < technologies.length; i++) {
            technologies[i] = new TechUi(country, this, country.technologies[i]);
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
