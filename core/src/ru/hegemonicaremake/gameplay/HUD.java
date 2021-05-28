package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ru.hegemonicaremake.gameplay.ui.ChooseProjectWindow;
import ru.hegemonicaremake.gameplay.ui.ChooseTechWindow;
import ru.hegemonicaremake.gameplay.ui.CountryInfoWindow;
import ru.hegemonicaremake.gameplay.ui.ProvinceWindow;

public class HUD {
    LogicMain logic;
    
    Stage stage;
    ProvinceWindow provInfo;
    CountryInfoWindow countryInfo;
    ChooseProjectWindow chooseProject;
    ChooseTechWindow chooseTech;
    
    public HUD(LogicMain logic) {
        this.logic = logic;
        stage = new Stage(new ScreenViewport());
        provInfo = new ProvinceWindow(stage);
        countryInfo = new CountryInfoWindow(stage);
        chooseProject = new ChooseProjectWindow(stage);
        chooseTech = new ChooseTechWindow(stage);
    }
    
    public void selectProvince(Province prov) {
        provInfo.showProvinceInfo(prov);
    }
    
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
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
