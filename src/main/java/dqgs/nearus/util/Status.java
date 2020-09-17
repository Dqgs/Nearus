package dqgs.nearus.util;

import dqgs.nearus.enums.GameStatus;

public class Status {

    GameStatus status;

    public Status(){

    }
    public Status(GameStatus gameStatus){
        status = gameStatus;
    }

    public void setStatus(GameStatus status){
        this.status = status;
    }

    public GameStatus getStatus(){
        return this.status;
    }
}
