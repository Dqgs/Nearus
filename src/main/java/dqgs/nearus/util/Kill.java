package dqgs.nearus.util;

public class Kill {

    Ship ship = new Ship();
    User user = new User();

    public Kill(){

    }

    public void onKill(){
        ship.setPlayerRation(user.getImpostersAmount(), user.getCrewMateAmount());
        ship.endGame();
        user.setGhost(true);
    }
    public boolean canKill(){
        if (user.isImposter()){
            return true;
        }
        return false;
    }
}
