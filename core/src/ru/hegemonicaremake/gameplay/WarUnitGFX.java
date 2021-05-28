package ru.hegemonicaremake.gameplay;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import ru.hegemonicaremake.gameplay.provProject.WarUnit;
import ru.hegemonicaremake.gameplay.ui.HegeProgressBar;
import ru.hegemonicaremake.utils.HegeLog;

public class WarUnitGFX {
    
    
    public final int id;
    Sprite unitSprite;
    public Texture unitIcon;
    public Pixmap healthBarBorder;
    public Texture healthBarBorderTexture;
    public HegeProgressBar healthBar;
    Label hp;
    SpriteBatch batch;
    
    public WarUnitGFX(final int id, Province prov) {
        this.id = id;
        this.setTexture(prov.owner);
        unitSprite = new Sprite(unitIcon);
        unitSprite.setSize(LogicMain.provinceSize * 0.5f, LogicMain.provinceSize * 0.5f);
        unitSprite.setPosition(prov.x + LogicMain.provinceSize * 0.25f, prov.y + LogicMain.provinceSize * 0.25f);
        healthBar = new HegeProgressBar(LogicMain.provinceSize * 0.6f, LogicMain.provinceSize * 0.1f);
        healthBar.setPosition(prov.x + LogicMain.provinceSize * 0.2f, prov.y + LogicMain.provinceSize * 0.8f);
        healthBar.setRange(0, WarUnit.maxHealth);
        healthBar.setValue(WarUnit.maxHealth);
        healthBar.updateVisualValue();
//        hp = new Label("0 / 100", prov.owner.gemelch.hud.DefaultUI);
//        hp.setFontScale(0.4f);
//        hp.setScale(0.4f);
//        hp.setPosition(healthBar.getX(), healthBar.getY());
        batch = new SpriteBatch();
        
        healthBarBorder = new Pixmap((int) healthBar.getWidth(), (int) healthBar.getHeight(), Pixmap.Format.RGBA8888);
        healthBarBorder.fillRectangle(0, 0, 5, (int) healthBar.getHeight());
        healthBarBorder.fillRectangle(0, 0, (int) healthBar.getWidth(), 5);
        healthBarBorder.fillRectangle((int) healthBar.getWidth() - 5, 0, 5, (int) healthBar.getHeight());
        healthBarBorder.fillRectangle(0, (int) healthBar.getHeight() - 5, (int) healthBar.getWidth(), 5);
        healthBarBorderTexture = new Texture(healthBarBorder);
    }
    
    public void setHealth(WarUnit unit) {
        HegeLog.log("WarUnitGFX", "Set unit`s health in " + unit.province.name + " to " + unit.health);
        healthBar.setValue(unit.health);
        healthBar.updateVisualValue();
    }
    
    public void setHealth(Float hp) {
        healthBar.setValue(hp);
        healthBar.updateVisualValue();
    }
    
    public void setTexture(Country owner) {
        unitIcon = UnitIconBuilder.buildIcon(owner.id, id);
    }
    
    public Sprite getSprite() {
        return unitSprite;
    }
    
    public Texture getTexture() {
        return unitIcon;
    }
    
    public void update(WarUnit unit) {
        healthBar.setPosition(unit.province.x + LogicMain.provinceSize * 0.2f, unit.province.y + LogicMain.provinceSize * 0.8f);
        this.setHealth(unit);
        this.healthBar.updateVisualValue();
        unitSprite.setPosition(unit.province.x + LogicMain.provinceSize * 0.25f, unit.province.y + LogicMain.provinceSize * 0.25f);
    }
    
    public void render(SpriteBatch batch) {
//        hp.draw(batch, 1f);
        batch.draw(healthBarBorderTexture, healthBar.getX(), healthBar.getY(), healthBar.getWidth(), healthBar.getHeight());
        healthBar.draw(batch, 1f);
        unitSprite.draw(batch);
        
    }
    
    public void dispose() {
        batch.dispose();
        unitIcon.dispose();
        healthBarBorder.dispose();
        healthBarBorderTexture.dispose();
    }
    
    
}
