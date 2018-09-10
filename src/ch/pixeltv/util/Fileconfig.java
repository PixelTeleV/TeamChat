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
public class Fileconfig {

    public static String reloaded;
    public static String nopermission;
    public static String noplayer;
    public static String syntax;
    public static String message;
    public static String useperm;
    public static String seeperm;
    public static String reloadperm;
    public static String listperm;
    public static String syntaxtc;
    public static String nownotify;
    public static String nomorenotify;

    public static File ConfigFile = new File("plugins/TeamChat", "config.yml");
    public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);

    public static void save() throws IOException {
        Config.save(ConfigFile);
    }

    public static void loadMessages() {
        Config.addDefault("messages.reloaded", "§8┃ §eTeamChat§8» §7Das Plugin §eTeamChat §7wurde §aneu geladen§7!");
        Config.addDefault("messages.nopermission", "§8┃ §eTeamChat§8» §7Du hast §ckeinen Zugriff §7auf §ediesen Befehl§7!");
        Config.addDefault("messages.noplayer", "§8┃ §eTeamChat§8» §7Du bist §ckein §eSpieler§7!");
        Config.addDefault("messages.syntax", "§8┃ §eTeamChat§8» §7Benutze: §a/tc <Nachricht> §7um eine §eNachricht §7zu §asenden§7!");
        Config.addDefault("messages.message", "§8┃ §eTeamChat§8» §a%player% §8┃ §7%message%");
        Config.addDefault("messages.syntaxteamchat", "§8┃ §eTeamChat§8» §cSyntax: §a/teamchat <Reload | Toggle>");
        Config.addDefault("messages.nownotify", "§8┃ §eTeamChat§8» §7Du erhältst nun §aalle §eBenachrichtigungen§7!");
        Config.addDefault("messages.nomorenotify", "§8┃ §eTeamChat§8» §7Du erhältst nun §ckeine §eBenachrichtigungen§7!");
        Config.addDefault("permissions.use", "System.TeamChat.Use");
        Config.addDefault("permissions.see", "System.TeamChat.See");
        Config.addDefault("permissions.reload", "System.TeamChat.Reload");
        Config.addDefault("permissions.list", "System.TeamChat.List");

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
        syntaxtc = Config.getString("messages.syntaxteamchat");
        nownotify = Config.getString("messages.nownotify");
        nomorenotify = Config.getString("messages.nomorenotify");
        useperm = Config.getString("permissions.use");
        seeperm = Config.getString("permission.see");
        reloadperm = Config.getString("permissions.reload");
        listperm = Config.getString("permissions.list");
    }

}
