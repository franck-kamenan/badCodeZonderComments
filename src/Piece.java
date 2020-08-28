
abstract public class Piece {
    private Timer t;

    abstract public void activateItNow();

    abstract public boolean activable();

    abstract public boolean clicked();

    public boolean activated;
    public boolean isDam;
    public boolean myTurn;

    abstract public void deactivate();

    public boolean occupied() {
        return true;

    }

    abstract void stro();

    public boolean immune;
}
