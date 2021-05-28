package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ru.hegemonicaremake.gameplay.ui.ProvinceWindow;

public class HUD {
    Stage stage;
    ProvinceWindow provInfo;
    
    public HUD(){
        stage = new Stage(new ScreenViewport());
        provInfo = new ProvinceWindow(stage);
    }
}
