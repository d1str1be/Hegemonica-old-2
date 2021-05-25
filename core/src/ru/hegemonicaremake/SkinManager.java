package ru.hegemonicaremake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SkinManager {
    Skin starSoldier;
    
    public SkinManager() {
        starSoldier = new Skin(Gdx.files.internal("skin/star-soldier/star-soldier-ui.json"));
    }
    
}
