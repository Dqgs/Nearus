package dqgs.nearus.events;

import dqgs.nearus.NearUs;
import dqgs.nearus.enums.GameStatus;
import dqgs.nearus.enums.PlayerRole;
import dqgs.nearus.util.*;
import dqgs.nearus.util.managers.ArenaManager;
import dqgs.nearus.util.managers.GameManager;
import dqgs.nearus.util.managers.PlayerManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    Status status = new Status();
    GameManager gameManager = new GameManager();
    ArenaManager arenaManager = new ArenaManager();

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (player instanceof Entity) {
            arenaManager.sendToWaitingArea(player);
            NearUs.getInstance().playerManager.put(player.getUniqueId(), new PlayerManager(event.getPlayer(), PlayerRole.LOBBY));
        }
        statusChange(player, NearUs.getInstance().getConfig().getInt("minPlayers"));
        event.setJoinMessage(Util.messages(Util.getConfig().getString("joinmessage")).replace("{name}", player.getName()));
    }

    public void statusChange(Player player, int minPlayers){
        if (Util.onlinePlayers() >= minPlayers){
            status.setStatus(GameStatus.STARTING);
        }else {
            int difference = minPlayers - Util.onlinePlayers();
            player.sendMessage(Util.messages(Util.getConfig().getString("reamining")).replace("{remaining}", String.valueOf(difference)));
        }
    }
}