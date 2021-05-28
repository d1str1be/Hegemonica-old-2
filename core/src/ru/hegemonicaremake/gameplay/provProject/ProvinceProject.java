package ru.hegemonicaremake.gameplay.provProject;

import ru.hegemonicaremake.gameplay.Province;

public class ProvinceProject {
    
    public int id;
    public int typeId;
    public float cost;
    public String name;
    public Province province;
    
    public boolean isUnlocked;

    //Province constructor
    public ProvinceProject(int id, Province province) {
        this.id = id;
        this.province = province;
        switch (id) {
            case ID.FARM:
                cost = STARTCOST.FARM;
                isUnlocked = true;
                typeId = TYPEID.BUILDING;
                name = "Farm";
                break;
            case ID.MINE:
                cost = STARTCOST.MINE;
                isUnlocked = true;
                typeId = TYPEID.BUILDING;
                name = "Mine";
                break;
            case ID.LIBRARY:
                cost = STARTCOST.LIBRARY;
                isUnlocked = false;
                typeId = TYPEID.BUILDING;
                name = "Library";
                break;
            case ID.UNIVERSITY:
                cost = STARTCOST.UNIVERSITY;
                isUnlocked = false;
                typeId = TYPEID.BUILDING;
                name = "University";
                break;
            case ID.WORKSHOP:
                cost = STARTCOST.WORKSHOP;
                isUnlocked = false;
                typeId = TYPEID.BUILDING;
                name = "Workshop";
                break;
            case ID.CITY:
                cost = STARTCOST.CITY;
                isUnlocked = true;
                typeId = TYPEID.BUILDING;
                name = "City";
                break;
            case ID.WARRIOR:
                cost = STARTCOST.WARRIOR;
                isUnlocked = true;
                typeId = TYPEID.UNIT;
                name = "Warrior";
                break;
            case ID.ARCHER:
                cost = STARTCOST.ARCHER;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                name = "Archer";
                break;
            case ID.SHIELDMAN:
                cost = STARTCOST.SHIELDMAN;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                name = "Shieldman";
                break;
            case ID.SWORDSMAN:
                cost = STARTCOST.SWORDSMAN;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                name = "Swordsman";
                break;
            case ID.CROSSBOWS:
                cost = STARTCOST.CROSSBOWS;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                name = "Crossbows";
                break;
        }
    }

    //Country constuctor
    public ProvinceProject(int id) {
        this.id = id;
        switch (id) {
            case ID.FARM:
                cost = STARTCOST.FARM;
                isUnlocked = true;
                typeId = TYPEID.BUILDING;
                name = "Farm";
                break;
            case ID.MINE:
                cost = STARTCOST.MINE;
                isUnlocked = true;
                typeId = TYPEID.BUILDING;
                name = "Mine";
                break;
            case ID.LIBRARY:
                cost = STARTCOST.LIBRARY;
                isUnlocked = false;
                typeId = TYPEID.BUILDING;
                name = "Library";
                break;
            case ID.UNIVERSITY:
                cost = STARTCOST.UNIVERSITY;
                isUnlocked = false;
                typeId = TYPEID.BUILDING;
                name = "University";
                break;
            case ID.WORKSHOP:
                cost = STARTCOST.WORKSHOP;
                isUnlocked = false;
                typeId = TYPEID.BUILDING;
                name = "Workshop";
                break;
            case ID.CITY:
                cost = STARTCOST.CITY;
                isUnlocked = true;
                typeId = TYPEID.BUILDING;
                name = "City";
                break;
            case ID.WARRIOR:
                cost = STARTCOST.WARRIOR;
                isUnlocked = true;
                typeId = TYPEID.UNIT;
                name = "Warrior";
                break;
            case ID.ARCHER:
                cost = STARTCOST.ARCHER;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                name = "Archer";
                break;
            case ID.SHIELDMAN:
                cost = STARTCOST.SHIELDMAN;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                name = "Shieldman";
                break;
            case ID.SWORDSMAN:
                cost = STARTCOST.SWORDSMAN;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                name = "Swordsman";
                break;
            case ID.CROSSBOWS:
                cost = STARTCOST.CROSSBOWS;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                name = "Crossbows";
                break;
        }
    }
    
    public void unlock() {
        isUnlocked = true;
    }

    public boolean isAvailable() {
        if (isUnlocked) {
            if (id >= 0 && id <= ID.CITY) {
                return province.buildings[id].isAvailable();
            } else {
                return province.unit != null;
            }
        }
        return false;
    }
    
    public static class ID {
        public final static int FARM = 0;
        public final static int MINE = 1;
        public final static int LIBRARY = 2;
        public final static int UNIVERSITY = 3;
        public final static int WORKSHOP = 4;
        public final static int CITY = 5;
        public final static int WARRIOR = 6;
        public final static int ARCHER = 7;
        public final static int SHIELDMAN = 8;
        public final static int SWORDSMAN = 9;
        public final static int CROSSBOWS = 10;
    }
    
    public static class TYPEID {
        public final static int BUILDING = 0;
        public final static int UNIT = 1;
    }
    
    public static class STARTCOST {
        public final static float FARM = 8;
        public final static float MINE = 8;
        public final static float LIBRARY = 15;
        public final static float UNIVERSITY = 30;
        public final static float WORKSHOP = 20;
        public final static float CITY = 75;
        public final static float WARRIOR = 12;
        public final static float ARCHER = 15;
        public final static float SHIELDMAN = 15;
        public final static float SWORDSMAN = 25;
        public final static float CROSSBOWS = 25;
        
    }
    
}
