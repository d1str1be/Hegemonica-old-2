package ru.hegemonicaremake.gameplay.operators;

import ru.hegemonicaremake.gameplay.LogicMain;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.gameplay.provProject.WarUnit;
import ru.hegemonicaremake.utils.HegeLog;

public class UnitActions {
    
    public static void onTurn(WarUnit unit) {
        if (unit != null) {
            unit.movementPoints = unit.startMovementPoints;
            heal(unit);
        }
    }
    
    public static void heal(WarUnit unit) {
        unit.health += 20;
        if (unit.health > 100) {
            unit.health = 100;
        }
        unit.gfx.update(unit);
    }
    
    public static void destroy(WarUnit unit) {
        unit.province.unit = null;
        unit.owner.logicMain.units.set(unit.unitId, null);
        unit.gfx.update(unit);
    }
    
    public static void move(WarUnit unit, Province province) {
        if (isMovable(unit, province)) {
            if (province.unit != null) {
                battle(unit, province.unit);
                if (province.unit == null) {
                    unit.province.unit = null;
                    province.unit = unit;
                    unit.province = province;
                    capture(unit);
                    unit.gfx.update(unit);
                }
            } else {
                unit.province.unit = null;
                province.unit = unit;
                unit.province = province;
                unit.movementPoints--;
                capture(unit);
                unit.gfx.update(unit);
            }
        }
        LogicMain.movingUnit = null;
    }
    
    public static void battle(WarUnit attacker, WarUnit defender) {
        attack(attacker, defender);
        attacker.gfx.update(attacker);
        defender.gfx.update(defender);
    }

    public static void defend(WarUnit attacker, WarUnit defender) {
        defender.health -= 30 * Math.pow(2.72, (attacker.attackStrength - defender.defenseStrength) / 25);
        if (defender.health <= 0) {
            destroy(defender);
        }
        HegeLog.log("Battle", "unit of " + defender.owner.name + " was attacked");
    }

    public static void attack(WarUnit attacker, WarUnit defender) {
        attacker.movementPoints--;
        Province province = defender.province;
        defend(attacker, defender);
        if (province.unit != null) {
            attacker.health -= 30 * Math.pow(2.72, (defender.defenseStrength - attacker.attackStrength) / 25);
        }
        if (attacker.health <= 0) {
            destroy(attacker);
        }
    }
    
    public static void capture(WarUnit unit) {
        unit.province.setOwner(unit.owner);
        unit.gfx.update(unit);
    }
    
    public static boolean isMovable(WarUnit unit, Province province) {
        if (unit.movementPoints > 0) {
            if (unit.province.isNeighbor(province)) {
                if (province.unit == null) {
                    return true;
                } else if (province.unit.owner.id == unit.owner.id) {
                    return false;
                } else if (province.unit.owner.id != unit.owner.id) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean isCanCapture(WarUnit unit, Province province) {
        if (unit.movementPoints > 0) {
            if (unit.owner.id == province.owner.id) return true;
        }
        return false;
    }
}
