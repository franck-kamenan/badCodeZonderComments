import java.awt.*;


public class View extends Canvas {
    private Board board;
    private int size = 60;

    public View(Board checkerboard) {
        board = checkerboard;

    }

    public void paint(Graphics g) {
        g.fillRect(0, 0, board.getHor() * size, board.getVer() * size);

        for (int i = 0; i < board.getHor(); i++) {
            for (int j = 0; j < board.getVer(); j++) {
                Piece x = board.getContent(i, j);
                teken(g, x, i * size, j * size);


            }
        }
    }

    protected void teken(Graphics g, Piece st, int x, int y) {
        if (st instanceof Violet) {
            Violet p = (Violet) st;
            if (!p.clicked()) {
                g.setColor(new Color(255, 255, 255));
                g.fillRect(x, y, size, size);
                g.setColor(new Color(221, 160, 221));
                g.fillOval(x, y, size, size);
            } else if (p.clicked()) {
                g.setColor(new Color(100, 150, 100));
                g.fillRect(x, y, size, size);
                g.setColor(new Color(221, 160, 221));
                g.fillOval(x, y, size, size);

            }


        } else if (st instanceof White) {
            White w = (White) st;
            if (!w.clicked()) {
                g.setColor(new Color(255, 255, 255));
                g.fillRect(x, y, size, size);
                g.setColor(new Color(231, 206, 0));
                g.fillOval(x, y, size, size);
            } else if (w.clicked()) {
                g.setColor(new Color(100, 150, 100));
                g.fillRect(x, y, size, size);
                g.setColor(new Color(231, 206, 0));
                g.fillOval(x, y, size, size);

            }
        }
        else if((x+y)%2==0){
            g.setColor(new Color(255, 255, 255));
            g.fillRect(x, y, size, size);
        }
        else{
            g.setColor(new Color(0, 0, 0));
            g.fillRect(x, y, size, size);
        }



    }
}

