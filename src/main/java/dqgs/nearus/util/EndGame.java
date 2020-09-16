package dqgs.nearus.util;

import org.bukkit.entity.Player;

public class EndGame {

    WaitingArea waitingArea = new WaitingArea();
    User user = new User();

    public EndGame(){
    }
    public void endGame(){

    }

    public void sendToLobby(Player player){
        waitingArea.sendToWaitingArea(player);
        user.setWaiting();
    }

}
