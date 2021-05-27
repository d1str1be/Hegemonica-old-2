package ru.hegemonicaremake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.hegemonicaremake.logic.Country;
import ru.hegemonicaremake.logic.LogicMain;
import ru.hegemonicaremake.logic.Province;

public class ProvinceGFX {
    Pixmap borders;
    Pixmap rectangle;
    Province prov;
    Color color;
    int sideSize;
    Texture borderTexture;
    Texture rectTexture;
    Texture provTexture;
    
    public ProvinceGFX(Province prov) {
        this.prov = prov;
        this.sideSize = LogicMain.provinceSize;
        provTexture = new Texture(Gdx.files.internal("prov/grass.jpg"));
        
        setColor();
        borders = new Pixmap(sideSize, sideSize, Format.RGBA8888);
        borders.setColor(Color.WHITE);
        rectangle = new Pixmap(sideSize, sideSize, Format.RGBA8888);
        rectangle.setColor(Color.BLUE);
        
        drawRectangle();
        drawBorders();
    }
    
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(rectTexture, prov.x, prov.y);
        batch.draw(provTexture, prov.x, prov.y, sideSize, sideSize);
        batch.draw(borderTexture, prov.x, prov.y);
        batch.end();
    }
    
    public void update() {
        
        setColor();
    }
    
    public void setColor() {
        switch (prov.owner.id) {
            case Country.ID.NOTHING:
                color = Color.WHITE;
                break;
            case Country.ID.BLUE:
                color = Color.BLUE;
                break;
            case Country.ID.GREEN:
                color = Color.GREEN;
                break;
            case Country.ID.RED:
                color = Color.RED;
                break;
            case Country.ID.ORANGE:
                color = Color.ORANGE;
                break;
        }
    }
    
    public void drawBorders() {
        borders.drawRectangle(prov.x, prov.y, sideSize,sideSize);
        borderTexture = new Texture(borders);
        borders.dispose();
    }
    
    public void drawRectangle() {
        rectangle.drawRectangle(prov.x, prov.y, prov.x + sideSize, prov.y + sideSize);
        rectangle.fill();
        rectTexture = new Texture(rectangle);
        rectangle.dispose();
    }
    
    public void dispose() {
        rectangle.dispose();
        borders.dispose();
        borderTexture.dispose();
        rectTexture.dispose();
        provTexture.dispose();
    }
}
