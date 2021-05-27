package ru.hegemonicaremake.utils;

import com.badlogic.gdx.Gdx;

import ru.hegemonicaremake.HegeGame;

public class HegeLog {
    final static public String HEGEMONICA = "Hegemonica";
    final static public String INPUT = "Input";
    final static public String MAINMENU = "Main Menu";
    final static public String MAP = "Map";
    final static public String HUD = "HUD";
    final static public String COUNTRY = "Country Logs";
    final static public String PROVINCE = "Province Logs";

    public static void log(String logTag, String message) {
        if (HegeGame.DEV_MODE)
            Gdx.app.log(logTag, message);
    }
}
