package ru.hegemonicaremake.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SkinManager {
    public Skin starSoldierSkin;
    public Skin glassySkin;
    public Skin defaultSkin;
    public Label.LabelStyle mainMenuStyle;
    public Label.LabelStyle notificationStyle;
    public Label.LabelStyle playingInfoStyle;
    public SkinManager() {
        starSoldierSkin = new Skin(Gdx.files.internal("skins/star-soldier/skin/star-soldier-ui.json"));
        glassySkin = new Skin(Gdx.files.internal("skins/glassy/skin/glassy-ui.json"));
        defaultSkin = new Skin(Gdx.files.internal("skins/default/skin/uiskin.json"));
        
        mainMenuStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/droidSans.ttf")), Color.WHITE);
        notificationStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/vagWorld.otf")), Color.WHITE);
        playingInfoStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/vagWorld.otf")), Color.WHITE);
    }
    
    
    
    
}
