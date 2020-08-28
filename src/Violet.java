

public class Violet extends Piece {
    private Timer t;

    public void dam() {
        isDam = false;
    }

    public boolean activable() {
        if (immune) {
            return true;
        } else {
            if (myTurn) {
                return true;
            } else {
                return false;
            }
        }

    }

    private boolean activated;

    public void deactivate() {
        activated = false;
        immune = false;
    }

    public Violet() {
    }

    public Violet(boolean click) {
        activated = click;
    }

    public boolean clicked() {
        return activated;

    }

    public void activateItNow() {
        activated = true;
    }

    public void stro() {
        immune = true;


    }
}
   

