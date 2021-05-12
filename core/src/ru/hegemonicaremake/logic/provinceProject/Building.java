package ru.hegemonicaremake.logic.provinceProject;

import ru.hegemonicaremake.logic.Province;

public class Building extends ProvinceProject{

    Province province;

    public int quantity;
    public int limit;

    //province constructor
    public Building(int id, Province province) {
        super(id);
        this.province = province;
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

    }

    public class ID {
        public final static int FARM = 1;
        public final static int MINE = 2;
        public final static int LIBRARY = 3;
        public final static int UNIVERSITY = 4;
        public final static int WORKSHOP = 5;
        public final static int CITY = 6;
    }

    public class STARTCOST {
        public final static float FARM = 8;
        public final static float MINE = 8;
        public final static float LIBRARY = 15;
        public final static float UNIVERSITY = 30;
        public final static float WORKSHOP = 20;
        public final static float CITY = 75;
    }

    public class STARTPRODUCTION {
        public final static float MINE = 2;
        public final static float WORKSHOP = 5;
        public final static float CITIZEN = 1;
    }

    public class STARTFOODPRODUCTION {
        public final static float FARM = 2;
    }

    public class STARTSCIENCEPRODUCTION {
        public final static float LIBRARY = 4;
        public final static float UNIVERSITY = 10;
        public final static float CITIZEN = 1;
    }
}
