package ru.hegemonicaremake.logic.provinceProject.units;

import ru.hegemonicaremake.logic.Province;
import ru.hegemonicaremake.logic.provinceProject.ProvinceProject;

public class WarUnit extends ProvinceProject {

    public int unitId;

    //battle
    public float startAttackStrength;
    public float startDefenseStrength;
    public float startMovementPoints;
    public float attackStrength;
    public float defenseStrength;
    public float movementPoints;

    //create constructor
    public WarUnit(int id, Province province) {
        super(id);
        unitId = province.owner.logicMain.unitIdCounter;
        switch (id) {
            case ID.WARRIOR:
                startAttackStrength = ATTACKSTRENGTH.WARRIOR;
                startDefenseStrength = DEFENSESTRENGTH.WARRIOR;
                startMovementPoints = MOVEMENTPOINTS.WARRIOR;
                break;
            case ID.ARCHER:
                startAttackStrength = ATTACKSTRENGTH.ARCHER;
                startDefenseStrength = DEFENSESTRENGTH.ARCHER;
                startMovementPoints = MOVEMENTPOINTS.ARCHER;
                break;
            case ID.SHIELDMAN:
                startAttackStrength = ATTACKSTRENGTH.SHIELDMAN;
                startDefenseStrength = DEFENSESTRENGTH.SHIELDMAN;
                startMovementPoints = MOVEMENTPOINTS.SHIELDMAN;
                break;
            case ID.CROSSBOWS:
                startAttackStrength = ATTACKSTRENGTH.CROSSBOWS;
                startDefenseStrength = DEFENSESTRENGTH.CROSSBOWS;
                startMovementPoints = MOVEMENTPOINTS.CROSSBOWS;
                break;
            case ID.SWORDSMAN:
                startAttackStrength = ATTACKSTRENGTH.SWORDSMAN;
                startDefenseStrength = DEFENSESTRENGTH.SWORDSMAN;
                startMovementPoints = MOVEMENTPOINTS.SWORDSMAN;
                break;
        }
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
