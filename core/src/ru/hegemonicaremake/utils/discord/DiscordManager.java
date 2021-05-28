package ru.hegemonicaremake.utils.discord;

import com.badlogic.gdx.Gdx;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

import ru.hegemonicaremake.utils.HegeLog;

public class DiscordManager {
    final String appID = "837736520789262386";
    final boolean DEV_MODE;
    DiscordRPC rpc;
    public DiscordRichPresence discordPresence;
    
    long timeOfGameStart;
    
    public DiscordManager(boolean isDevMode) {
        this.startup();
        DEV_MODE = isDevMode;
        if (isDevMode)
            this.devMode();
        else
            this.onMainMenu();
        
    }
    
    public void startup() {
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
            @Override
            public void apply(DiscordUser user) {
                Gdx.app.log(HegeLog.HEGEMONICA, "Welcome " + user.username + "#" + user.discriminator + "!");
            }
        }).build();
        
        discordPresence = new DiscordRichPresence();
        
        rpc = new DiscordRPC();
        rpc.discordInitialize(appID, handlers, true);
    }
    
    public void onMainMenu() {
        discordPresence.state = "In Main Menu";
        discordPresence.startTimestamp = setStartTimeStamp();
        discordPresence.largeImageKey = "hegemonicalogo";
        rpc.discordUpdatePresence(discordPresence);
    }
    
    public void onPlaying() {
        DiscordRichPresence discordPresence = new DiscordRichPresence();
        discordPresence.state = "";
        timeOfGameStart = setStartTimeStamp();
        discordPresence.startTimestamp = setStartTimeStamp();
        discordPresence.largeImageKey = "hegemonicalogo";
        rpc.discordUpdatePresence(discordPresence);
    }
    
    public void onPlaying(int turnNumber) {
        discordPresence.state = "Turn " + turnNumber;
        discordPresence.startTimestamp = timeOfGameStart;
        discordPresence.largeImageKey = "hegemonicalogo";
        rpc.discordUpdatePresence(discordPresence);
    }
    
    public long setStartTimeStamp() {
        return System.currentTimeMillis();
    }
    
    public void devMode() {
        DiscordRichPresence discordPresence = new DiscordRichPresence();
        discordPresence.state = "[DEV] Working on game";
        discordPresence.startTimestamp = setStartTimeStamp();
        discordPresence.largeImageKey = "hegemonicalogo";
        rpc.discordUpdatePresence(discordPresence);
    }
    
    public void stopRPC() {
        rpc.discordShutdown();
        rpc.discordClearPresence();
    }
}
