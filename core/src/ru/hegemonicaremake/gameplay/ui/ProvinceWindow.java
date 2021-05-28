package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.utils.SkinManager;

public class ProvinceWindow extends Window {
    Label lP1;
    Label lP2;
    Label lP3;
    public Label lProvName;
    Label lProvCountry;
    Label lProvPopulation;
    Label lP4;
    Label lPopulationProgress;
    HegeProgressBar populationProgress;
    Label lP5;
    Label lProductionProgress;
    HegeProgressBar productionProgress;
    Label lP6;
    Label lFoodIncome;
    Label lP7;
    Label lProductionIncome;
    Label lP8;
    Label lUnitThere;
    TextButton bMoveUnit;
    Label lMovementPoints;
    
    SkinManager skinManager;
    
    public ProvinceWindow(Stage stage) {
        super("Province Info", HegeGame.skinManager.shimmerSkin);
        setPosition(HegeGame.width * 0.05f, HegeGame.height * 0.4f);
        setSize(HegeGame.width * 0.15f / HegeGame.uiFactor, HegeGame.width * 0.15f / HegeGame.uiFactor);
        setVisible(false);
        setResizable(true);
        skinManager = HegeGame.skinManager;
        
        init();
    }
    
    private void init() {
        lP1 = new Label("Name:", skinManager.glassySkin);
        lP2 = new Label("Controlled by:", skinManager.glassySkin);
        lP3 = new Label("Population:", skinManager.glassySkin);
        lProvName = new Label("Null", skinManager.defaultSkin);
        lProvCountry = new Label("Null", skinManager.defaultSkin);
        lProvPopulation = new Label("Null", skinManager.defaultSkin);
        lP4 = new Label("Food points:", skinManager.glassySkin);
        lPopulationProgress = new Label("Null", skinManager.defaultSkin);
        lP5 = new Label("Production points:", skinManager.glassySkin);
        lProductionProgress = new Label("Null", skinManager.defaultSkin);
        lP6 = new Label("Food Income:", skinManager.glassySkin);
        lFoodIncome = new Label("Null", skinManager.defaultSkin);
        lP7 = new Label("Production Income:", skinManager.glassySkin);
        lProductionIncome = new Label("Null", skinManager.defaultSkin);
        lP8 = new Label("Unit in province:", skinManager.glassySkin);
        lUnitThere = new Label("Null", skinManager.defaultSkin);
        
        populationProgress = new HegeProgressBar(getWidth() * 0.15f, getWidth() * 0.02f, HegeProgressBar.ID.FOOD);
        productionProgress = new HegeProgressBar(getWidth() * 0.15f, getWidth() * 0.02f, HegeProgressBar.ID.PRODUCTION);
        
        bMoveUnit = new TextButton("Move Unit", HegeGame.skinManager.defaultSkin);
        bMoveUnit.setSize(getWidth() * 0.4f, getHeight() * 0.3f);
        bMoveUnit.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            
            
            }
        });
        lMovementPoints = new Label("Null", skinManager.defaultSkin);
        lMovementPoints.setVisible(false);
    }
    
    public void showProvinceInfo(Province prov) {
        lProvName.setText(prov.name);
        lProvCountry.setText(prov.owner.name);
        lProvPopulation.setText(prov.population);
        
        lPopulationProgress.setText(prov.foodPoints + " / " + prov.neededFood);
        lProductionProgress.setText(prov.productionPoints + " / " + prov.neededProduction);
        
        
        populationProgress.setRange(0, (float) prov.neededFood);
        populationProgress.setValue(prov.foodPoints);
        
        productionProgress.setRange(0, (float) prov.neededFood);
        productionProgress.setValue((float) prov.productionPoints);
        
        lFoodIncome.setText(Float.toString(prov.foodIncome));
        lProductionIncome.setText(Float.toString(prov.productionIncome));
        
        if (prov.unit != null) {
            lUnitThere.setText(prov.unit.name);
            lMovementPoints.setText(Float.toString(prov.unit.movementPoints));
            bMoveUnit.setVisible(true);
            lMovementPoints.setVisible(true);
        } else {
            lUnitThere.setText("No Unit");
            bMoveUnit.setVisible(false);
            lMovementPoints.setVisible(false);
        }
        
        
        
    }
    
    public void show() {
        setVisible(true);
    }
    
    public void hide() {
        setVisible(false);
    }
}
