package ch.pixeltv.main;

import ch.pixeltv.commands.teamchat;
import ch.pixeltv.util.fileconfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Coded by PixelTeleV
 * 01.09.18
 * Copyright PixelTeleV 2018.
 * Give Credits if changing SourceCode!
 * Coded with Intellij
 */
public class main extends JavaPlugin {

    //Version String
    public static String version = "Release 1.0";

    public static main instance;

    public void onEnable() {
        //Enable Message
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin: §aTeamChat");
        Bukkit.getConsoleSender().sendMessage("§7Author: §aPixelTeleV");
        Bukkit.getConsoleSender().sendMessage("§7Version: §a" + version);
        Bukkit.getConsoleSender().sendMessage("§4§lCopyright PixelTeleV 2018");
        Bukkit.getConsoleSender().sendMessage("§a§lPlugin activated!");
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");

        instance = this;

        //Register Config Methods
        fileconfig.loadMessages();
        fileconfig.initMessages();

        //Register Commands
        getCommand("teamchat").setExecutor(new teamchat());
        getCommand("tc").setExecutor(new teamchat());
    }

    public void onDisable() {
        //Disable Message
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin: §aTeamChat");
        Bukkit.getConsoleSender().sendMessage("§7Author: §aPixelTeleV");
        Bukkit.getConsoleSender().sendMessage("§7Version: §a" + version);
        Bukkit.getConsoleSender().sendMessage("§4§lCopyright PixelTeleV 2018");
        Bukkit.getConsoleSender().sendMessage("§c§lPlugin deactivated!");
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
    }

}
