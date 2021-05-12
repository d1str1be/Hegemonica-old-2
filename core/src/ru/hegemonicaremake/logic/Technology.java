package ru.hegemonicaremake.logic;

public class Technology {

    public int id;
    public float cost;
    public Country owner;
    public boolean isResearched;
    public String name;

    public Technology(int id, Country owner) {
        this.id = id;
        this.owner = owner;
        isResearched = false;
        switch (id) {
            case ID.ENGINEERING:
                cost = COST.ENGINEERING;
                name = "Engineering";
                break;
            case ID.PAPER:
                cost = COST.PAPER;
                name = "Paper";
                break;
            case ID.SIMPLYCHEMISTRY:
                cost = COST.SIMPLYCHEMISTRY;
                name = "Simply Chemistry";
                break;
            case ID.MACHINERY:
                cost = COST.MACHINERY;
                name = "Machinery";
                break;
            case ID.APPRENTICESHIP:
                cost = COST.APPRENTICESHIP;
                name = "Apprenticeship";
                break;
            case ID.EDUCATION:
                cost = COST.EDUCATION;
                name = "Education";
                break;
        }
    }

    public void research() {

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
