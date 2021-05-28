package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import ru.hegemonicaremake.HegeGame;
import ru.hegemonicaremake.gameplay.LogicMain;
import ru.hegemonicaremake.gameplay.MapInput;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.gameplay.operators.UnitActions;
import ru.hegemonicaremake.gameplay.provProject.WarUnit;

public class MoveUnitButton extends TextButton {
    public MoveUnitButton() {
        super("Move Unit", HegeGame.skinManager.shimmerSkin);
        setSize(getWidth() * 0.4f, getHeight() * 0.3f);
        getLabel().setStyle(HegeGame.skinManager.playingInfoStyle1);
        
    }
    
    public void onClick(WarUnit unit) {
        LogicMain.movingUnit = unit;
        MapInput.isMovingUnit = true;
    }
    
    public void moveUnit(Province prov) {
        UnitActions.move(LogicMain.movingUnit, prov);
        LogicMain.movingUnit = null;
        MapInput.isMovingUnit = false;
    }
}
