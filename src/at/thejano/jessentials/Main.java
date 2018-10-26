package at.thejano.jessentials;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gmc").setExecutor(new CommandGMC());
        getCommand("gms").setExecutor(new CommandGMS());
        getCommand("tpall").setExecutor(new CommandTPALL());
        getCommand("tphere").setExecutor(new CommandTPHERE());
        getCommand("fly").setExecutor(new CommandFly());
    }

    @Override
    public void onDisable() {

    }
}