package ru.hegemonicaremake;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontManager {
    static FreeTypeFontGenerator fontGenerator;
    static FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;
    static BitmapFont font;
    
    public FontManager() {
    }
    
    public static BitmapFont buildFont(FileHandle fontFile) {
        fontGenerator = new FreeTypeFontGenerator(fontFile);
        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        font = new BitmapFont();
        fontParameter.size = 150;
        fontParameter.borderWidth = 5;
        fontParameter.borderColor = Color.BLACK;
        fontParameter.color = Color.WHITE;
        font = fontGenerator.generateFont(fontParameter);
        return font;
    }
    
    public static BitmapFont buildFont(FileHandle fontFile, int size) {
        fontGenerator = new FreeTypeFontGenerator(fontFile);
        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        font = new BitmapFont();
        fontParameter.size = size;
        fontParameter.borderWidth = 5;
        fontParameter.borderColor = Color.BLACK;
        fontParameter.color = Color.WHITE;
        font = fontGenerator.generateFont(fontParameter);
        return font;
    }
    
    public static BitmapFont buildFont(FileHandle fontFile, int size, int borderWidth, Color borderColor) {
        fontGenerator = new FreeTypeFontGenerator(fontFile);
        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        font = new BitmapFont();
        fontParameter.size = size;
        fontParameter.borderWidth = borderWidth;
        fontParameter.borderColor = borderColor;
        fontParameter.color = Color.WHITE;
        font = fontGenerator.generateFont(fontParameter);
        return font;
    }
    
    public static BitmapFont buildFont(FileHandle fontFile, Color fontColor) {
        fontGenerator = new FreeTypeFontGenerator(fontFile);
        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        font = new BitmapFont();
        fontParameter.size = 150;
        fontParameter.color = fontColor;
        font = fontGenerator.generateFont(fontParameter);
        return font;
    }
    
    public static BitmapFont getFont() {
        return font;
    }
}
