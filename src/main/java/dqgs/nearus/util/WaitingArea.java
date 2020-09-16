package dqgs.nearus.util;

import dqgs.nearus.NearUs;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WaitingArea {

    public int x, y, z;
    public String world;

    User user = new User();

    public void setWaitingArea(Player player){
        NearUs.getInstance().getConfig().set("w.world", player.getLocation().getWorld().getName());
        NearUs.getInstance().getConfig().set("w.x", player.getLocation().getX());
        NearUs.getInstance().getConfig().set("w.y", player.getLocation().getY());
        NearUs.getInstance().getConfig().set("w.z", player.getLocation().getZ());
        NearUs.getInstance().saveConfig();
    }

    public void sendToWaitingArea(Player player){
        player.teleport(new Location(Bukkit.getWorld(String.valueOf(this.world)), this.x, this.y, this.z));
        user.setWaiting();
    }

    public void getWaitingArea(){
        String world = NearUs.getInstance().getConfig().getString("w.world");
        int x = NearUs.getInstance().getConfig().getInt("w.x");
        int y = NearUs.getInstance().getConfig().getInt("w.y");
        int z = NearUs.getInstance().getConfig().getInt("w.z");
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
