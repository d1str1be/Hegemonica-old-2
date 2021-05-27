package ru.hegemonicaremake.gameplay.notifications;

import java.util.ArrayList;

import ru.hegemonicaremake.gameplay.Country;
import ru.hegemonicaremake.gameplay.Province;
import ru.hegemonicaremake.gameplay.Technology;
import ru.hegemonicaremake.gameplay.provinceProject.ProvinceProject;
import ru.hegemonicaremake.gameplay.provinceProject.units.WarUnit;

public class Notificator {

    public Country owner;
    public ArrayList<Notification> notifications;
    public int idCounter;

    public Notificator(Country owner) {
        this.owner = owner;
        notifications = new ArrayList<Notification>();
        idCounter = 0;
    }

    public void createNotification(ProvinceProject project, Province province) {
        notifications.add(new Notification(Notification.ID.PROJECTCOMPLETED, this));
        notifications.get(idCounter).setText(project.name + " has been created in " + province.name + ". Choose a new one!");
        idCounter++;
    }

    public void createNotification(WarUnit attacker, WarUnit defender) {
        notifications.add(new Notification(Notification.ID.UNITATTACKED, this));
        notifications.get(idCounter).setText("Your " + defender.name + " was attacked by " + attacker.owner.name + "'s " + attacker.name);
        idCounter++;
    }

    public void createNotification(Province province, Country invader) {
        notifications.add(new Notification(Notification.ID.PROVINCECAPTURED, this));
        notifications.get(idCounter).setText(province.name + " was captured by " + invader.name);
        idCounter++;
    }

    public void createNotification(Technology technology) {
        notifications.add(new Notification(Notification.ID.TECHNOLOGYRESEARCHED, this));
        notifications.get(idCounter).setText(technology.name + " has been researched. Choose a new one!");
        idCounter++;
    }
}
