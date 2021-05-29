package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.hegemonicaremake.gameplay.HUD;

public class UiStage extends Stage {
    HUD hud;
    
    public UiStage(Viewport viewport, HUD hud) {
        super(viewport);
        this.hud = hud;
    }
    
    public void hideAll() {
        hud.hideAll();
    }
    
}
