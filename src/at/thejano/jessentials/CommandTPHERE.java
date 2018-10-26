package at.thejano.jessentials;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTPHERE implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("jessentials.tphere")) {
                if (args.length == 0) {
                    return false;
                }
                else if (Bukkit.getPlayer(args[0]).isOnline()){
                    Player p2 = Bukkit.getPlayer(args[0]);
                    p2.teleport(p);
                    return true;
                }
            }
            p.sendMessage("§4Du kast keinen Zugriff auf diesen Befehl.");
        }
        return false;
    }
}
