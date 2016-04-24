package src.me.nebhay.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Nebhay on 31/08/2015.
 */

public class Main extends JavaPlugin implements Listener {



    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        getLogger().info("Enabled");

    }

    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        command.getName().equalsIgnoreCase("staffchat");
        {

       //     if (args.length == 0) {
            //    sender.sendMessage(ChatColor.RED + "Correct usage: /staffchat <message>");
                if (args.length >  0) {

                    StringBuilder stringBuilder = new StringBuilder();
                    for (String value : args) {
                        stringBuilder.append(value).append(" ");
                    }


                    String message = stringBuilder.toString();
                    message = ChatColor.translateAlternateColorCodes('&', message);

                    String prefix = this.getConfig().getString("prefix");
                    String StaffMessage = this.getConfig().getString("StaffMessage");

                    prefix = ChatColor.translateAlternateColorCodes('&', prefix);
                    StaffMessage = ChatColor.translateAlternateColorCodes('&', StaffMessage);
                    StaffMessage = StaffMessage.replace("{message}", message);

                    StaffMessage = ChatColor.translateAlternateColorCodes('&', StaffMessage);
                    StaffMessage = StaffMessage.replace("{Sender}", sender.getName());


                    //       Bukkit.broadcast(ChatColor.RED + "" + ChatColor.BOLD + "[StaffChat]" + " " + ChatColor.GOLD + str + ChatColor.RESET + ": " + message, "staff.bc");
                    Bukkit.broadcast(prefix + StaffMessage, "Staff.chat");


                    return true;
                }
            }
            return true;
        }
    }
