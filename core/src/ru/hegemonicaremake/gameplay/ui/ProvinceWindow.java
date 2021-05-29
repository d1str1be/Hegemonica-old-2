package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.utils.SkinManager;

public class ProvinceWindow extends Window {
    Province selectedProv;
    UiStage ui;
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
    MoveUnitButton bMoveUnit;
    Label lMovementPoints;
    
    SkinManager skinManager;
    
    ChooseProjectWindow projectWindow;
    
    public ProvinceWindow(UiStage stage) {
        super("Province", HegeGame.skinManager.shimmerSkin);
        this.ui = stage;
        align(Align.top);
        getTitleLabel().setStyle(HegeGame.skinManager.playingInfoStyle1);
        
        setSize(HegeGame.width * 0.5f / HegeGame.uiFactor, HegeGame.height * 0.8f);
        setPosition((HegeGame.width - getWidth()) / 2f, (HegeGame.height - getHeight()) / 2f);
        setVisible(false);
        setResizable(true);
        skinManager = HegeGame.skinManager;
        init();
        
        stage.addActor(this);
        projectWindow = new ChooseProjectWindow(stage);
    }
    
    private void init() {
        lP1 = new Label("Name:", skinManager.glassySkin);
        lP1.setStyle(HegeGame.skinManager.playingInfoStyle);
        lP2 = new Label("Controlled by:", skinManager.glassySkin);
        lP2.setStyle(HegeGame.skinManager.playingInfoStyle);
        lP3 = new Label("Population:", skinManager.glassySkin);
        lP3.setStyle(HegeGame.skinManager.playingInfoStyle);
        lProvName = new Label("Null", skinManager.defaultSkin);
        lProvName.setStyle(HegeGame.skinManager.playingInfoStyle1);
        lProvCountry = new Label("Null", skinManager.defaultSkin);
        lProvCountry.setStyle(HegeGame.skinManager.playingInfoStyle1);
        lProvPopulation = new Label("Null", skinManager.defaultSkin);
        lProvPopulation.setStyle(HegeGame.skinManager.playingInfoStyle1);
        lP4 = new Label("Food points:", skinManager.glassySkin);
        lP4.setStyle(HegeGame.skinManager.playingInfoStyle);
        lPopulationProgress = new Label("Null", skinManager.defaultSkin);
        lPopulationProgress.setStyle(HegeGame.skinManager.playingInfoStyle1);
        lP5 = new Label("Production points:", skinManager.glassySkin);
        lP5.setStyle(HegeGame.skinManager.playingInfoStyle);
        lProductionProgress = new Label("Null", skinManager.defaultSkin);
        lProductionProgress.setStyle(HegeGame.skinManager.playingInfoStyle1);
        lP6 = new Label("Food Income:", skinManager.glassySkin);
        lP6.setStyle(HegeGame.skinManager.playingInfoStyle);
        lFoodIncome = new Label("Null", skinManager.defaultSkin);
        lFoodIncome.setStyle(HegeGame.skinManager.playingInfoStyle1);
        lP7 = new Label("Production Income:", skinManager.glassySkin);
        lP7.setStyle(HegeGame.skinManager.playingInfoStyle);
        lProductionIncome = new Label("Null", skinManager.defaultSkin);
        lProductionIncome.setStyle(HegeGame.skinManager.playingInfoStyle1);
        lP8 = new Label("Unit in province:", skinManager.glassySkin);
        lP8.setStyle(HegeGame.skinManager.playingInfoStyle);
        lUnitThere = new Label("Null", skinManager.defaultSkin);
        lUnitThere.setStyle(HegeGame.skinManager.playingInfoStyle1);
        
        populationProgress = new HegeProgressBar(getWidth() * 0.4f, getHeight() * 0.05f, HegeProgressBar.ID.FOOD);
        productionProgress = new HegeProgressBar(getWidth() * 0.4f, getHeight() * 0.05f, HegeProgressBar.ID.PRODUCTION);
        bMoveUnit = new MoveUnitButton();
        bMoveUnit.setSize(getWidth() * 0.4f, getHeight() * 0.3f);
        bMoveUnit.getLabel().setStyle(HegeGame.skinManager.playingInfoStyle1);
        lMovementPoints = new Label("Null", skinManager.defaultSkin);
        lMovementPoints.setStyle(HegeGame.skinManager.playingInfoStyle1);
        lMovementPoints.setVisible(false);
        
        this.add(lP1);
        this.add(lProvName);
        this.row();
        this.add(lP2);
        this.add(lProvCountry);
        this.row();
        this.add(lP3);
        this.add(lProvPopulation);
        this.row();
        this.add(lP4);
        this.row();
        this.add(populationProgress).width(getWidth() * 0.3f);
        this.add(lPopulationProgress);
        this.row();
        this.add(lP5);
        this.row();
        this.add(productionProgress).width(getWidth() * 0.3f);
        this.add(lProductionProgress);
        this.row();
        this.add(lP6);
        this.add(lFoodIncome);
        this.row();
        this.add(lP7);
        this.add(lProductionIncome);
        this.row();
        this.add(lP8);
        this.add(lUnitThere);
        this.row();
        this.add(bMoveUnit).width(getWidth() * 0.4f).height(getHeight() * 0.1f);
        this.add(lMovementPoints);
    }
    
    public void setupProvinceInfo(final Province prov) {
        this.selectedProv = prov;
        lProvName.setText(prov.name);
        lProvCountry.setText(prov.owner.name);
        lProvPopulation.setText(prov.population);
        
        lPopulationProgress.setText(prov.foodPoints + " / " + prov.neededFood);
        lProductionProgress.setText(prov.productionPoints + " / " + prov.neededProduction);
        
        
        populationProgress.setRange(0, prov.neededFood);
        populationProgress.setValue(prov.foodPoints);
        
        productionProgress.setRange(0, prov.neededFood);
        productionProgress.setValue(prov.productionPoints);
        
        lFoodIncome.setText(Float.toString(prov.foodIncome));
        lProductionIncome.setText(Float.toString(prov.productionIncome));
        
        bMoveUnit.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (prov.unit != null)
                    ui.hud.prepareUnitToMove(prov.unit);
            }
        });
        
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
        if (selectedProv.projectInProcess == null) {
            projectWindow.show();
            projectWindow.setupBuildingsInfo(selectedProv);
        }
    }
    
    public void hide() {
        setVisible(false);
        projectWindow.hide();
    }
}
