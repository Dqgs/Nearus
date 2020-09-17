package dqgs.nearus.util;

import dqgs.nearus.NearUs;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Start {
    Ship ship = new Ship();
    Host host = new Host();

    int MinPlayers;
    boolean StartButtonPressed;

    public int getMinPlayers() {
        return MinPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        MinPlayers = minPlayers;
    }

    public void setStartButton(Player player){
        Util.getConfig().set("s.x", player.getLocation().getX());
        Util.getConfig().set("s.y", player.getLocation().getY());
        Util.getConfig().set("s.z", player.getLocation().getZ());
        Util.getConfig().set("s.w", player.getLocation().getWorld());
    }

    public void getStartButton(Player player){
        if (host.isHost()){
            Location location = player.getLocation();
            getStartButtonLocation(location);
        }
    }

    public Location getStartButtonLocation(Location Location){
        int x, y, z;
        String world;

        x =Util.getConfig().getInt("s.x");
        y =Util.getConfig().getInt("s.y");
        z = Util.getConfig().getInt("s.z");
        world =Util.getConfig().getString("s.w");

        Location location = new Location(Bukkit.getWorld(world), x, y, z);
        return location;

    }

    public void onStartButtonPressed(){
        setStartButtonPressed(true);
        new BukkitRunnable(){
            @Override
            public void run(){
                ship.goToShip();
            }
        }.runTaskTimer(NearUs.getInstance(), 0L, 20 * 5);
    }

    public void setStartButtonPressed(boolean startButtonPressed) {
        StartButtonPressed = startButtonPressed;
    }

}
