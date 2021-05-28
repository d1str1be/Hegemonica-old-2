package ru.hegemonicaremake.gameplay.notifications;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
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
                icon = new Texture(Gdx.files.internal("icons/notifications/projectCompleted.png"));
                break;
            case ID.UNITATTACKED:
                icon = new Texture(Gdx.files.internal("icons/notifications/unitAttacked.png"));
                break;
            case ID.PROVINCECAPTURED:
                icon = new Texture(Gdx.files.internal("icons/notifications/provinceCaptured.png"));
                break;
            case ID.TECHNOLOGYRESEARCHED:
                icon = new Texture(Gdx.files.internal("icons/notifications/technologyResearched.png"));
                break;
        }
    }
}
