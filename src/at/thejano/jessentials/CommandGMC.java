package at.thejano.jessentials;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandGMC implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("jessentials.creative")) {
                if (args.length == 0) {
                    p.setGameMode(GameMode.CREATIVE);
                } else {
                    Player p2 = Bukkit.getPlayer(args[0]);
                    if (p2 != null && p2.isOnline()) {
                        p2.setGameMode(GameMode.CREATIVE);
                    }
                }
                return true;
            }
            p.sendMessage("§4Du kast keinen Zugriff auf diesen Befehl.");
        }
        else if (commandSender instanceof ConsoleCommandSender){
            if (args.length == 0) {

                return false;
            }
            else {
                Player p = Bukkit.getPlayer(args[0]);
                if (p != null && p.isOnline()) {
                    p.setGameMode(GameMode.CREATIVE);
                }
            }
            return true;
        }
        return false;
    }
}
