package ru.hegemonicaremake.gameplay.provinceProject.units;

import ru.hegemonicaremake.gameplay.Country;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.gameplay.provinceProject.ProvinceProject;

public class WarUnit extends ProvinceProject {

    public int unitId;
    public Province province;
    public Country owner;

    //battle
    public float health;
    public float startAttackStrength;
    public float startDefenseStrength;
    public float startMovementPoints;
    public float attackStrength;
    public float defenseStrength;
    public float movementPoints;
    public boolean isRanged;

    //create constructor
    public WarUnit(int id, Province province) {
        super(id);
        this.province = province;
        this.owner = province.owner;
        unitId = owner.logicMain.unitIdCounter;
        owner.logicMain.unitIdCounter++;
        province.unitThere = this;
        switch (id) {
            case ID.WARRIOR:
                startAttackStrength = ATTACKSTRENGTH.WARRIOR;
                startDefenseStrength = DEFENSESTRENGTH.WARRIOR;
                startMovementPoints = MOVEMENTPOINTS.WARRIOR;
                isRanged = false;
                break;
            case ID.ARCHER:
                startAttackStrength = ATTACKSTRENGTH.ARCHER;
                startDefenseStrength = DEFENSESTRENGTH.ARCHER;
                startMovementPoints = MOVEMENTPOINTS.ARCHER;
                isRanged = true;
                break;
            case ID.SHIELDMAN:
                startAttackStrength = ATTACKSTRENGTH.SHIELDMAN;
                startDefenseStrength = DEFENSESTRENGTH.SHIELDMAN;
                startMovementPoints = MOVEMENTPOINTS.SHIELDMAN;
                isRanged = false;
                break;
            case ID.CROSSBOWS:
                startAttackStrength = ATTACKSTRENGTH.CROSSBOWS;
                startDefenseStrength = DEFENSESTRENGTH.CROSSBOWS;
                startMovementPoints = MOVEMENTPOINTS.CROSSBOWS;
                isRanged = true;
                break;
            case ID.SWORDSMAN:
                startAttackStrength = ATTACKSTRENGTH.SWORDSMAN;
                startDefenseStrength = DEFENSESTRENGTH.SWORDSMAN;
                startMovementPoints = MOVEMENTPOINTS.SWORDSMAN;
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

    public class ATTACKSTRENGTH {
        public final static float WARRIOR = 20;
        public final static float ARCHER = 20;
        public final static float SHIELDMAN = 10;
        public final static float CROSSBOWS = 30;
        public final static float SWORDSMAN = 30;
    }

    public class DEFENSESTRENGTH {
        public final static float WARRIOR = 22;
        public final static float ARCHER = 10;
        public final static float SHIELDMAN = 35;
        public final static float CROSSBOWS = 18;
        public final static float SWORDSMAN = 32;
    }

    public class MOVEMENTPOINTS {
        public final static float WARRIOR = 1;
        public final static float ARCHER = 1;
        public final static float SHIELDMAN = 1;
        public final static float CROSSBOWS = 1;
        public final static float SWORDSMAN = 1;
    }

}
