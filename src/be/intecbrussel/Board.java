package be.intecbrussel;

public class Board {
    public boolean mustTake;
    public boolean ready;
    public boolean activated;
    private int z;
    private int x, y;
    private boolean whiteTurn;
    private Piece[][] checkerboard;
    private int hor, ver;
    private int q, p;
    private int v, l;

    public Board() {
        hor = ver = 10;
        checkerboard = new Piece[20][20];
        checkerboard[1][0] = new White();
        checkerboard[3][0] = new White();
        checkerboard[3][0] = new White();
        checkerboard[5][0] = new White();
        checkerboard[7][0] = new White();
        checkerboard[9][0] = new White();
        checkerboard[0][1] = new White();
        checkerboard[2][1] = new White();
        checkerboard[4][1] = new White();
        checkerboard[6][1] = new White();
        checkerboard[8][1] = new White();
        checkerboard[0][3] = new White();
        checkerboard[2][3] = new White();
        checkerboard[4][3] = new White();
        checkerboard[6][3] = new White();
        checkerboard[8][3] = new White();
        checkerboard[1][2] = new White();
        checkerboard[3][2] = new White();
        checkerboard[3][2] = new White();
        checkerboard[5][2] = new White();
        checkerboard[7][2] = new White();
        checkerboard[9][2] = new White();
        checkerboard[0][9] = new Violet();
        checkerboard[2][9] = new Violet();
        checkerboard[4][9] = new Violet();
        checkerboard[6][9] = new Violet();
        checkerboard[8][9] = new Violet();
        checkerboard[1][8] = new Violet();
        checkerboard[3][8] = new Violet();
        checkerboard[5][8] = new Violet();
        checkerboard[7][8] = new Violet();
        checkerboard[9][8] = new Violet();
        checkerboard[1][6] = new Violet();
        checkerboard[3][6] = new Violet();
        checkerboard[5][6] = new Violet();
        checkerboard[7][6] = new Violet();
        checkerboard[9][6] = new Violet();
        checkerboard[0][7] = new Violet();
        checkerboard[2][7] = new Violet();
        checkerboard[4][7] = new Violet();
        checkerboard[6][7] = new Violet();
        checkerboard[8][7] = new Violet();

    }

    public int getHor() {
        return hor;
    }

    public int getVer() {
        return ver;
    }

    public Piece getContent(int x, int y) {
        return checkerboard[x][y];
    }

    public void activate(int x, int y) {
        ready = false;


        Piece st = getContent(x, y);
        if (st == null) {
        } else if (st.activable()) {
            st.activateItNow();
            activated = true;

        }

    }

    public void mustTake() {
        for (int m = 0; m < 10; m++) {
            for (int n = 0; n < 10; n++) {
                for (int j = 0; j < 10; j++) {
                    for (int i = 0; i < 10; i++) {
                        Piece st = getContent(m, n);
                        Piece po = getContent(i, j);


                        if ((!whiteTurn && n == j - 1 && po instanceof White) || (!whiteTurn && n == j + 1 && po instanceof White)) {

                            if ((m == i + 1 && st instanceof Violet) || (m == i - 1 && st instanceof Violet)) {

                                if ((i + (m - i) * 2) < 10 && (i + (m - i) * 2) > -1 && (j + (n - j) * 2) < 10 && (j + (n - j) * 2) > -1) {
                                    Piece free = getContent(i + (m - i) * 2, j + (n - j) * 2);
                                    if (free == null) {
                                        if (po != null) {
                                            po.stro();

                                            mustTake = true;
                                        }

                                    }
                                }
                            }
                        } else if ((whiteTurn && n == j - 1 && po instanceof Violet) || (whiteTurn && n == j + 1 && po instanceof Violet)) {

                            if ((m == i + 1 && st instanceof White) || (m == i - 1 && st instanceof White)) {

                                if ((i + (m - i) * 2) < 10 && (i + (m - i) * 2) > -1 && (j + (n - j) * 2) < 10 && (j + (n - j) * 2) > -1) {
                                    Piece free = getContent(i + (m - i) * 2, j + (n - j) * 2);
                                    if (free == null) {
                                        if (po != null) {

                                            po.stro();
                                            mustTake = true;
                                        }
                                    }
                                }


                            }
                        }

                    }
                }
            }
        }
    }

