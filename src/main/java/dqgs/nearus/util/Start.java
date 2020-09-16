package dqgs.nearus.util;

import dqgs.nearus.NearUs;
import org.bukkit.scheduler.BukkitRunnable;

public class Start {
    Ship ship = new Ship();

    int MinPlayers;
    boolean StartButtonPressed;

    public Start(){

    }

    public int getMinPlayers() {
        return MinPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        MinPlayers = minPlayers;
    }

    public boolean isStartButtonPressed() {
        return StartButtonPressed;
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
