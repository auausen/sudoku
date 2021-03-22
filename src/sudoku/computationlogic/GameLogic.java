package sudoku.computationlogic;

import sudoku.constants.GameState;
import sudoku.constants.Rows;
import sudoku.problemdomain.SudokuGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GameLogic {

    public static SudokuGame getNewGame() {
        return new SudokuGame(
                GameState.NEW,
                GameGenerator.getNewGameGrid()
        );
    }

    public static GameState checkForCompletion(int[][] grid) {
        if (sudokuIsInvalid(grid)) return GameState.ACTIVE;
        if (tilesAreNotFilled(grid)) return GameState.ACTIVE;
        return GameState.COMPLETE;
    }

    private static boolean sudokuIsInvalid(int[][] grid) {
        if (rowsAreInvalid(grid)) return true;
        if (columnsAreInvalid(grid)) return true;
        if (squaresAreInvalid(grid)) return true;
        else return false;
    }

    private static boolean squaresAreInvalid(int[][] grid) {
        if (rowOfSquaresIsInvalid(Rows.TOP, grid)) return true;

        if (rowOfSquaresIsInvalid(Rows.MIDDLE, grid)) return true;

        if (rowOfSquaresIsInvalid(Rows.BUTTOM, grid)) return true;

        return false;
    }

    private static boolean rowOfSquaresIsInvalid(Rows value, int[][] grid) {
        switch (value) {
            case TOP:
                if (squaresIsInvalid(0, 0, grid)) return true;
                if (squaresIsInvalid(0, 3, grid)) return true;
                if (squaresIsInvalid(0, 6, grid)) return true;
                return false;
            case MIDDLE:
                if (squaresIsInvalid(3, 0, grid)) return true;
                if (squaresIsInvalid(3, 3, grid)) return true;
                if (squaresIsInvalid(3, 6, grid)) return true;
                return false;
        }
    }

    private static boolean squaresIsInvalid(int xIndex, int yIndex, int[][] grid) {
        int yIndexEnd = yIndex + 3;
        int xIndexEnd = xIndex + 3;

        List<Integer> square = new ArrayList<>();

        while (yIndex < yIndexEnd) {
            while (xIndex < xIndexEnd) {
                square.add(
                        grid[xIndex][yIndex]
                );

                xIndex++;
            }

            xIndex -= 3;

            yIndex++;
        }
        if (collectionHasRepeats(square)) return true;
        return false;
    }

    private static boolean collectionHasRepeats(List<Integer> square) {
        for (int index = 1; index <= GRID_BOUNDARY; index++) {
            if (Collections.frequency(collection, index) > 1) return true;
        }

        return false;
    }

    private static boolean tilesAreNotFilled(int[][] grid) {
        for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
            for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
                if (grid[xIndex][yIndex] == 0) return true;
            }
        }
        return false;
    }
}