    public void move(int x, int y) {
        activated = false;
        if (mustTake) {

            take(x, y);

            mustTake();
            Piece st = getContent(x, y);

            if (mustTake) {
                if (st == null) {
                } else {
                    st.activateItNow();
                    ready = false;
                }
            } else {
                if (whiteTurn) {
                    whiteTurn = false;
                } else {
                    whiteTurn = true;
                }
            }

        } else {
            doTheMove(x, y);

        }
    }

    public void doTheMove(int x, int y) {
        Piece st = checkerboard[x][y];
        Piece ac = getContent(q, p);
        if (y == p + 1 && x == q + 1 || y == p + 1 && x == q - 1) {
            if (st == null && ac instanceof White || st == null && ac.isDam) {

                if (ac.isDam) {
                    ac.deactivate();
                    checkerboard[x][y] = ac;
                } else {
                    checkerboard[x][y] = new White();
                }
                checkerboard[q][p] = null;
                ready = true;
                activated = false;
                if (ac.isDam && ac instanceof Violet) {
                    whiteTurn = false;
                } else {
                    whiteTurn = true;
                }
            }
        } else if (y == p - 1 && x == q + 1 || y == p - 1 && x == q - 1) {
            if (st == null && ac instanceof Violet || st == null && ac.isDam) {

                ac.deactivate();
                checkerboard[x][y] = ac;
                checkerboard[q][p] = null;
                ready = true;
                activated = false;
                if (ac.isDam && ac instanceof White) {
                    whiteTurn = true;
                } else {
                    whiteTurn = false;
                }
            }
        }
    }

    public void scan() {
        for (int m = 0; m < 10; m++) {
            for (int n = 0; n < 10; n++) {
                Piece st = getContent(m, n);
                if (st == null) {
                } else if (st.clicked() && st instanceof White) {
                    z = 1;
                    q = m;
                    p = n;
                } else if (st.clicked() && st instanceof Violet) {
                    z = 2;
                    q = m;
                    p = n;
                } else if (mustTake) {
                    st.myTurn = false;
                }
            }
        }

    }

    public void turnChange() {
        for (int m = 0; m < 10; m++) {
            for (int n = 0; n < 10; n++) {
                Piece st = getContent(m, n);
                if (st == null) {
                } else if (whiteTurn) {

                    if (st instanceof White) {

                        st.myTurn = false;
                    } else {
                        st.myTurn = true;
                    }
                } else {
                    System.out.println("raheu");
                    if (st instanceof White) {
                        st.myTurn = true;
                    } else {
                        st.myTurn = false;
                    }

                }
            }
        }
    }

    public void take(int x, int y) {

        int u = (x + q) / 2;
        int h = (y + p) / 2;
        Piece ac = getContent(q, p);
        Piece bo = getContent((x + q) / 2, (y + p) / 2);
        Piece ga = getContent(x, y);


        if (ac instanceof White && bo instanceof Violet || bo instanceof White && ac instanceof Violet) {
            if (ga == null) {
                if (x == 2 + q && y == 2 + p || x == 2 + q && y == p - 2 || x == q - 2 && y == 2 + p || x == q - 2 && y == p - 2) {

                    checkerboard[(x - q) / 2 + q][(y - p) / 2 + p] = null;
                    checkerboard[x][y] = ac;
                    checkerboard[q][p] = null;
                    ready = true;
                    Piece st = getContent(x, y);
                    st.deactivate();
                    mustTake = false;
                }
            }
        }
    }                                       //checkitout

    public void checkItOut() {
        for (int m = 0; m < 10; m++) {
            for (int n = 0; n < 10; n++) {
                Piece st = getContent(m, n);
                if (n == 9 && st instanceof White) {
                    st.isDam = true;
                } else if (n == 0 && st instanceof Violet) {
                    st.isDam = true;
                }
            }
        }
    }

}

