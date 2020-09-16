package dqgs.nearus;

import dqgs.nearus.commands.admin.SetWaitingArea;
import dqgs.nearus.events.Join;
import dqgs.nearus.events.Leave;
import dqgs.nearus.util.WaitingArea;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class NearUs extends JavaPlugin {

    private static NearUs instance;

    WaitingArea waitingArea = new WaitingArea();

    @Override
    public void onEnable() {
        events();
        commands();
        waitingArea.getWaitingArea();

        instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
    }

    public static NearUs getInstance(){
        return instance;
    }

    public void events(){
        PluginManager server = Bukkit.getServer().getPluginManager();
        server.registerEvents(new Join(), this);
        server.registerEvents(new Leave(), this);
    }

    public void commands(){
        this.getCommand("SetWaitingArea").setExecutor(new SetWaitingArea());
    }
}
