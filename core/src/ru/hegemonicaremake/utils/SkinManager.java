package ru.hegemonicaremake.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import static ru.hegemonicaremake.HegeGame.uiFactor;

public class SkinManager {
    public Skin starSoldierSkin;
    public Skin glassySkin;
    public Skin defaultSkin;
    public Skin shimmerSkin;
    
    public Label.LabelStyle mainMenuStyle;
    public Label.LabelStyle notificationStyle;
    public Label.LabelStyle playingInfoStyle;
    public Label.LabelStyle playingInfoStyle1;
    public Label.LabelStyle provNameStyle;
    public Label.LabelStyle timesNewRomanStyle;
    public Label.LabelStyle ableToBuild;
    public Label.LabelStyle ableToBuild1;
    public Label.LabelStyle unableToBuild;
    public Label.LabelStyle unableToBuild1;
    public TextButton.TextButtonStyle timesNewRomanButtonStyle;
    
    public Label.LabelStyle redTurn;
    public Label.LabelStyle blueTurn;
    public Label.LabelStyle orangeTurn;
    public Label.LabelStyle greenTurn;
    
    public SkinManager() {
        starSoldierSkin = new Skin(Gdx.files.internal("skins/star-soldier/skin/star-soldier-ui.json"));
        glassySkin = new Skin(Gdx.files.internal("skins/glassy/skin/glassy-ui.json"));
        defaultSkin = new Skin(Gdx.files.internal("skins/default/skin/uiskin.json"));
        shimmerSkin = new Skin(Gdx.files.internal("skins/shimmer/skin/shimmer-ui.json"));
        
        mainMenuStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/droidSans.ttf"), (int) (50 * uiFactor)), Color.WHITE);
        notificationStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/vagWorld.otf")), Color.WHITE);
        playingInfoStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/COPRGTB.TTF"), (int) (50 * uiFactor), 3), Color.WHITE);
        playingInfoStyle1 = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/corbel.ttf"), (int) (50 * uiFactor), 3), Color.WHITE);
        timesNewRomanStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/times.ttf"), (int) (50 * uiFactor)), Color.WHITE);
        provNameStyle = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/vagWorld.otf"), (int) (50 * uiFactor), 4), Color.WHITE);
        
        
        ableToBuild = playingInfoStyle;
        unableToBuild = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/COPRGTB.TTF"), (int) (60 * uiFactor), 3), Color.RED);
        ableToBuild1 = playingInfoStyle1;
        unableToBuild1 = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/corbel.ttf"), (int) (60 * uiFactor), 3), Color.RED);
    
        redTurn = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/COPRGTB.TTF"), (int) (55 * uiFactor), 3), Color.RED);
        blueTurn = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/COPRGTB.TTF"), (int) (55* uiFactor), 3), Color.BLUE);
        orangeTurn = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/COPRGTB.TTF"), (int) (55 * uiFactor), 3), Color.ORANGE);
        greenTurn = new Label.LabelStyle(FontGenerator.generateFont(Gdx.files.internal("fontsTTF/COPRGTB.TTF"), (int) (55 * uiFactor), 3), Color.GREEN);
    }
    
}
