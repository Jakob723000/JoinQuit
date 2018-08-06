package com.jakob.joinQuitMessage.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.File;
import java.io.PrintWriter;

public class createjoinmessage implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (PermissionsEx.getUser(p).has("joinQuitMessage.commands")) {
                if (label.equalsIgnoreCase("createjoinmessage")  || label.equalsIgnoreCase("cjm")) {
                    // args in datei speichern
                    String path = System.getProperty("user.dir");
                    File directory = new File(path + "\\plugins\\joinQuitMessageMaker");
                    File file = new File(directory.getPath() + "\\join.txt");
                    try {
                        String out = "";
                        PrintWriter writer = new PrintWriter(file.getPath(), "UTF-8");
                        for (String s : args) {
                            out += s + " ";
                        }

                        if(out.trim().equalsIgnoreCase("null"))
                        {
                            p.sendMessage("Die join Message wird nicht angezeigt");
                        }
                        else
                        {
                            String playerMessage = out.replace("&", "§").replace("@p", p.getDisplayName());
                            p.sendMessage("Die join Message ist jetzt: " + playerMessage);
                        }

                        writer.write(out);
                        writer.close();
                    } catch (Exception e) {
                    }
                }
            }
        }
        return false;
    }

}
