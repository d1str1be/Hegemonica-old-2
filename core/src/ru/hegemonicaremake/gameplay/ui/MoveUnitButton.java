package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import ru.hegemonicaremake.gameplay.MapInput;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.gameplay.operators.UnitActions;
import ru.hegemonicaremake.gameplay.provProject.WarUnit;

public class MoveUnitButton extends TextButton {
    public MoveUnitButton(String text, Skin skin) {
        super(text, skin);
    }
    
    
    public void onClick() {
        MapInput.isMovingUnit = true;
    }
    
    public void moveUnit(WarUnit unit, Province prov) {
        if (UnitActions.isMovable(unit, prov)) {
            UnitActions.move(unit, prov);
        } else {

        }
        
        MapInput.isMovingUnit = false;
    }
}
