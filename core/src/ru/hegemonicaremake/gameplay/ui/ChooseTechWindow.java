package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import java.util.ArrayList;
import java.util.Map;

import ru.hegemonicaremake.HegeGame;
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
        super("Province Info", HegeGame.skinManager.shimmerSkin);
        setPosition(HegeGame.width * 0.05f, HegeGame.height * 0.4f);
        setSize(HegeGame.width * 0.15f / HegeGame.uiFactor, HegeGame.width * 0.15f / HegeGame.uiFactor);
        setVisible(false);
        setResizable(true);
        skinManager = HegeGame.skinManager;
        stage.addActor(this);
        init();
    }
    
    public void init(){
        lT1 = new Label("Tech name", skinManager.glassySkin);
        lT2 = new Label("Cost", skinManager.glassySkin);
    }
    public void setupTechInfo(){
        this.clear();
        this.add(lT1);
        this.add(lT2);
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
