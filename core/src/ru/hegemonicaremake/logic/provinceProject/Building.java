package ru.hegemonicaremake.logic.provinceProject;

import ru.hegemonicaremake.logic.Province;

public class Building extends ProvinceProject{

    Province province;

    public int quantity;
    public int limit;

    public boolean isNeedCity;

    //province constructor
    public Building(int id, Province province) {
        super(id);
        quantity = 0;
        this.province = province;
        switch (id) {
            case ID.FARM:
                cost = STARTCOST.FARM;
                limit = 9999;
                isNeedCity = false;
                break;
            case ID.MINE:
                cost = STARTCOST.MINE;
                limit = 9999;
                isNeedCity = false;
                break;
            case ID.LIBRARY:
                cost = STARTCOST.LIBRARY;
                limit = 1;
                isNeedCity = true;
                break;
            case ID.UNIVERSITY:
                cost = STARTCOST.UNIVERSITY;
                limit = 1;
                isNeedCity = true;
                break;
            case ID.WORKSHOP:
                cost = STARTCOST.WORKSHOP;
                limit = 1;
                isNeedCity = true;
                break;
            case ID.CITY:
                cost = STARTCOST.CITY;
                limit = 1;
                isNeedCity = false;
                break;
        }
    }

    //country constructor
    public Building(int id) {
        super(id);
        switch (id) {
            case ID.FARM:
                cost = STARTCOST.FARM;
                break;
            case ID.MINE:
                cost = STARTCOST.MINE;
                break;
            case ID.LIBRARY:
                cost = STARTCOST.LIBRARY;
                break;
            case ID.UNIVERSITY:
                cost = STARTCOST.UNIVERSITY;
                break;
            case ID.WORKSHOP:
                cost = STARTCOST.WORKSHOP;
                break;
            case ID.CITY:
                cost = STARTCOST.CITY;
                break;
        }
    }

    public void build() {
        quantity++;
        if (id != ID.CITY) province.numberOfBuildings++;
    }

    public boolean isAvailable() {
        if (quantity < limit && isUnlocked && province.numberOfBuildings < province.population) {
            if (isNeedCity && province.isCity) return true;
            return !isNeedCity;
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
    }

    public static class STARTCOST {
        public final static float FARM = 8;
        public final static float MINE = 8;
        public final static float LIBRARY = 15;
        public final static float UNIVERSITY = 30;
        public final static float WORKSHOP = 20;
        public final static float CITY = 75;
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
