package ch.pixeltv.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Coded by PixelTeleV
 * 02.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class fileconfig {

    public static String reloaded;
    public static String nopermission;
    public static String noplayer;
    public static String syntax;
    public static String message;

    public static File ConfigFile = new File("plugins/TeamChat", "config.yml");
    public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);

    public static void save() throws IOException {
        Config.save(ConfigFile);
    }

    public static void loadMessages() {
        Config.addDefault("messages.reloaded", "§8┃ §eTeamChat§8» §7 Das Plugin §eTeamChat §7wurde §aneu geladen§7!");
        Config.addDefault("messages.nopermission", "§8┃ §eTeamChat§8» §7 Du hast §ckeinen Zugriff §7auf §ediesen Befehl§7!");
        Config.addDefault("messages.noplayer", "§8┃ §eTeamChat§8» §7 Du bist §ckein §eSpieler§7!");
        Config.addDefault("messages.syntax", "§8┃ §eTeamChat§8» §7 Benutze: §a/tc <Nachricht> §7um eine §eNachricht §7zu §asenden§7!");
        Config.addDefault("messages.message", "§8┃ §eTeamChat§8» §7 §a%player% §8┃ §7%message%");

        Config.options().copyDefaults(true);
        try {
            Config.save(ConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initMessages() {
        reloaded = Config.getString("messages.reloaded");
        nopermission = Config.getString("messages.nopermission");
        noplayer = Config.getString("messages.noplayer");
        syntax = Config.getString("messages.syntax");
        message = Config.getString("messages.message");
    }

}
