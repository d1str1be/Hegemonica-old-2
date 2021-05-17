package ru.hegemonicaremake.logic.provinceProject;

public class ProvinceProject {

    public int id;
    public int typeId;
    public float cost;

    public boolean isUnlocked;

    public ProvinceProject(int id) {
        this.id = id;
        switch (id) {
            case ID.FARM:
                cost = STARTCOST.FARM;
                isUnlocked = true;
                typeId = TYPEID.BUILDING;
                break;
            case ID.MINE:
                cost = STARTCOST.MINE;
                isUnlocked = true;
                typeId = TYPEID.BUILDING;
                break;
            case ID.LIBRARY:
                cost = STARTCOST.LIBRARY;
                isUnlocked = false;
                typeId = TYPEID.BUILDING;
                break;
            case ID.UNIVERSITY:
                cost = STARTCOST.UNIVERSITY;
                isUnlocked = false;
                typeId = TYPEID.BUILDING;
                break;
            case ID.WORKSHOP:
                cost = STARTCOST.WORKSHOP;
                isUnlocked = false;
                typeId = TYPEID.BUILDING;
                break;
            case ID.CITY:
                cost = STARTCOST.CITY;
                isUnlocked = true;
                typeId = TYPEID.BUILDING;
                break;
            case ID.WARRIOR:
                cost = STARTCOST.WARRIOR;
                isUnlocked = true;
                typeId = TYPEID.UNIT;
                break;
            case ID.ARCHER:
                cost = STARTCOST.ARCHER;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                break;
            case ID.SHIELDMAN:
                cost = STARTCOST.SHIELDMAN;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                break;
            case ID.SWORDSMAN:
                cost = STARTCOST.SWORDSMAN;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                break;
            case ID.CROSSBOWS:
                cost = STARTCOST.CROSSBOWS;
                isUnlocked = false;
                typeId = TYPEID.UNIT;
                break;
        }
    }

    public void unlock() {
        isUnlocked = true;
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
