package dqgs.nearus.events;

import dqgs.nearus.enums.GameStatus;
import dqgs.nearus.util.Status;
import dqgs.nearus.util.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

    Status status = new Status();
    User user = new User();

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        statusChange();
    }

    public void statusChange(){
        if (status.getStatus() == GameStatus.STARTING){
            status.setStatus(GameStatus.WAITING);
        }
    }
}
