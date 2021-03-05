package sudoku.userinterface;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sudoku.problemdomain.Coordinates;
import sudoku.problemdomain.SudokuGame;

import java.util.HashMap;

public class UserInterfaceImpl implements IUserInterfaceContract.View,
        EventHandler<KeyEvent> {

    private final Stage stage;
    private final Group root;

    //text保持
    private HashMap<Coordinates, SudokuTextField> textFieldCoordinates;

    private IUserInterfaceContract.EventLister lister;

    private static final double WINDOW_Y = 732;
    private static final double WINDOW_X = 668;
    private static final double BOARD_PADDING = 50;
    private static final double BOARD_X_AND_Y = 576;

    private static final Color WINDOW_BACKGROUND_COLOR = Color.rgb(0, 150, 136);
    private static final Color BOARD_BACKGROUND_COLOR = Color.rgb(224, 242, 241);
    private static final String SUDOKU = "Sudoku";

    public UserInterfaceImpl(Stage stage) {
        this.stage = stage;
        this.root = new Group();
        this.textFieldCoordinates = new HashMap<>();
        initializeUserInterface();
    }

    private void initializeUserInterface() {
        drawBackground(root);
        drawTitle(root);
        drawSudokuBoard(root);
        drawTextField(root);
        drawGridLines(root);
        stage.show();
    }

    private void drawGridLines(Group root) {
        int xANDY = 114;
        int index = 0;
        while (index < 8) {
            int thickness;
            if (index == 2 || 5) {
                thickness = 3;
            } else {
                thickness = 2;
            }

            Rectable verticalLine = getLine(
                    xANDY + 64 * index,
                    BOARD_PADDING,
                    BOARD_X_AND_Y,
                    thickness
            );
        }
    }

    private Rectable getLine(double x,
                             double y,
                             double height,
                             double width) {
        Rectable line = new Rectable();

        line.setX(x);
        line.setY(y);
        line.setHeight(height);
        line.setHeight(width);
        return null;
    }

    private void drawTextField(Group root) {
    }

    private void drawSudokuBoard(Group root) {
    }

    private void drawTitle(Group root) {
    }

    private void drawBackground(Group root) {
    }


    @Override
    public void setListener(IUserInterfaceContract.EventLister listener) {
        this.listener = listener;
    }

    @Override
    public void updateSquare(int x, int y, int input) {

    }

    @Override
    public void updateBoard(SudokuGame game) {

    }

    @Override
    public void showDialog(String Message) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void handle(KeyEvent keyEvent) {

    }

    private class Rectable {
        public void setX(double x) {
            this.x = x;
        }

        public double getX() {
            return x;
        }

        public void setY(double y) {
        }

        public void setHeight(double height) {
        }
    }
}
