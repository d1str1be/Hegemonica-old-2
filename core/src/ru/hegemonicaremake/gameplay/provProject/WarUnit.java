package ru.hegemonicaremake.gameplay.provProject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import ru.hegemonicaremake.gameplay.Country;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.gameplay.WarUnitGFX;

public class WarUnit extends ProvinceProject {
    
    public int unitId;
    public Province province;
    public Country owner;
    
    //graphics
    public Texture ownerTexture;
    public Texture unitTexture;
    
    //battle
    public static final float maxHealth = 100;
    public float health;
    public float startAttackStrength;
    public float startDefenseStrength;
    public float startMovementPoints;
    public float attackStrength;
    public float defenseStrength;
    public float movementPoints;
    public boolean isRanged;
    
    public WarUnitGFX gfx;
    
    //create constructor
    public WarUnit(int id, Province province) {
        super(id);
        this.province = province;
        this.owner = province.owner;
        health = maxHealth;
        unitId = owner.logicMain.unitIdCounter;
        owner.logicMain.unitIdCounter++;
        province.unit = this;
        gfx = new WarUnitGFX(id, province);
        switch (id) {
            case ID.WARRIOR:
                startAttackStrength = ATTACKSTRENGTH.WARRIOR;
                startDefenseStrength = DEFENSESTRENGTH.WARRIOR;
                startMovementPoints = MOVEMENTPOINTS.WARRIOR;
                unitTexture = new Texture(Gdx.files.internal("icons/units/warrior.png"));
                isRanged = false;
                break;
            case ID.ARCHER:
                startAttackStrength = ATTACKSTRENGTH.ARCHER;
                startDefenseStrength = DEFENSESTRENGTH.ARCHER;
                startMovementPoints = MOVEMENTPOINTS.ARCHER;
                unitTexture = new Texture(Gdx.files.internal("icons/units/archer.png"));
                isRanged = true;
                break;
            case ID.SHIELDMAN:
                startAttackStrength = ATTACKSTRENGTH.SHIELDMAN;
                startDefenseStrength = DEFENSESTRENGTH.SHIELDMAN;
                startMovementPoints = MOVEMENTPOINTS.SHIELDMAN;
                unitTexture = new Texture(Gdx.files.internal("icons/units/shield.png"));
                isRanged = false;
                break;
            case ID.CROSSBOWS:
                startAttackStrength = ATTACKSTRENGTH.CROSSBOWS;
                startDefenseStrength = DEFENSESTRENGTH.CROSSBOWS;
                startMovementPoints = MOVEMENTPOINTS.CROSSBOWS;
                unitTexture = new Texture(Gdx.files.internal("icons/units/crossbow.png"));
                isRanged = true;
                break;
            case ID.SWORDSMAN:
                startAttackStrength = ATTACKSTRENGTH.SWORDSMAN;
                startDefenseStrength = DEFENSESTRENGTH.SWORDSMAN;
                startMovementPoints = MOVEMENTPOINTS.SWORDSMAN;
                unitTexture = new Texture(Gdx.files.internal("icons/units/sword.png"));
                isRanged = false;
                break;
        }
        attackStrength = startAttackStrength;
        defenseStrength = startDefenseStrength;
        movementPoints = startMovementPoints;
        
    }
    
    public void setAttackStrength() {
        attackStrength = startAttackStrength - 10 * (health / 100);
    }
    
    public void setDefenseStrength() {
        defenseStrength = startDefenseStrength - 10 * (health / 100);
    }
    
    public boolean canMove() {
        return movementPoints > 0;
    }
    
    public static class ATTACKSTRENGTH {
        public final static float WARRIOR = 20;
        public final static float ARCHER = 20;
        public final static float SHIELDMAN = 10;
        public final static float CROSSBOWS = 30;
        public final static float SWORDSMAN = 30;
    }
    
    public static class DEFENSESTRENGTH {
        public final static float WARRIOR = 22;
        public final static float ARCHER = 10;
        public final static float SHIELDMAN = 35;
        public final static float CROSSBOWS = 18;
        public final static float SWORDSMAN = 32;
    }
    
    public static class MOVEMENTPOINTS {
        public final static float WARRIOR = 1;
        public final static float ARCHER = 1;
        public final static float SHIELDMAN = 1;
        public final static float CROSSBOWS = 1;
        public final static float SWORDSMAN = 1;
    }
    
}
