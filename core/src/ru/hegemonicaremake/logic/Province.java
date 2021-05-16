package ru.hegemonicaremake.logic;

import java.util.ArrayList;

import ru.hegemonicaremake.logic.provinceProject.Building;
import ru.hegemonicaremake.logic.provinceProject.ProvinceProject;
import ru.hegemonicaremake.logic.provinceProject.units.WarUnit;

public class Province {

    public int id;
    public Country owner;

    public ArrayList<Province> adjacentProvinces;

    //units
    public WarUnit unitThere;

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

    public Building[] buildings;
    public ProvinceProject[] projects;

    public ProvinceProject projectInProcess;
    public int numberOfBuildings;

    public Province(int id) {
        this.id = id;

        projects = new ProvinceProject[11];
        projects[ProvinceProject.ID.FARM] = new ProvinceProject(ProvinceProject.ID.FARM);
        projects[ProvinceProject.ID.MINE] = new ProvinceProject(ProvinceProject.ID.MINE);
        projects[ProvinceProject.ID.LIBRARY] = new ProvinceProject(ProvinceProject.ID.LIBRARY);
        projects[ProvinceProject.ID.UNIVERSITY] = new ProvinceProject(ProvinceProject.ID.UNIVERSITY);
        projects[ProvinceProject.ID.WORKSHOP] = new ProvinceProject(ProvinceProject.ID.WORKSHOP);
        projects[ProvinceProject.ID.CITY] = new ProvinceProject(ProvinceProject.ID.CITY);
        projects[ProvinceProject.ID.WARRIOR] = new ProvinceProject(ProvinceProject.ID.WARRIOR);
        projects[ProvinceProject.ID.ARCHER] = new ProvinceProject(ProvinceProject.ID.ARCHER);
        projects[ProvinceProject.ID.SHIELDMAN] = new ProvinceProject(ProvinceProject.ID.SHIELDMAN);
        projects[ProvinceProject.ID.SWORDSMAN] = new ProvinceProject(ProvinceProject.ID.SWORDSMAN);
        projects[ProvinceProject.ID.CROSSBOWS] = new ProvinceProject(ProvinceProject.ID.CROSSBOWS);

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
        projectInProcess = provinceProject;
        neededProduction = provinceProject.cost;
    }

}
