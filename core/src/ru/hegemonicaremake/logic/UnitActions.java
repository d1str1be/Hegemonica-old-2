package ru.hegemonicaremake.logic;

import ru.hegemonicaremake.logic.provinceProject.units.WarUnit;

public class UnitActions {
    public void heal(WarUnit unit) {
        unit.health += 20;
        if (unit.health > 100) {
            unit.health = 100;
        }
        unit.movementPoints--;
    }

    public void destroy(WarUnit unit) {
        unit.province.unitThere = null;
        unit.owner.logicMain.units.set(unit.unitId, null);
    }

    public void move(WarUnit unit, Province province) {
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

    public void battle(WarUnit attacker, WarUnit defender) {
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

    public void capture(WarUnit unit) {
        unit.province.setOwner(unit.owner);
        unit.movementPoints--;
    }
}
