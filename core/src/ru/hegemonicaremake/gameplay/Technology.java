package ru.hegemonicaremake.gameplay;

import ru.hegemonicaremake.gameplay.provProject.ProvinceProject;

public class Technology {
    
    public int id;
    public float cost;
    public Country owner;
    public boolean isResearched;
    public boolean isAvailable;
    public String name;
    public Technology[] requiredTechnologies;
    
    public Technology(int id, Country owner) {
        this.id = id;
        this.owner = owner;
        isResearched = false;
        switch (id) {
            case ID.ENGINEERING:
                cost = COST.ENGINEERING;
                name = "Engineering";
                requiredTechnologies = new Technology[0];
                break;
            case ID.PAPER:
                cost = COST.PAPER;
                name = "Paper";
                requiredTechnologies = new Technology[0];
                break;
            case ID.SIMPLYCHEMISTRY:
                cost = COST.SIMPLYCHEMISTRY;
                name = "Simply Chemistry";
                requiredTechnologies = new Technology[0];
                break;
            case ID.MACHINERY:
                cost = COST.MACHINERY;
                name = "Machinery";
                requiredTechnologies = new Technology[1];
                break;
            case ID.APPRENTICESHIP:
                cost = COST.APPRENTICESHIP;
                name = "Apprenticeship";
                requiredTechnologies = new Technology[2];
                break;
            case ID.EDUCATION:
                cost = COST.EDUCATION;
                name = "Education";
                requiredTechnologies = new Technology[2];
                break;
        }
    }

    public void setRequiredTechnologies() {
        switch (id) {
            case ID.ENGINEERING:
                break;
            case ID.PAPER:
                break;
            case ID.SIMPLYCHEMISTRY:
                break;
            case ID.APPRENTICESHIP:
                requiredTechnologies[0] = owner.technologies[ID.ENGINEERING];
                requiredTechnologies[1] = owner.technologies[ID.PAPER];
                break;
            case ID.MACHINERY:
                requiredTechnologies[0] = owner.technologies[ID.ENGINEERING];
                break;
            case ID.EDUCATION:
                requiredTechnologies[0] = owner.technologies[ID.PAPER];
                requiredTechnologies[1] = owner.technologies[ID.SIMPLYCHEMISTRY];
                break;
        }
    }
    
    public void research() {
        isResearched = true;
        owner.sciencePoints -= cost;
        owner.technologyInProcess = null;
        switch (id) {
            case ID.ENGINEERING:
                owner.mineProduction += 1;
                owner.provinceProjects[ProvinceProject.ID.ARCHER].unlock();
                owner.provinceProjects[ProvinceProject.ID.SHIELDMAN].unlock();
                break;
            case ID.PAPER:
                owner.citizenScienceProduction += 0.5;
                owner.provinceProjects[ProvinceProject.ID.LIBRARY].unlock();
                break;
            case ID.SIMPLYCHEMISTRY:
                owner.farmFoodProduction += 1;
                break;
            case ID.MACHINERY:
                owner.citizenProduction += 0.25;
                owner.provinceProjects[ProvinceProject.ID.CROSSBOWS].unlock();
                break;
            case ID.APPRENTICESHIP:
                owner.mineProduction += 1;
                owner.provinceProjects[ProvinceProject.ID.SWORDSMAN].unlock();
                break;
            case ID.EDUCATION:
                owner.citizenScienceProduction += 1;
                owner.libraryScienceProduction += 2;
                owner.provinceProjects[ProvinceProject.ID.UNIVERSITY].unlock();
                break;
        }
    }

    public boolean isAvailable() {
        for (Technology technology : requiredTechnologies) {
            if (!owner.technologies[technology.id].isResearched) return false;
        }
        return true;
    }
    
    public static class ID {
        public final static int ENGINEERING = 0;
        public final static int PAPER = 1;
        public final static int SIMPLYCHEMISTRY = 2;
        public final static int MACHINERY = 3;
        public final static int APPRENTICESHIP = 4;
        public final static int EDUCATION = 5;
    }
    
    public static class COST {
        public final static float ENGINEERING = 15;
        public final static float PAPER = 15;
        public final static float SIMPLYCHEMISTRY = 15;
        public final static float MACHINERY = 45;
        public final static float APPRENTICESHIP = 45;
        public final static float EDUCATION = 45;
    }
}
