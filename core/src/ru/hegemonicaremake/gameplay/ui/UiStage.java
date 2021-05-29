package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.hegemonicaremake.gameplay.HUD;

public class UiStage extends Stage {
    HUD ui;
    public UiStage(Viewport viewport, HUD ui) {
        super(viewport);
        this.ui = ui;
    }
    
    public void hideAll(){
        ui.hideAll();
    }
    
}
