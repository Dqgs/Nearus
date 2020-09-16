package dqgs.nearus.events;

import dqgs.nearus.NearUs;
import dqgs.nearus.enums.GameStatus;
import dqgs.nearus.util.Status;
import dqgs.nearus.util.Util;
import dqgs.nearus.util.WaitingArea;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    Status status = new Status();
    WaitingArea waitingArea = new WaitingArea();

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (player instanceof Entity) {
            waitingArea.sendToWaitingArea(player);

        }
        statusChange(player, NearUs.getInstance().getConfig().getInt("minPlayers"));
        event.setJoinMessage(Util.messages(NearUs.getInstance().getConfig().getString("joinmessage")).replace("{name}", player.getName()));
    }

    public void statusChange(Player player, int minPlayers){
        if (Util.onlinePlayers() >= minPlayers){
            status.setStatus(GameStatus.STARTING);
        }else {
            int difference = minPlayers - Util.onlinePlayers();
            player.sendMessage(Util.messages(NearUs.getInstance().getConfig().getString("reamining")).replace("{remaining}", String.valueOf(difference)));
        }
    }
}