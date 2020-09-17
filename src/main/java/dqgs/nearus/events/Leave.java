package dqgs.nearus.events;

import dqgs.nearus.NearUs;
import dqgs.nearus.enums.GameStatus;
import dqgs.nearus.enums.PlayerRole;
import dqgs.nearus.util.managers.PlayerManager;
import dqgs.nearus.util.Status;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

    Status status = new Status();

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        NearUs.getInstance().playerManager.put(event.getPlayer().getUniqueId(), new PlayerManager(event.getPlayer(), PlayerRole.LOBBY));
        statusChange();
    }

    public void statusChange(){
        if (status.getStatus() == GameStatus.STARTING){
            status.setStatus(GameStatus.WAITING);
        }
    }
}
