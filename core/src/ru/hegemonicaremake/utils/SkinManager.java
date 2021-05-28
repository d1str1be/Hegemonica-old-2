package ru.hegemonicaremake.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class SkinManager {
    public Skin starSoldierSkin;
    public Skin glassySkin;
    public Skin defaultSkin;
    public Skin shimmerSkin;
    
    public Label.LabelStyle mainMenuStyle;
    public Label.LabelStyle notificationStyle;
    public Label.LabelStyle playingInfoStyle;
    public Label.LabelStyle provNameStyle;
    public Label.LabelStyle timesNewRomanStyle;
    public TextButton.TextButtonStyle timesNewRomanButtonStyle;
    
    public SkinManager() {
        starSoldierSkin = new Skin(Gdx.files.internal("skins/star-soldier/skin/star-soldier-ui.json"));
        glassySkin = new Skin(Gdx.files.internal("skins/glassy/skin/glassy-ui.json"));
        defaultSkin = new Skin(Gdx.files.internal("skins/default/skin/uiskin.json"));
        shimmerSkin = new Skin(Gdx.files.internal("skins/shimmer/skin/shimmer-ui.json"));
        
        mainMenuStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/droidSans.ttf"), 50), Color.WHITE);
        notificationStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/vagWorld.otf")), Color.WHITE);
        playingInfoStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/vagWorld.otf")), Color.WHITE);
        timesNewRomanStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/times.ttf"), 100), Color.WHITE);
        provNameStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/vagWorld.otf"), 24, 4), Color.WHITE);
        
    }
    
}
