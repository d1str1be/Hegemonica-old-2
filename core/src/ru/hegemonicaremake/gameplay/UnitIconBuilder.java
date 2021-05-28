package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import ru.hegemonicaremake.gameplay.provProject.ProvinceProject;

public class UnitIconBuilder {
    
    public static Texture buildIcon(int countryId, int unitId) {
        Pixmap weapon;
        Pixmap circle;
        switch (unitId) {
            case ProvinceProject.ID.WARRIOR:
                weapon = new Pixmap(Gdx.files.internal("icons/units/warrior.png"));
                break;
            case ProvinceProject.ID.ARCHER:
                weapon = new Pixmap(Gdx.files.internal("icons/units/archer.png"));
                break;
            case ProvinceProject.ID.SHIELDMAN:
                weapon = new Pixmap(Gdx.files.internal("icons/units/shield.png"));
                break;
            case ProvinceProject.ID.CROSSBOWS:
                weapon = new Pixmap(Gdx.files.internal("icons/units/crossbow.png"));
                break;
            case ProvinceProject.ID.SWORDSMAN:
                weapon = new Pixmap(Gdx.files.internal("icons/units/sword.png"));
                break;
            default:
                weapon = new Pixmap(Gdx.files.internal("icons/units/warrior.png"));
                break;
        }
        switch (countryId) {
            case Country.ID.BLUE:
                circle = new Pixmap(Gdx.files.internal("icons/units/circleBlue.png"));
                break;
            case Country.ID.GREEN:
                circle = new Pixmap(Gdx.files.internal("icons/units/circleGreen.png"));
                break;
            case Country.ID.RED:
                circle = new Pixmap(Gdx.files.internal("icons/units/circleRed.png"));
                break;
            case Country.ID.ORANGE:
                circle = new Pixmap(Gdx.files.internal("icons/units/circleOrange.png"));
                break;
            default:
                circle = new Pixmap(Gdx.files.internal("icons/units/circleOrange.png"));
                break;
        }
        circle.drawPixmap(weapon, 0, 0);
        return new Texture(circle);
    }
}
