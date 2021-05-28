package ru.hegemonicaremake.gameplay.provProject;

import ru.hegemonicaremake.gameplay.Province;

public class Building extends ProvinceProject{

    Province province;

    public int quantity;
    public int limit;

    //province constructor
    public Building(int id, Province province) {
        super(id);
        quantity = 0;
        this.province = province;
        switch (id) {
            case ID.FARM:
                cost = STARTCOST.FARM;
                limit = 9999;
                break;
            case ID.MINE:
                cost = STARTCOST.MINE;
                limit = 9999;
                break;
            case ID.LIBRARY:
                cost = STARTCOST.LIBRARY;
                limit = 1;
                break;
            case ID.UNIVERSITY:
                cost = STARTCOST.UNIVERSITY;
                limit = 1;
                break;
            case ID.WORKSHOP:
                cost = STARTCOST.WORKSHOP;
                limit = 1;
                break;
            case ID.CITY:
                cost = STARTCOST.CITY;
                limit = 1;
                break;
        }
    }

    public void build() {
        quantity++;
        if (id != ID.CITY) province.numberOfBuildings++;
    }

    public boolean isAvailable() {
        if (quantity < limit && isUnlocked && province.numberOfBuildings < province.population) {
            switch (id) {
                case ID.FARM:
                    return true;
                case ID.MINE:
                    return true;
                case ID.LIBRARY:
                case ID.UNIVERSITY:
                case ID.WORKSHOP:
                case ID.WARRIOR:
                case ID.ARCHER:
                case ID.SHIELDMAN:
                    return province.buildings[ID.CITY].quantity == 1;
                case ID.CROSSBOWS:
                case ID.SWORDSMAN:
                    return (province.buildings[ID.CITY].quantity == 1 && province.buildings[ID.WORKSHOP].quantity == 1);
            }
        }
        return false;
    }

    public static class STARTPRODUCTION {
        public final static float MINE = 2;
        public final static float WORKSHOP = 5;
        public final static float CITIZEN = 1;
    }

    public static class STARTFOODPRODUCTION {
        public final static float FARM = 2;
        public final static float STARTPRODUCTION = 4;
    }

    public static class STARTSCIENCEPRODUCTION {
        public final static float LIBRARY = 4;
        public final static float UNIVERSITY = 10;
        public final static float CITIZEN = 1;
    }
}
