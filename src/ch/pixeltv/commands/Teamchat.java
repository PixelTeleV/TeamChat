package ch.pixeltv.commands;

import ch.pixeltv.main.Main;
import ch.pixeltv.util.Fileconfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Coded by PixelTeleV
 * 01.09.18
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Teamchat implements CommandExecutor {

    public static ArrayList<Player> notification = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        //TC Command
        if (cmd.getName().equalsIgnoreCase("tc")) {
            if (p.hasPermission(Fileconfig.useperm))
            {
                int i;
                if ((sender instanceof Player)) {
                    String message;
                    if (args.length > 0) {
                        message = "";
                        for (i = 0; i < args.length; i++) {
                            message = message + " " + args[i];
                        }

                        for (Player p1 : Bukkit.getOnlinePlayers()) {
                            if (p1.hasPermission(Fileconfig.seeperm)) {
                                if(!notification.contains(p)) {
                                    String msg = Fileconfig.message;
                                    msg = msg.replace("%player%", p.getName());
                                    msg = msg.replace("%message%", message);
                                    p1.sendMessage(msg);
                                }
                            }
                        }
                    } else {
                        p.sendMessage(Fileconfig.syntax);
                        p.sendMessage("§7Es sind folgende §eTeammitglieder §aOnline§7:");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (all.hasPermission(Fileconfig.listperm)) {
                                p.sendMessage("§a- §e" + all.getName());
                            }
                        }
                    }
                } else {
                    sender.sendMessage(Fileconfig.noplayer);
                }
            } else {
                p.sendMessage(Fileconfig.nopermission);
            }
        }

        //TeamChat Command
        if (cmd.getName().equalsIgnoreCase("Teamchat")) {
            if (args.length == 0) {
                p.sendMessage("§eTeamChat Plugin §7coded by §aPixelTeleV§7! §9Version: " + Main.version);
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (p.hasPermission(Fileconfig.reloadperm)) {
                        Fileconfig.loadMessages();
                        Fileconfig.initMessages();
                        p.sendMessage(Fileconfig.reloaded);
                    } else {
                        p.sendMessage(Fileconfig.nopermission);
                    }
                } else if(args[0].equalsIgnoreCase("toggle")) {
                    if(p.hasPermission(Fileconfig.toggleperm)) {
                        if(notification.contains(p)) {
                            notification.remove(p);
                            p.sendMessage(Fileconfig.nownotify);
                        } else {
                            notification.add(p);
                            p.sendMessage(Fileconfig.nomorenotify);
                        }
                    } else {
                        p.sendMessage(Fileconfig.nopermission);
                    }
                } else {
                    p.sendMessage(Fileconfig.syntaxtc);
                }
            }
        }
        return false;
    }
}
