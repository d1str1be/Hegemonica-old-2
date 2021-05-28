package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

import ru.hegemonicaremake.gameplay.provProject.WarUnit;

public class LogicMain {
    
    public Province[] provinces;
    
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
                for (int i = 0; i < 9; i++) {
                    provinces[i].owner = countries[Country.ID.NOTHING];
                }
                provinces[4].owner = countries[Country.ID.BLUE];
                break;
            case MAPSIZEID.LITTLE:
                break;
        }
        turnCountry = countries[Country.ID.BLUE];
    }

    public void update() {
        map.update();
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
    
    public Province findTappedProvince(float x, float y) {
        for (Province province : provinces) {
            if (province.contains(x, y))
                return province;
        }
        return null;
    }
    
    public void initStage(Stage stage) {
        for (Province prov : provinces) {
            prov.addToStage(stage);
        }
    }
}
