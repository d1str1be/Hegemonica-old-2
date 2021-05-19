package ru.hegemonicaremake.logic.notifications;

public class Notification {

    public int id;
    public Notificator notificator;
    public int notificatorId;
    public String text;

    public Notification(int id, Notificator notificator) {
        this.id = id;
        this.notificator = notificator;
        notificatorId = notificator.idCounter;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static class ID {
        public final static int PROJECTCOMPLETED = 0;
        public final static int UNITATTACKED = 1;
        public final static int PROVINCECAPTURED = 2;
        public final static int TECHNOLOGYRESEARCHED = 3;
    }
}
