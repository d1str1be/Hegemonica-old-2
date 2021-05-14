package ru.hegemonicaremake.logic;

import java.util.ArrayList;

import ru.hegemonicaremake.logic.provinceProject.units.WarUnit;

public class LogicMain {

    public Province[] provinces;
    public int turn;

    //units
    ArrayList<WarUnit> units;
    public int unitIdCounter;

    public LogicMain() {
        turn = 1;
        unitIdCounter = 0;
    }
}
