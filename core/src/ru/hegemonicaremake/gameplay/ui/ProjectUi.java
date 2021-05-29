package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.gameplay.provProject.ProvinceProject;

public class ProjectUi {
    Label name;
    Label cost;
    TextButton buildButton;
    
    public ProjectUi(final Province province, final ChooseProjectWindow window, final UiStage ui, final ProvinceProject project) {
        if (project.isAvailable()) {
            name = new Label(project.name, HegeGame.skinManager.ableToBuild);
            cost = new Label(Float.toString(project.cost), HegeGame.skinManager.ableToBuild1);
        } else {
            name = new Label(project.name, HegeGame.skinManager.unableToBuild);
            cost = new Label(Float.toString(project.cost), HegeGame.skinManager.unableToBuild1);
        }
        
        buildButton = new TextButton("Build", HegeGame.skinManager.shimmerSkin);
        buildButton.getLabel().setStyle(HegeGame.skinManager.playingInfoStyle1);
        buildButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (project.isAvailable()) {
                    province.selectProject(project);
                    window.hide();
                    ui.hideAll();
                }
            }
        });
        window.add(name);
        window.add(cost);
        window.add(buildButton);
        window.row();
    }
}
