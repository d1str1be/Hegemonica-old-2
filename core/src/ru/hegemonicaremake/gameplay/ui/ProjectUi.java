package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.provProject.ProvinceProject;
import ru.hegemonicaremake.utils.FontGenerator;

public class ProjectUi {
    LabelStyle unableToBuild;
    LabelStyle ableToBuild;
    Label name;
    Label cost;
    TextButton buildButton;
    
    public ProjectUi(Window window, final ProvinceProject project){
        Skin skin;
        Color fontColor;
        ableToBuild = HegeGame.skinManager.playingInfoStyle;
        ableToBuild.fontColor = Color.BLUE;
        unableToBuild = HegeGame.skinManager.playingInfoStyle;
        unableToBuild.fontColor = Color.BLUE;
        if(project.isUnlocked)
            name = new Label(project.name, ableToBuild);
        else
            name = new Label(project.name, unableToBuild);
        cost = new Label(Float.toString(project.cost), HegeGame.skinManager.mainMenuStyle);
        buildButton = new TextButton("Build", HegeGame.skinManager.shimmerSkin);
        buildButton.getLabel().setStyle(HegeGame.skinManager.playingInfoStyle1);
        buildButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
    
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            
            }
        });
        window.add();
    }
}
