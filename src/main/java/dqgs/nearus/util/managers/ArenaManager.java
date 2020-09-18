package dqgs.nearus.util.managers;

import dqgs.nearus.NearUs;
import dqgs.nearus.enums.GameStatus;
import dqgs.nearus.enums.PlayerRole;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ArenaManager {

    int wx,wy,wz, sx, sy, sz;
    String wworld, sworld;
    GameManager gameManager = new GameManager();

    public ArenaManager(){

    }

    public void setShipArea(Player player){
        NearUs.getInstance().getConfig().set("s.world", player.getLocation().getWorld().getName());
        NearUs.getInstance().getConfig().set("s.x", player.getLocation().getX());
        NearUs.getInstance().getConfig().set("s.y", player.getLocation().getY());
        NearUs.getInstance().getConfig().set("s.z", player.getLocation().getZ());
        NearUs.getInstance().saveConfig();
    }

    public void sendToShipArea(Player player){
        player.teleport(new Location(Bukkit.getWorld(String.valueOf(this.wworld)), this.wx, this.wy, this.wz));
        NearUs.getInstance().playerManager.put(player.getUniqueId(), new PlayerManager(player, PlayerRole.LOBBY));
        gameManager.setGameStatus(GameStatus.INGAME, player);
    }

    public Location getShipArea(){
        String world = NearUs.getInstance().getConfig().getString("s.world");
        int x = NearUs.getInstance().getConfig().getInt("s.x");
        int y = NearUs.getInstance().getConfig().getInt("s.y");
        int z = NearUs.getInstance().getConfig().getInt("s.z");
        this.sworld = world;
        this.sx = x;
        this.sy = y;
        this.sz = z;
        Location location = new Location(Bukkit.getWorld(world), x, y, z);
        return location;
    }

    public void setWaitingArea(Player player){
        NearUs.getInstance().getConfig().set("w.world", player.getLocation().getWorld().getName());
        NearUs.getInstance().getConfig().set("w.x", player.getLocation().getX());
        NearUs.getInstance().getConfig().set("w.y", player.getLocation().getY());
        NearUs.getInstance().getConfig().set("w.z", player.getLocation().getZ());
        NearUs.getInstance().saveConfig();
    }

    public void sendToWaitingArea(Player player){
        player.teleport(new Location(Bukkit.getWorld(String.valueOf(this.wworld)), this.wx, this.wy, this.wz));
        NearUs.getInstance().playerManager.put(player.getUniqueId(), new PlayerManager(player, PlayerRole.LOBBY));
        gameManager.setGameStatus(GameStatus.WAITING, player);
    }

    public Location getWaitingArea(){
        String world = NearUs.getInstance().getConfig().getString("w.world");
        int x = NearUs.getInstance().getConfig().getInt("w.x");
        int y = NearUs.getInstance().getConfig().getInt("w.y");
        int z = NearUs.getInstance().getConfig().getInt("w.z");
        this.wworld = world;
        this.wx = x;
        this.wy = y;
        this.wz = z;
        Location location = new Location(Bukkit.getWorld(world), x, y, z);
        return location;
    }
}
