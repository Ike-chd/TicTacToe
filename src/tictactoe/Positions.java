package tictactoe;

public enum Positions {
    TOPLEFT(0, 0),
    TOP(0, 1),
    TOPRIGHT(0, 2),
    LEFT(1, 0),
    MIDDLE(1, 1),
    RIGHT(1, 2),
    BOTTOMLEFT(2, 0),
    BOTTOM(2, 1),
    BOTTOMRIGHT(2, 2);

    private final int x;
    private final int y;

    Positions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}