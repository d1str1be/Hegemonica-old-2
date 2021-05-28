package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import ru.hegemonicaremake.HegeGame;

public class ProvinceGFX {
    Pixmap borders;
    Pixmap rectangle;
    Province prov;
    Color color;
    int sideSize;
    Texture borderTexture;
    Texture rectTexture;
    Texture provTexture;

    // borders
    Texture[] pBorders;
    
    
    Label provName;
    Image unitIcon;
    
    public ProvinceGFX(Province prov) {
        this.prov = prov;
        this.sideSize = LogicMain.provinceSize;
        this.setColor();
        provTexture = new Texture(Gdx.files.internal("prov/provinceDefault.png"));
        pBorders = new Texture[4];
        pBorders[0] = new Texture(Gdx.files.internal("prov/blueBorderUp.png"));
        pBorders[1] = new Texture(Gdx.files.internal("prov/blueBorderRight.png"));
        pBorders[2] = new Texture(Gdx.files.internal("prov/blueBorderDown.png"));
        pBorders[3] = new Texture(Gdx.files.internal("prov/blueBorderLeft.png"));
        borders = new Pixmap(sideSize, sideSize, Format.RGBA8888);
        borders.setColor(color);
        rectangle = new Pixmap(sideSize, sideSize, Format.RGBA8888);
        rectangle.setColor(Color.BLUE);
        
        drawRectangle();
        drawBorders();
        
        provName = new Label(prov.name, HegeGame.skinManager.provNameStyle);
        provName.setPosition(prov.x  - provName.getWidth(), prov.y );
        
        
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(rectTexture, prov.x, prov.y);
        batch.draw(provTexture, prov.x, prov.y, sideSize, sideSize);
        batch.draw(borderTexture, prov.x, prov.y);
        provName.draw(batch, 1f);
    }
    
    public void update(SpriteBatch batch) {
        if (prov.owner.id != Country.ID.NOTHING) {
            if (prov.northernProvince != null) {
                if (prov.owner.id == prov.northernProvince.owner.id) {
                    batch.draw(pBorders[0], prov.x, prov.y, sideSize, sideSize);
                }
            }
            if (prov.easternProvince != null) {
                if (prov.owner.id == prov.easternProvince.owner.id) {
                    batch.draw(pBorders[1], prov.x, prov.y, sideSize, sideSize);
                }
            }
            if (prov.southernProvince != null) {
                if (prov.owner.id == prov.southernProvince.owner.id) {
                    batch.draw(pBorders[2], prov.x, prov.y, sideSize, sideSize);
                }
            }
            if (prov.westernProvince != null) {
                if (prov.owner.id == prov.westernProvince.owner.id) {
                    batch.draw(pBorders[3], prov.x, prov.y, sideSize, sideSize);
                }
            }
        }
    }
    
    public void addToStage(Stage stage) {
        stage.addActor(provName);
        //добавить иконку в стейдж
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
        setColor();
//        borders.drawRectangle(prov.x, prov.y, sideSize,sideSize);
        
        borders.fillRectangle(0, 0, 5, sideSize);
        borders.fillRectangle(0, 0, sideSize, 5);
        borders.fillRectangle(sideSize - 5, 0, 5, sideSize);
        borders.fillRectangle(0, sideSize - 5, sideSize, 5);
        borderTexture = new Texture(borders);
        borders.dispose();
    }
    
    public void drawRectangle() {
        setColor();
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
