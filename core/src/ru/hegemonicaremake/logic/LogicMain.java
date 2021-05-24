package ru.hegemonicaremake.logic;

import java.util.ArrayList;

import ru.hegemonicaremake.logic.provinceProject.units.WarUnit;

public class LogicMain {

    public Province[] provinces;

    //units
    public ArrayList<WarUnit> units;
    public int unitIdCounter;

    //map
    public int mapHeight;
    public int mapWidth;
    public float provinceSize;

    //Game process
    public int playersQuantity;
    public int turn;
    public Country turnCountry;
    public Country[] countries;

    public LogicMain() {
        turn = 1;
        unitIdCounter = 0;
        units = new ArrayList<WarUnit>();
        countries = new Country[playersQuantity + 1];
        switch (playersQuantity) {
            case Country.ID.ORANGE:
                countries[Country.ID.ORANGE] = new Country(Country.ID.ORANGE);
            case Country.ID.RED:
                countries[Country.ID.RED] = new Country(Country.ID.RED);
            case Country.ID.GREEN:
                countries[Country.ID.GREEN] = new Country(Country.ID.GREEN);
            case Country.ID.BLUE:
                countries[Country.ID.BLUE] = new Country(Country.ID.BLUE);
                countries[Country.ID.NOTHING] = new Country(Country.ID.NOTHING);
                break;
        }
        turnCountry = countries[Country.ID.BLUE];
    }

    public void onTurn() {
        countries[turnCountry.id].onTurn();
        if (turnCountry.id == playersQuantity) {
            turnCountry = countries[Country.ID.BLUE];
        } else {
            turnCountry = countries[turnCountry.id + 1];
        }
    }
}
