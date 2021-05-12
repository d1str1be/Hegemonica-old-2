package ru.hegemonicaremake.logic;

import ru.hegemonicaremake.logic.provinceProject.Building;
import ru.hegemonicaremake.logic.provinceProject.units.WarUnit;

public class Country {

    public int id;
    public String name;

    public Technology[] technologies;
    public Building[] buildings;
    public WarUnit[] units;

    //regional economics
    public float farmFoodProduction;
    public float citizenEatingFood;

    public float mineProduction;
    public float workshopProduction;

    public float libraryScienceProduction;
    public float universityScienceProduction;

    public Country(int id) {
        this.id = id;

        buildings = new Building[6];
        buildings[Building.ID.FARM] = new Building(Building.ID.FARM);
        buildings[Building.ID.MINE] = new Building(Building.ID.MINE);
        buildings[Building.ID.LIBRARY] = new Building(Building.ID.LIBRARY);
        buildings[Building.ID.UNIVERSITY] = new Building(Building.ID.UNIVERSITY);
        buildings[Building.ID.WORKSHOP] = new Building(Building.ID.WORKSHOP);
        buildings[Building.ID.CITY] = new Building(Building.ID.CITY);

        farmFoodProduction = Building.STARTFOODPRODUCTION.FARM;
        citizenEatingFood = OTHERVALUES.STARTEATINGFOODCITIZEN;
        mineProduction = Building.STARTPRODUCTION.MINE;
        workshopProduction = Building.STARTPRODUCTION.WORKSHOP;
        libraryScienceProduction = Building.STARTSCIENCEPRODUCTION.LIBRARY;
        universityScienceProduction = Building.STARTSCIENCEPRODUCTION.UNIVERSITY;
    }

    public class NAME {

    }

    public class OTHERVALUES {
        public final static float STARTEATINGFOODCITIZEN = 2;
    }
}

