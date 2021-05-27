package ru.hegemonicaremake;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontGenerator {
    public static BitmapFont generateFont(FileHandle fontFile) {
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 75;
        fontParameter.borderWidth = 5;
        fontParameter.borderColor = Color.BLACK;
        fontParameter.color = Color.WHITE;
        return fontGenerator.generateFont(fontParameter);
    }
    
    public static BitmapFont generateFont(FileHandle fontFile, int size) {
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = size;
        fontParameter.borderWidth = 5;
        fontParameter.borderColor = Color.BLACK;
        fontParameter.color = Color.WHITE;
        return fontGenerator.generateFont(fontParameter);
    }
    
    public static BitmapFont generateFont(FileHandle fontFile, int size, int borderWidth, Color borderColor) {
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = size;
        fontParameter.borderWidth = borderWidth;
        fontParameter.borderColor = borderColor;
        fontParameter.color = Color.WHITE;
        return fontGenerator.generateFont(fontParameter);
    }
    
    public static BitmapFont generateFont(FileHandle fontFile, Color fontColor) {
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 150;
        fontParameter.color = fontColor;
        return fontGenerator.generateFont(fontParameter);
    }
}
