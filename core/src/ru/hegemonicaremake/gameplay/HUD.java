package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ru.hegemonicaremake.gameplay.operators.UnitActions;
import ru.hegemonicaremake.gameplay.provProject.WarUnit;
import ru.hegemonicaremake.gameplay.ui.ChooseProjectWindow;
import ru.hegemonicaremake.gameplay.ui.ChooseTechWindow;
import ru.hegemonicaremake.gameplay.ui.CountryButton;
import ru.hegemonicaremake.gameplay.ui.CountryWindow;
import ru.hegemonicaremake.gameplay.ui.ProvinceWindow;
import ru.hegemonicaremake.utils.FontGenerator;
import ru.hegemonicaremake.utils.HegeLog;

public class HUD {
    LogicMain logic;
    
    Stage stage;
    ProvinceWindow provInfo;
    CountryButton countryButton;
    CountryWindow countryInfo;
    ChooseProjectWindow chooseProject;
    ChooseTechWindow chooseTech;
    
    BitmapFont youidiot;
    Texture knight;
    SpriteBatch funnybatch;
    
    public HUD(LogicMain logic) {
        this.logic = logic;
        stage = new Stage(new ScreenViewport());
        provInfo = new ProvinceWindow(stage);
        countryButton = new CountryButton(stage, this);
        countryInfo = new CountryWindow(stage);
        chooseProject = new ChooseProjectWindow(stage);
        chooseTech = new ChooseTechWindow(stage);
        
        funnybatch = new SpriteBatch();
        youidiot = FontGenerator.generateFont(Gdx.files.internal("fontsTTF/droidSans.ttf"), 50);
        knight = new Texture(Gdx.files.internal("knight-talking.png"));
    }
    
    public void selectProvince(Province prov) {
        provInfo.setupProvinceInfo(prov);
        provInfo.show();
        HegeLog.log("Interface", "Opened Prov info window");
    }
    
    public void unselectProvince() {
        provInfo.hide();
    }
    
    public void openCountryInfo(Country country) {
        countryInfo.show();
        countryInfo.setupCountryInfo(country);
    }
    
    public void moveUnit(WarUnit unit, Province prov) {
        UnitActions.move(unit, prov);
    }
    
    public void render() {
        stage.act();
        stage.draw();
//        funnybatch.begin();
//        funnybatch.draw(knight,0,0);
//        youidiot.draw(funnybatch,"TbI dolboeb",430,550);
//        funnybatch.end();
    }
    
    public void hideAll() {
        provInfo.hide();
        chooseProject.hide();
        chooseProject.hide();
        chooseTech.hide();
    }
    
    public void dispose() {
        stage.dispose();
    }
}
