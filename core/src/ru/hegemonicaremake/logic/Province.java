package ru.hegemonicaremake.logic;

import java.util.ArrayList;

import ru.hegemonicaremake.logic.provinceProject.Building;
import ru.hegemonicaremake.logic.provinceProject.ProvinceProject;
import ru.hegemonicaremake.logic.provinceProject.units.WarUnit;

public class Province {

    public int id;
    public Country owner;

    public Building[] buildings;
    public WarUnit[] units;

    public ArrayList<Province> adjacentProvinces;

    //economics
    public int population;
    public float foodPoints;
    public float productionPoints;
    public float foodIncome;
    public float productionIncome;
    public float scienceIncome;
    public float neededFood;
    public float neededProduction;
    public float eatingFood;

    public ProvinceProject projectInProcess;
    public int numberOfBuildings;

    public Province(int id) {
        this.id = id;
        buildings = new Building[6];
        buildings[Building.ID.FARM] = new Building(Building.ID.FARM, this);
        buildings[Building.ID.MINE] = new Building(Building.ID.MINE, this);
        buildings[Building.ID.LIBRARY] = new Building(Building.ID.LIBRARY, this);
        buildings[Building.ID.UNIVERSITY] = new Building(Building.ID.UNIVERSITY, this);
        buildings[Building.ID.WORKSHOP] = new Building(Building.ID.WORKSHOP, this);
        buildings[Building.ID.CITY] = new Building(Building.ID.CITY, this);
        numberOfBuildings = 0;

        foodPoints = 0;
        productionPoints = 0;
        population = 1;
        eatingFood = owner.citizenEatingFood;
    }

    public void onTurn() {

    }

    public void grow() {
        population++;
        eatingFood = population * owner.citizenEatingFood;
        neededFood += 2;
    }

    public void decrease() {
        population--;
        eatingFood = population * owner.citizenEatingFood;
        neededFood -= 2;
    }

    public void setOwner(Country newOwner) {

    }

    public void chooseProject(ProvinceProject provinceProject) {

    }

}
