package at.thejano.jessentials;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandTPALL implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("jessentials.tpall")) {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    player.teleport(p);
                }
                return true;
            }
            p.sendMessage("§4Du kast keinen Zugriff auf diesen Befehl.");
        }
        else if (commandSender instanceof ConsoleCommandSender){
            if (args.length == 0) return false;

            else if (Bukkit.getPlayer(args[0]).isOnline()) {
                Player p = Bukkit.getPlayer(args[0]);
                for (Player player: Bukkit.getServer().getOnlinePlayers()) {
                    player.teleport(p);
                }
                return true;
            }
        }
        return false;
    }
}