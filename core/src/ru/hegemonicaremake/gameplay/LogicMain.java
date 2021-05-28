package ru.hegemonicaremake.gameplay;

import java.util.ArrayList;

import ru.hegemonicaremake.gameplay.provProject.ProvinceProject;
import ru.hegemonicaremake.gameplay.provProject.WarUnit;

public class LogicMain {
    //units
    public ArrayList<WarUnit> units;
    public int unitIdCounter;
    
    //map
    public HegeMap map;
    public int mapSizeId;
    public int mapHeight;
    public int mapWidth;
    public static final int provinceSize = 200;
    
    
    //Game process
    public int playersQuantity;
    public int turn;
    public Country turnCountry;
    public Country[] countries;
    public Province selectedProvince;
    public Province[] provinces;
    
    public LogicMain(int mapSizeId, HegeMap map) {
        this.mapSizeId = mapSizeId;
        this.map = map;
        turn = 1;
        unitIdCounter = 0;
        units = new ArrayList<WarUnit>();
        switch (mapSizeId) {
            case MAPSIZEID.EXPERIMENTAL:
                mapHeight = 3;
                mapWidth = 3;
                countries = new Country[2];
                countries[Country.ID.NOTHING] = new Country(Country.ID.NOTHING, this);
                countries[Country.ID.BLUE] = new Country(Country.ID.BLUE, this);
                provinces = new Province[9];
                for (int i = 0; i < 9; i++) {
                    provinces[i] = new Province(i, this, countries[Country.ID.NOTHING]);
                    setProvinceCoordinates(i);
                }
                for (int i = 0; i < 9; i++) {
                    provinces[i].setNeighbors();
                }
                provinces[4].owner = countries[Country.ID.BLUE];
                units.add(new WarUnit(ProvinceProject.ID.WARRIOR, provinces[4]));
                break;
            case MAPSIZEID.LITTLE:
                mapHeight = 4;
                mapWidth = 4;
                countries = new Country[3];
                countries[Country.ID.NOTHING] = new Country(Country.ID.NOTHING, this);
                countries[Country.ID.BLUE] = new Country(Country.ID.BLUE, this);
                countries[Country.ID.GREEN] = new Country(Country.ID.GREEN, this);
                provinces = new Province[16];
                for (int i = 0; i < 16; i++) {
                    provinces[i] = new Province(i, this, countries[Country.ID.NOTHING]);
                    setProvinceCoordinates(i);
                }
                for (int i = 0; i < 16; i++) {
                    provinces[i].setNeighbors();
                }
                provinces[0].owner = countries[Country.ID.BLUE];
                provinces[15].owner = countries[Country.ID.GREEN];
                units.add(new WarUnit(ProvinceProject.ID.WARRIOR, provinces[0]));
                units.add(new WarUnit(ProvinceProject.ID.WARRIOR, provinces[15]));
                break;
            case MAPSIZEID.STANDARD:
                mapHeight = 5;
                mapWidth = 5;
                countries = new Country[4];
                countries[Country.ID.NOTHING] = new Country(Country.ID.NOTHING, this);
                countries[Country.ID.BLUE] = new Country(Country.ID.BLUE, this);
                countries[Country.ID.GREEN] = new Country(Country.ID.GREEN, this);
                countries[Country.ID.RED] = new Country(Country.ID.RED, this);
                provinces = new Province[25];
                for (int i = 0; i < 25; i++) {
                    provinces[i] = new Province(i, this, countries[Country.ID.NOTHING]);
                    setProvinceCoordinates(i);
                }
                for (int i = 0; i < 25; i++) {
                    provinces[i].setNeighbors();
                }
                provinces[0].owner = countries[Country.ID.BLUE];
                provinces[4].owner = countries[Country.ID.GREEN];
                provinces[24].owner = countries[Country.ID.RED];
                units.add(new WarUnit(ProvinceProject.ID.WARRIOR, provinces[0]));
                units.add(new WarUnit(ProvinceProject.ID.WARRIOR, provinces[4]));
                units.add(new WarUnit(ProvinceProject.ID.WARRIOR, provinces[24]));
                break;
            case MAPSIZEID.BIG:
                mapHeight = 6;
                mapWidth = 6;
                countries = new Country[5];
                countries[Country.ID.NOTHING] = new Country(Country.ID.NOTHING, this);
                countries[Country.ID.BLUE] = new Country(Country.ID.BLUE, this);
                countries[Country.ID.GREEN] = new Country(Country.ID.GREEN, this);
                countries[Country.ID.RED] = new Country(Country.ID.RED, this);
                countries[Country.ID.ORANGE] = new Country(Country.ID.ORANGE, this);
                provinces = new Province[36];
                for (int i = 0; i < 36; i++) {
                    provinces[i] = new Province(i, this, countries[Country.ID.NOTHING]);
                    setProvinceCoordinates(i);
                }
                for (int i = 0; i < 36; i++) {
                    provinces[i].setNeighbors();
                }
                provinces[0].owner = countries[Country.ID.BLUE];
                provinces[5].owner = countries[Country.ID.GREEN];
                provinces[30].owner = countries[Country.ID.RED];
                provinces[35].owner = countries[Country.ID.ORANGE];
                units.add(new WarUnit(ProvinceProject.ID.WARRIOR, provinces[0]));
                units.add(new WarUnit(ProvinceProject.ID.WARRIOR, provinces[5]));
                units.add(new WarUnit(ProvinceProject.ID.WARRIOR, provinces[30]));
                units.add(new WarUnit(ProvinceProject.ID.WARRIOR, provinces[35]));
                break;
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
        provinces[id].y = (id / mapHeight) * provinceSize;
    }
    
    public static class MAPSIZEID {
        public final static int EXPERIMENTAL = 0;
        public final static int LITTLE = 1;
        public final static int STANDARD = 2;
        public final static int BIG = 3;
    }
    
    public boolean findTappedProvince(float x, float y) {
        for (Province province : provinces) {
            if (province.contains(x, y)) {
                selectedProvince = province;
                return true;
            }
        }
        return false;
    }
    
    
}
