package ru.hegemonicaremake.logic;

import java.util.ArrayList;

import ru.hegemonicaremake.logic.provinceProject.units.WarUnit;

public class LogicMain {

    public Province[] provinces;

    //units
    public ArrayList<WarUnit> units;
    public int unitIdCounter;

    //map
    public int mapSizeId;
    public int mapHeight;
    public int mapWidth;
    public float provinceSize;

    //Game process
    public int playersQuantity;
    public int turn;
    public Country turnCountry;
    public Country[] countries;

    public LogicMain(int mapSizeId) {
        this.mapSizeId = mapSizeId;
        turn = 1;
        unitIdCounter = 0;
        units = new ArrayList<WarUnit>();
        switch (mapSizeId) {
            case MAPSIZEID.EXPERIMENTAL:
                mapHeight = 3;
                mapWidth = 3;
                provinces = new Province[9];
                for (int i = 0; i < 9; i++) {
                    provinces[i] = new Province(i);
                    setProvinceCoordinates(i);
                }
                for (int i = 0; i < 9; i++) {
                    provinces[i].setNeighbors();
                }

                countries = new Country[2];
                countries[Country.ID.NOTHING] = new Country(Country.ID.NOTHING);
                countries[Country.ID.BLUE] = new Country(Country.ID.BLUE);
                for (int i = 0; i < 9; i++) {
                    provinces[i].owner = countries[Country.ID.NOTHING];
                }
                provinces[4].owner = countries[Country.ID.BLUE];
        }
        turnCountry = countries[Country.ID.BLUE];
    }

    public void onTurn() {
        countries[turnCountry.id].onTurn();
        if (turnCountry.id == playersQuantity) {
            turnCountry = countries[Country.ID.BLUE];
            turn++;
        } else {
            turnCountry = countries[turnCountry.id + 1];
        }
    }

    public void setProvinceCoordinates(int id) {
        provinces[id].x = (id % mapWidth) * provinceSize;
        provinces[id].y = (id / mapWidth) * provinceSize;
    }

    public static class MAPSIZEID {
        public final static int EXPERIMENTAL = 0;
        public final static int LITTLE = 1;
        public final static int STANDARD = 2;
        public final static int BIG = 3;
    }
}
