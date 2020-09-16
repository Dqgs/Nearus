package dqgs.nearus.util;

public class Ship {

    int Imposters, CrewMate;
    double playerRatio;

    EndGame endGame = new EndGame();

    public Ship(){

    }
    public void goToShip(){

    }

    public void endGame(){

    }

    public boolean isHighRatio(){
        if (getPlayerRation() >= 0.5){
            return true;
        }
        return false;
    }

    public void setPlayerRation(int Imposter, int CrewMate){
        this.CrewMate = CrewMate;
        this.Imposters = Imposter;
        double playerRatio;
        playerRatio = Imposter / CrewMate;
        this.playerRatio = playerRatio;

    }

    public double getPlayerRation(){
        return playerRatio;
    }
}
