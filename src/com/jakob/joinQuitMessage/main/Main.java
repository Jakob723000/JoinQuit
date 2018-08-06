package com.jakob.joinQuitMessage.main;

import com.jakob.joinQuitMessage.commands.createjoinmessage;
import com.jakob.joinQuitMessage.commands.createquitmessage;
import com.jakob.joinQuitMessage.listener.JoinQuitHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onDisable() {
        System.out.println("JoinQuitMessageMaker deaktiviert");
    }

    @Override
    public void onEnable() {
        System.out.println("JoinQuitMessageMaker aktiviert");
        Bukkit.getPluginManager().registerEvents(new JoinQuitHandler(), this);
        getCommand("createjoinmessage").setExecutor(new createjoinmessage());
        getCommand("cjm").setExecutor(new createjoinmessage());
        getCommand("createquitmessage").setExecutor(new createquitmessage());
        getCommand("cqm").setExecutor(new createquitmessage());

    }

}
