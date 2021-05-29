package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.Country;
import ru.hegemonicaremake.gameplay.Technology;

public class TechUi {
    Label name;
    Label cost;
    TextButton researchButton;
    
    public TechUi(final Country country, final ChooseTechWindow window, final UiStage ui, final Technology technology) {
        if (technology.isAvailable()) {
            name = new Label(technology.name, HegeGame.skinManager.ableToBuild);
            cost = new Label(Float.toString(technology.cost), HegeGame.skinManager.ableToBuild1);
        } else {
            name = new Label(technology.name, HegeGame.skinManager.unableToBuild);
            cost = new Label(Float.toString(technology.cost), HegeGame.skinManager.unableToBuild1);
        }
        
        researchButton = new TextButton("Research", HegeGame.skinManager.shimmerSkin);
        researchButton.getLabel().setStyle(HegeGame.skinManager.playingInfoStyle1);
        researchButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                country.selectTechnology(technology);
                window.hide();
                ui.hideAll();
                ui.hud.selectCountry();
            }
        });
        window.add(name);
        window.add(cost);
        window.add(researchButton);
        window.row();
    }
}
