package ru.hegemonicaremake.logic;

import java.util.ArrayList;

import ru.hegemonicaremake.logic.provinceProject.Building;
import ru.hegemonicaremake.logic.provinceProject.ProvinceProject;
import ru.hegemonicaremake.logic.provinceProject.units.WarUnit;

public class Province {

    public int id;
    public Country owner;

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

    //neighbors
    public Province[] adjacentProvinces;
    public Province northernProvince;
    public Province easternProvince;
    public Province southernProvince;
    public Province westernProvince;
    public Province northWesternProvince;
    public Province northEasternProvince;
    public Province southEasternProvince;
    public Province southWesternProvince;

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
        foodIncome = buildings[ProvinceProject.ID.FARM].quantity * owner.farmFoodProduction + owner.startFoodProduction;
        productionIncome = buildings[ProvinceProject.ID.MINE].quantity * owner.mineProduction + buildings[ProvinceProject.ID.WORKSHOP].quantity * owner.workshopProduction + population * owner.citizenProduction;
        scienceIncome = buildings[ProvinceProject.ID.LIBRARY].quantity * owner.libraryScienceProduction + buildings[ProvinceProject.ID.UNIVERSITY].quantity * owner.universityScienceProduction + population * owner.citizenScienceProduction;
        eatingFood = population * owner.citizenEatingFood;

        foodPoints += foodIncome - eatingFood;
        productionPoints += productionIncome;
        if (foodPoints >= neededFood) {
            grow();
        } else if (foodPoints < 0) {
            decrease();
        }
    }

    public void grow() {
        foodPoints -= neededFood;
        population++;
        eatingFood = population * owner.citizenEatingFood;
        neededFood += 2;
    }

    public void decrease() {
        population--;
        eatingFood = population * owner.citizenEatingFood;
        neededFood -= 2;
        foodPoints = neededFood - 1;
    }

    public void setOwner(Country newOwner) {
        owner = newOwner;
        for (int i = 0; i < 11; i++) {
            projects[i].isUnlocked = newOwner.provinceProjects[i].isUnlocked;
        }
    }

    public void chooseProject(ProvinceProject provinceProject) {
        projectInProcess = provinceProject;
        neededProduction = provinceProject.cost;
    }

    public boolean isTurnAvailable() {
        return !(projectInProcess == null);
    }

}
