package dqgs.nearus.util.managers;

import dqgs.nearus.enums.GameStatus;
import org.bukkit.entity.Player;

public class GameManager {

    private GameStatus gameStatus;
    ArenaManager arenaManager = new ArenaManager();

    public GameManager() {
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus, Player player) {
        statusUpdate(player);
        this.gameStatus = gameStatus;
    }

    public void statusUpdate(Player player){
        switch (getGameStatus()){
            case INGAME:
                break;
            case WAITING:
                arenaManager.sendToWaitingArea(player);
            case STARTING:
                break;
        }
    }

}
