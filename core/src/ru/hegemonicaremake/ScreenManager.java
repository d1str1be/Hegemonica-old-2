package ru.hegemonicaremake;

import com.badlogic.gdx.Screen;

import ru.hegemonicaremake.screens.MainMenu;

public class ScreenManager {
    HegeGame game;
    
    public ScreenManager(HegeGame game) {
        this.game = game;
        this.launch(new MainMenu(game));
    }
    
    public void setScreen(Screen nextScreen) {
        try {
            game.setScreen(nextScreen);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HegeLog.log("ScreenManager", "Changed screen to " + nextScreen.getClass().getName());
    }
    
    public void launch(Screen screen) {
        try {
            game.setScreen(screen);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HegeLog.log("ScreenManager", "Changed screen to " + screen.getClass().getName());
    }
}
