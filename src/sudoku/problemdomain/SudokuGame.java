package sudoku.problemdomain;

import java.io.Serializable;

public class SudokuGame implements Serializable{
    private final GameState gamestate;
    private final int[][] gridState;

    public static final int GRID_BOUNDARY = 9;

    public SudokuGame(GameState gamestate, int[][] gridState) {
        this.gamestate = gamestate;
        this.gridState = gridState;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public int[][] getGridState() {
        return SudokuUtilities.copyToNewArray(gamestate);
    }
}
