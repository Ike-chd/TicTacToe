package tictactoe;

public enum WinningCombination {
    DIAGONAL1(new Positions[]{Positions.TOPLEFT, Positions.MIDDLE, Positions.BOTTOMRIGHT}),
    DIAGONAL2(new Positions[]{Positions.TOPRIGHT, Positions.MIDDLE, Positions.BOTTOMLEFT}),
    HORIZONTAL1(new Positions[]{Positions.TOPLEFT, Positions.TOP, Positions.TOPRIGHT}),
    HORIZONTAL2(new Positions[]{Positions.LEFT, Positions.MIDDLE, Positions.RIGHT}),
    HORIZONTAL3(new Positions[]{Positions.BOTTOMLEFT, Positions.BOTTOM, Positions.BOTTOMRIGHT}),
    VERTICAL1(new Positions[]{Positions.TOPLEFT, Positions.LEFT, Positions.BOTTOMLEFT}),
    VERTICAL2(new Positions[]{Positions.TOP, Positions.MIDDLE, Positions.BOTTOM}),
    VERTICAL3(new Positions[]{Positions.TOPRIGHT, Positions.RIGHT, Positions.BOTTOMRIGHT});

    private final Positions[] pos;

    WinningCombination(Positions[] pos) {
            this.pos = pos;
    }

    public Positions[] getPos() {
        return pos;
    }
}