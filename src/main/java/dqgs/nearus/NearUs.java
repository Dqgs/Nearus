package dqgs.nearus;

import dqgs.nearus.commands.admin.SetWaitingArea;
import dqgs.nearus.enums.GameStatus;
import dqgs.nearus.events.Hit;
import dqgs.nearus.events.Join;
import dqgs.nearus.events.Leave;
import dqgs.nearus.util.managers.GameManager;
import dqgs.nearus.util.managers.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class NearUs extends JavaPlugin {

    private static NearUs instance;

    public HashMap<UUID, PlayerManager> playerManager = new HashMap<>();

    GameManager gameManager = new GameManager();
    Player player;
    PlayerManager playerManagers = new PlayerManager(player);

    @Override
    public void onEnable() {
        events();
        commands();
        Player player = playerManagers.getPlayer();
        gameManager.setGameStatus(GameStatus.WAITING, player);

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
        server.registerEvents(new Hit(), this);
    }

    public void commands(){
        this.getCommand("SetWaitingArea").setExecutor(new SetWaitingArea());
    }
}
