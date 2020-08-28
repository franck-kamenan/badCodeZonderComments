

public class White extends Piece {

    private boolean activated;
    public boolean immune;

    public void dam() {
        isDam = false;
    }

    public White() {
    }

    public White(boolean click) {
        activated = click;
    }

    public boolean clicked() {
        return activated;

    }

    public void activateItNow() {
        activated = true;
    }

    public void deactivate() {
        activated = false;
        immune = false;
    }

    public boolean activable() {
        if (immune) {
            System.out.println("hoera");
            return true;
        } else {
            if (myTurn) {
                return true;
            } else {
                return false;
            }
        }


    }

    public void stro() {
        immune = true;


    }


}
