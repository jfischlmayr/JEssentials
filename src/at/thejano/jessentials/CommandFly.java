package at.thejano.jessentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("jessentials.fly")) {
                if(p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.sendMessage("§4Flugmodus wurde ausgeschalten!");
                    return true;
                }
                else {
                    p.setAllowFlight(true);
                    p.sendMessage("§2Flugmodus wurde eingeschalten!");
                    return true;
                }
            }
            p.sendMessage("§4Du kast keinen Zugriff auf diesen Befehl.");
        }
        return false;
    }
}
