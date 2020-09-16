package dqgs.nearus.util;

public class User {

    boolean Imposter, CrewMate, Ghost, Waiting;
    int ImpostersAmount, CrewMateAmount;

    public User(){
    }

    public boolean isCrewMate() {
        return CrewMate;
    }

    public boolean isImposter() {
        return Imposter;
    }

    public boolean isGhost(){
        return Ghost;
    }

    public void setImposter(boolean imposter) {
        Imposter = imposter;
        setImpostersAmount(getImpostersAmount() + 1);
    }
    public void setGhost(boolean ghost){
        Ghost = ghost;
    }

    public void setCrewMate(boolean crewMate) {
        CrewMate = crewMate;
        setCrewMateAmount(getCrewMateAmount() + 1);
    }

    public int getImpostersAmount(){
        return ImpostersAmount;
    }

    public void setImpostersAmount(int ImposterAmount){
        this.ImpostersAmount = ImposterAmount;
    }

    public int getCrewMateAmount() {
        return CrewMateAmount;
    }

    public void setCrewMateAmount(int crewMateAmount) {
        CrewMateAmount = crewMateAmount;
    }

    public void setWaiting(){
        this.Imposter = false;
        this.CrewMate = false;
        this.Ghost = false;
        this.Waiting = true;
    }
}
