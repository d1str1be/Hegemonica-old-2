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
    public float startFoodProduction;
    public float citizenEatingFood;

    public float mineProduction;
    public float workshopProduction;
    public float citizenProduction;

    public float libraryScienceProduction;
    public float universityScienceProduction;
    public float citizenScienceProduction;

    public Country(int id) {
        this.id = id;

        buildings = new Building[6];
        buildings[Building.ID.FARM] = new Building(Building.ID.FARM);
        buildings[Building.ID.MINE] = new Building(Building.ID.MINE);
        buildings[Building.ID.LIBRARY] = new Building(Building.ID.LIBRARY);
        buildings[Building.ID.UNIVERSITY] = new Building(Building.ID.UNIVERSITY);
        buildings[Building.ID.WORKSHOP] = new Building(Building.ID.WORKSHOP);
        buildings[Building.ID.CITY] = new Building(Building.ID.CITY);

        technologies = new Technology[6];
        technologies[Technology.ID.ENGINEERING] = new Technology(Technology.ID.ENGINEERING, this);
        technologies[Technology.ID.PAPER] = new Technology(Technology.ID.PAPER, this);
        technologies[Technology.ID.SIMPLYCHEMISTRY] = new Technology(Technology.ID.SIMPLYCHEMISTRY, this);
        technologies[Technology.ID.MACHINERY] = new Technology(Technology.ID.MACHINERY, this);
        technologies[Technology.ID.APPRENTICESHIP] = new Technology(Technology.ID.APPRENTICESHIP, this);
        technologies[Technology.ID.EDUCATION] = new Technology(Technology.ID.EDUCATION, this);

        farmFoodProduction = Building.STARTFOODPRODUCTION.FARM;
        startFoodProduction = Building.STARTFOODPRODUCTION.STARTPRODUCTION;
        citizenEatingFood = OTHERVALUES.STARTEATINGFOODCITIZEN;
        mineProduction = Building.STARTPRODUCTION.MINE;
        workshopProduction = Building.STARTPRODUCTION.WORKSHOP;
        citizenProduction = Building.STARTPRODUCTION.CITIZEN;
        libraryScienceProduction = Building.STARTSCIENCEPRODUCTION.LIBRARY;
        universityScienceProduction = Building.STARTSCIENCEPRODUCTION.UNIVERSITY;
        citizenScienceProduction = Building.STARTSCIENCEPRODUCTION.CITIZEN;
    }

    public void onTurn() {

    }

    public static class NAME {

    }

    public static class OTHERVALUES {
        public final static float STARTEATINGFOODCITIZEN = 2;
    }
}

