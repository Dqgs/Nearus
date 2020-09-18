package dqgs.nearus.events;

import dqgs.nearus.enums.PlayerRole;
import dqgs.nearus.util.managers.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Hit implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        Player whoHit = (Player) event.getDamager();
        Player whoWasHit = (Player) event.getEntity();
        PlayerManager whohit = new PlayerManager(whoHit);
        if (whohit.canKill()){
            PlayerManager whowasHit = new PlayerManager(whoWasHit);
            if (whowasHit.getRole() != PlayerRole.IMPOSTER) {
                whowasHit.setRole(PlayerRole.GHOST);
            } else {
                //Todo: make this message configuable
                whoHit.sendMessage("That is a imposter");
            }
        }
    }
}