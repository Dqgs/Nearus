package dqgs.nearus.util.managers;

import dqgs.nearus.enums.PlayerRole;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerManager {

    private final UUID uuid;
    private PlayerRole role;
    private int ImpostersAmount, CrewMateAmount;

    public PlayerManager(Player player) {
        this(player, PlayerRole.LOBBY);
    }

    public PlayerManager(Player player, PlayerRole role) {
        this.uuid = player.getUniqueId();
        setRole(role);
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public PlayerRole getRole() {
        return role;
    }

    public void setRole(PlayerRole role) {
        updateGamemode();
        this.role = role;
    }

    public void updateGamemode(){
        switch (getRole()){
            case GHOST:
                getPlayer().setGameMode(GameMode.SPECTATOR);
            default:
                getPlayer().setGameMode(GameMode.SURVIVAL);
        }
    }

    public int getImpostersAmount(){
        return ImpostersAmount;
    }

    public int getCrewMateAmount() {
        return CrewMateAmount;
    }

    public void setImpostersAmount(int ImposterAmount){
        this.ImpostersAmount = ImposterAmount;
    }


    public void setCrewMateAmount(int crewMateAmount) {
        CrewMateAmount = crewMateAmount;
    }

    public boolean canKill(){
        if (getRole() == PlayerRole.IMPOSTER){
            return true;
        }
        return false;
    }

    public void wasKilled(){

    }

    public void onKill(Player player){
        setCrewMateAmount(getCrewMateAmount() - 1);

    }

}