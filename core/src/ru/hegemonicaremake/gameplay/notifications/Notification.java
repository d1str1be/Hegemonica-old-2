package ru.hegemonicaremake.gameplay.notifications;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.graphics.Texture;

public class Notification {
    
    public int id;
    public Texture icon;
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
    
    public void setIcon(){
        switch (id){
            case ID.PROJECTCOMPLETED:
                Files files;
                icon = new Texture(files.internal());
                break;
        }
    }
}
