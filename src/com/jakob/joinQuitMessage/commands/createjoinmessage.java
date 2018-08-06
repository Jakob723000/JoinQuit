package com.jakob.joinQuitMessage.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class createjoinmessage implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (PermissionsEx.getUser(p).has("joinQuittMessage.commands")) {
                if (label.equalsIgnoreCase("createjoinmessage")  || label.equalsIgnoreCase("cjm")) {
                    // args in datei speichern
                    String path = System.getProperty("user.dir");
                    File directory = new File(path + "\\plugins\\joinQuitMessageMaker");
                    if (!directory.exists()) {
                        new File(directory.getPath()).mkdir();
                    }
                    File file = new File(directory.getPath() + "\\join.txt");
                    try {
                        String out = "";
                        if(!args[args.length-1].contains("&"))
                        {
                            p.sendMessage("Es muss 'text &colorcode' als text genommen werden! (@p ist der Username)");
                            return false;
                        }
                        String color = args[args.length - 1].replace("&", "").trim();
                        char colorChar = color.charAt(0);
                        if(!((colorChar >= '0' && colorChar <= '9') || (colorChar >= 'a' && colorChar <= 'f')))
                        {
                            p.sendMessage("Dieser Colorcode existiert nicht!");
                            return false;
                        }
                        PrintWriter writer = new PrintWriter(file.getPath(), "UTF-8");
                        for (String s : args) {
                            out += s + " ";
                        }
                        writer.write(out);
                        writer.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}
