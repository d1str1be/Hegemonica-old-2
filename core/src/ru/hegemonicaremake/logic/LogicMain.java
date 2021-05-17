package ru.hegemonicaremake.logic;

import java.util.ArrayList;

import ru.hegemonicaremake.logic.provinceProject.units.WarUnit;

public class LogicMain {

    public Province[] provinces;
    public int turn;

    //units
    public ArrayList<WarUnit> units;
    public int unitIdCounter;

    //map
    public int mapHeight;
    public int mapWidth;
    public float provinceSize;

    public LogicMain() {
        turn = 1;
        unitIdCounter = 0;
        units = new ArrayList<WarUnit>();
    }
}
