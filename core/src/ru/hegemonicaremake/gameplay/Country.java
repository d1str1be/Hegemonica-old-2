package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import ru.hegemonicaremake.gameplay.provProject.Building;
import ru.hegemonicaremake.gameplay.provProject.ProvinceProject;

public class Country {
    
    public int id;
    public String name;
    public Texture[] borders;
    
    public Technology[] technologies;
    public ProvinceProject[] provinceProjects;
    
    public int population;
    
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
    
    public LogicMain logicMain;
    
    public Technology technologyInProcess;
    public float sciencePoints;
    public float scienceIncome;
    
    public Country(int id, LogicMain logicMain) {
        this.id = id;
        this.logicMain = logicMain;
        population = 1;
        borders = new Texture[4];
        switch (id) {
            case ID.NOTHING:
                name = "Nothing";
                borders[0] = new Texture(Gdx.files.internal("prov/neutralBorderUp.png"));
                borders[1] = new Texture(Gdx.files.internal("prov/neutralBorderRight.png"));
                borders[2] = new Texture(Gdx.files.internal("prov/neutralBorderDown.png"));
                borders[3] = new Texture(Gdx.files.internal("prov/neutralBorderLeft.png"));
                break;
            case ID.BLUE:
                name = "Blue";
                borders[0] = new Texture(Gdx.files.internal("prov/blueBorderUp.png"));
                borders[1] = new Texture(Gdx.files.internal("prov/blueBorderRight.png"));
                borders[2] = new Texture(Gdx.files.internal("prov/blueBorderDown.png"));
                borders[3] = new Texture(Gdx.files.internal("prov/blueBorderLeft.png"));
                break;
            case ID.GREEN:
                name = "Green";
                borders[0] = new Texture(Gdx.files.internal("prov/greenBorderUp.png"));
                borders[1] = new Texture(Gdx.files.internal("prov/greenBorderRight.png"));
                borders[2] = new Texture(Gdx.files.internal("prov/greenBorderDown.png"));
                borders[3] = new Texture(Gdx.files.internal("prov/greenBorderLeft.png"));
                break;
            case ID.RED:
                name = "Red";
                borders[0] = new Texture(Gdx.files.internal("prov/redBorderUp.png"));
                borders[1] = new Texture(Gdx.files.internal("prov/redBorderRight.png"));
                borders[2] = new Texture(Gdx.files.internal("prov/redBorderDown.png"));
                borders[3] = new Texture(Gdx.files.internal("prov/redBorderLeft.png"));
                break;
            case ID.ORANGE:
                name = "Orange";
                borders[0] = new Texture(Gdx.files.internal("prov/orangeBorderUp.png"));
                borders[1] = new Texture(Gdx.files.internal("prov/orangeBorderRight.png"));
                borders[2] = new Texture(Gdx.files.internal("prov/orangeBorderDown.png"));
                borders[3] = new Texture(Gdx.files.internal("prov/orangeBorderLeft.png"));
                break;
        }
        provinceProjects = new ProvinceProject[11];
        provinceProjects[ProvinceProject.ID.FARM] = new ProvinceProject(ProvinceProject.ID.FARM);
        provinceProjects[ProvinceProject.ID.MINE] = new ProvinceProject(ProvinceProject.ID.MINE);
        provinceProjects[ProvinceProject.ID.LIBRARY] = new ProvinceProject(ProvinceProject.ID.LIBRARY);
        provinceProjects[ProvinceProject.ID.UNIVERSITY] = new ProvinceProject(ProvinceProject.ID.UNIVERSITY);
        provinceProjects[ProvinceProject.ID.WORKSHOP] = new ProvinceProject(ProvinceProject.ID.WORKSHOP);
        provinceProjects[ProvinceProject.ID.CITY] = new ProvinceProject(ProvinceProject.ID.CITY);
        provinceProjects[ProvinceProject.ID.WARRIOR] = new ProvinceProject(ProvinceProject.ID.WARRIOR);
        provinceProjects[ProvinceProject.ID.ARCHER] = new ProvinceProject(ProvinceProject.ID.ARCHER);
        provinceProjects[ProvinceProject.ID.SHIELDMAN] = new ProvinceProject(ProvinceProject.ID.SHIELDMAN);
        provinceProjects[ProvinceProject.ID.SWORDSMAN] = new ProvinceProject(ProvinceProject.ID.SWORDSMAN);
        provinceProjects[ProvinceProject.ID.CROSSBOWS] = new ProvinceProject(ProvinceProject.ID.CROSSBOWS);
        
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
        
        
        technologyInProcess = null;
        sciencePoints = 0;
    }
    
    public void onTurn() {
        population = 0;
        for (Province province : logicMain.provinces) {
            if (province.owner.id == id) {
                population += province.population;
                province.onTurn();
            }
        }
        if (sciencePoints >= technologyInProcess.cost) {
            technologies[technologyInProcess.id].research();
        }
    }
    
    public void selectTechnology(Technology technology) {
        technologyInProcess = technology;
    }
    
    public boolean isTurnAvailable() {
        for (Province province : logicMain.provinces) {
            if (province.owner.id == id) {
                if (!province.isTurnAvailable()) return false;
            }
        }
        if (technologyInProcess == null) return false;
        return true;
    }
    
    public static class ID {
        public final static int NOTHING = 0;
        public final static int BLUE = 1;
        public final static int GREEN = 2;
        public final static int RED = 3;
        public final static int ORANGE = 4;
    }
    
    public static class OTHERVALUES {
        public final static float STARTEATINGFOODCITIZEN = 2;
    }
}

