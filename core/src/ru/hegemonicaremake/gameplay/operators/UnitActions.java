package ru.hegemonicaremake.gameplay.operators;

import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.gameplay.provinceProject.units.WarUnit;

public class UnitActions {

    public static void onTurn(WarUnit unit) {
        if (unit != null) {
            unit.movementPoints = unit.startMovementPoints;
        }
    }

    public static void heal(WarUnit unit) {
        unit.health += 20;
        if (unit.health > 100) {
            unit.health = 100;
        }
        unit.movementPoints--;
    }

    public static void destroy(WarUnit unit) {
        unit.province.unitThere = null;
        unit.owner.logicMain.units.set(unit.unitId, null);
    }

    public static void move(WarUnit unit, Province province) {
        if (province.unitThere != null) {
            battle(unit, province.unitThere);
            if (province.unitThere == null) {
                unit.province.unitThere = null;
                province.unitThere = unit;
                unit.province = province;
            }
        } else {
            unit.province.unitThere = null;
            province.unitThere = unit;
            unit.province = province;
            unit.movementPoints--;
        }
    }

    public static void battle(WarUnit attacker, WarUnit defender) {
        defender.health -= 30 * Math.pow(2.72, (attacker.attackStrength - defender.defenseStrength) / 25);
        if (defender.health <= 0) {
            destroy(defender);
            attacker.movementPoints--;
        } else {
            if (!attacker.isRanged) {
                attacker.health -= 30 * Math.pow(2.72, (defender.defenseStrength - attacker.attackStrength) / 25);
                if (attacker.health <= 0) {
                    destroy(attacker);
                } else {
                    attacker.movementPoints--;
                }
            }
        }
    }

    public static void capture(WarUnit unit) {
        unit.province.setOwner(unit.owner);
        unit.movementPoints--;
    }

    public static boolean isMovable(WarUnit unit, Province province) {
        if (unit.movementPoints > 0) {
            if (unit.province.isNeighbor(province)) {
                if (province.unitThere == null) {
                    return true;
                } else if (province.unitThere.owner.id == unit.owner.id) {
                    return false;
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
