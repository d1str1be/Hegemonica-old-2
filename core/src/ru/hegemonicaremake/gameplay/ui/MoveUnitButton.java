package ru.hegemonicaremake.gameplay.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import ru.hegemonicaremake.gameplay.MapInput;
import ru.hegemonicaremake.gameplay.Province;

public class MoveUnitButton extends TextButton {
    public MoveUnitButton(String text, Skin skin) {
        super(text, skin);
    }
    
    
    public void click() {
        MapInput.isMovingUnit = true;
    }
    
    public void moveUnit(Province prov) {
        
        
        MapInput.isMovingUnit = false;
    }
}
