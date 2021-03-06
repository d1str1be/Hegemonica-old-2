package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.hegemonicaremake.gameplay.operators.UnitActions;
import ru.hegemonicaremake.gameplay.provProject.Building;
import ru.hegemonicaremake.gameplay.provProject.ProvinceProject;
import ru.hegemonicaremake.gameplay.provProject.WarUnit;
import ru.hegemonicaremake.utils.HegeLog;

public class Province {
    
    public int id;
    public String name;
    public Country owner;
    public LogicMain logicMain;
    
    //units
    public WarUnit unit;
    
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
    
    //neighbors and location
    public Province[] adjacentProvinces;
    public Province northernProvince;
    public Province easternProvince;
    public Province southernProvince;
    public Province westernProvince;
    public Province northWesternProvince;
    public Province northEasternProvince;
    public Province southEasternProvince;
    public Province southWesternProvince;
    
    public int x;
    public int y;
    private final float provinceSideSize;
    
    //for rendering
    public ProvinceGFX gfx;
    
    public Province(int id, LogicMain logicMain, Country owner) {
        this.id = id;
        this.logicMain = logicMain;
        this.owner = owner;
        this.name = "Province " + id;
        provinceSideSize = LogicMain.provinceSize;
        projects = new ProvinceProject[11];
        projects[ProvinceProject.ID.FARM] = new ProvinceProject(ProvinceProject.ID.FARM, this);
        projects[ProvinceProject.ID.MINE] = new ProvinceProject(ProvinceProject.ID.MINE, this);
        projects[ProvinceProject.ID.LIBRARY] = new ProvinceProject(ProvinceProject.ID.LIBRARY, this);
        projects[ProvinceProject.ID.UNIVERSITY] = new ProvinceProject(ProvinceProject.ID.UNIVERSITY, this);
        projects[ProvinceProject.ID.WORKSHOP] = new ProvinceProject(ProvinceProject.ID.WORKSHOP, this);
        projects[ProvinceProject.ID.CITY] = new ProvinceProject(ProvinceProject.ID.CITY, this);
        projects[ProvinceProject.ID.WARRIOR] = new ProvinceProject(ProvinceProject.ID.WARRIOR, this);
        projects[ProvinceProject.ID.ARCHER] = new ProvinceProject(ProvinceProject.ID.ARCHER, this);
        projects[ProvinceProject.ID.SHIELDMAN] = new ProvinceProject(ProvinceProject.ID.SHIELDMAN, this);
        projects[ProvinceProject.ID.SWORDSMAN] = new ProvinceProject(ProvinceProject.ID.SWORDSMAN, this);
        projects[ProvinceProject.ID.CROSSBOWS] = new ProvinceProject(ProvinceProject.ID.CROSSBOWS, this);
        
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
        neededFood = 10;
        gfx = new ProvinceGFX(this);
    }
    
    public void onTurn() {
        UnitActions.onTurn(unit);
        
        foodIncome = buildings[ProvinceProject.ID.FARM].quantity * owner.farmFoodProduction + owner.startFoodProduction;
        productionIncome = buildings[ProvinceProject.ID.MINE].quantity * owner.mineProduction + buildings[ProvinceProject.ID.WORKSHOP].quantity * owner.workshopProduction + population * owner.citizenProduction;
        scienceIncome = buildings[ProvinceProject.ID.LIBRARY].quantity * owner.libraryScienceProduction + buildings[ProvinceProject.ID.UNIVERSITY].quantity * owner.universityScienceProduction + population * owner.citizenScienceProduction;
        eatingFood = population * owner.citizenEatingFood;
        HegeLog.log("Logic", "Science income of " + name + " : " + scienceIncome);
        
        
        foodPoints += foodIncome - eatingFood;
        productionPoints += productionIncome;
        if (foodPoints >= neededFood) {
            grow();
        } else if (foodPoints < 0) {
            decrease();
        }
        if (productionPoints >= neededProduction) {
            switch (projectInProcess.typeId) {
                case ProvinceProject.TYPEID.BUILDING:
                    buildings[projectInProcess.id].build();
                    break;
                case ProvinceProject.TYPEID.UNIT:
                    owner.logicMain.units.add(new WarUnit(projectInProcess.id, this));
                    break;
            }
            projectInProcess = null;
        }
    }
    
    public void grow() {
        foodPoints -= neededFood;
        population++;
        eatingFood = population * owner.citizenEatingFood;
        neededFood += 4;
    }
    
    public void decrease() {
        population--;
        eatingFood = population * owner.citizenEatingFood;
        neededFood -= 4;
        foodPoints = neededFood - 1;
    }
    
    public void setOwner(Country newOwner) {
        owner = newOwner;
        for (int i = 0; i < 11; i++) {
            projects[i].isUnlocked = newOwner.provinceProjects[i].isUnlocked;
        }
    }
    
    public void selectProject(ProvinceProject provinceProject) {
        projectInProcess = provinceProject;
        neededProduction = provinceProject.cost;
    }
    
    public boolean isTurnAvailable() {
        return !(projectInProcess == null);
    }
    
    public void setNeighbors() {
        float a = LogicMain.provinceSize;
        northWesternProvince = null;
        northernProvince = null;
        northEasternProvince = null;
        easternProvince = null;
        southEasternProvince = null;
        southernProvince = null;
        southWesternProvince = null;
        westernProvince = null;
        for (Province province : owner.logicMain.provinces) {
            if (x - province.x == a && y - province.y == -a) northWesternProvince = province;
            if (x - province.x == 0 && y - province.y == -a) northernProvince = province;
            if (x - province.x == -a && y - province.y == -a) northEasternProvince = province;
            if (x - province.x == -a && y - province.y == 0) easternProvince = province;
            if (x - province.x == -a && y - province.y == a) southEasternProvince = province;
            if (x - province.x == 0 && y - province.y == a) southernProvince = province;
            if (x - province.x == a && y - province.y == a) southWesternProvince = province;
            if (x - province.x == a && y - province.y == 0) westernProvince = province;
        }
        adjacentProvinces = new Province[8];
        adjacentProvinces[0] = northWesternProvince;
        adjacentProvinces[1] = northernProvince;
        adjacentProvinces[2] = northEasternProvince;
        adjacentProvinces[3] = easternProvince;
        adjacentProvinces[4] = southEasternProvince;
        adjacentProvinces[5] = southernProvince;
        adjacentProvinces[6] = southWesternProvince;
        adjacentProvinces[7] = westernProvince;
    }
    
    public boolean isNeighbor(Province province) {
        for (Province province1 : adjacentProvinces) {
            if (province1 != null) {
                if (province1.id == province.id) return true;
            }
        }
        return false;
    }
    
    public void render(SpriteBatch batch) {
        gfx.render(batch);
    }
    
    public void updateGFX(SpriteBatch batch) {
        gfx.update(batch);
    }
    
    public void createUnit(WarUnit unit) {
        this.unit = unit;
    }
    
    public boolean contains(float x, float y) {
        return (x >= this.x &&
                y >= this.y &&
                x < this.x + provinceSideSize &&
                y < this.y + provinceSideSize);
    }
    
}
