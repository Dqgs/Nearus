package dqgs.nearus.util;

import dqgs.nearus.enums.GameStatus;

public class Status {

    GameStatus status;

    public Status(){
    }

    public void setStatus(GameStatus status){
        this.status = status;
    }

    public GameStatus getStatus(){
        return this.status;
    }
}
