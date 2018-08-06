package com.jakob.joinQuitMessage.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.BufferedReader;
import java.io.FileReader;

public class JoinQuitHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent pje) {
        String path = System.getProperty("user.dir");
        String fileName = path + "\\plugins\\joinQuitMessageMaker\\join.txt";

        System.out.println(fileName);
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            line = bufferedReader.readLine();

            // Always close files.
            bufferedReader.close();
        } catch (Exception ex) {
            pje.setJoinMessage(pje.getPlayer().getDisplayName() + " ist gejoint");
        }
        line = line.replace("&", "§");
        line = line.replace("@p", pje.getPlayer().getDisplayName());
        pje.setJoinMessage(line);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent pqe) {
        String path = System.getProperty("user.dir");
        String fileName = path + "\\plugins\\joinQuitMessageMaker\\quit.txt";

        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            line = bufferedReader.readLine();

            // Always close files.
            bufferedReader.close();
        } catch (Exception ex) {
            pqe.setQuitMessage(pqe.getPlayer().getDisplayName() + " ist geleavt");
        }
        line = line.replace("&", "§");
        line = line.replace("@p", pqe.getPlayer().getDisplayName());
        pqe.setQuitMessage(line);
    }


}
