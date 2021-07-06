package bingo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.*;
import java.util.Map;

public class Main extends Application {

    public static final int WINDOW_WIDTH = 596;
    public static final int WINDOW_HIGHT = 596;
    public static final int X_CELLS = 4;
    public static final int Y_CELLS = 4;

    int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    Map<Integer, String> bingoMap = new HashMap<>();
    boolean[][] clicked = new boolean[X_CELLS][Y_CELLS];

    public Button[][] buttons = new Button[X_CELLS][Y_CELLS];

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HIGHT);

        fillMap((HashMap<Integer, String>) bingoMap);

        createButtons(buttons, root);

        randomizeArray(array);

        int counter = 0;

        setButtonsText(buttons, array, counter);

        primaryStage.setScene(scene);
        primaryStage.setTitle("BINGO");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public HashMap<Integer, String> fillMap(HashMap<Integer, String> bingoMap) {
        bingoMap.put(1, "");
        bingoMap.put(2, "");
        bingoMap.put(3, "");
        bingoMap.put(4, "");
        bingoMap.put(5, "");
        bingoMap.put(6, "");
        bingoMap.put(7, "");
        bingoMap.put(8, "");
        bingoMap.put(9, "");
        bingoMap.put(10, "");
        bingoMap.put(11, "");
        bingoMap.put(12, "");
        bingoMap.put(13, "");
        bingoMap.put(14, "");
        bingoMap.put(15, "");
        bingoMap.put(16, "");
        return bingoMap;
    }

    public Button[][] createButtons(Button[][] buttons, GridPane root) {
        for (int x = 0; x < X_CELLS; x++)
            for (int y = 0; y < Y_CELLS; y++) {
                Button button = new Button();
                button.setStyle("-fx-border-color: black");
                button.setMaxWidth(Double.MAX_VALUE);
                button.setMaxHeight(Double.MAX_VALUE);
                root.getColumnConstraints().add(new ColumnConstraints(152));
                root.getRowConstraints().add(new RowConstraints(152));
                root.add(button, x, y);
                buttons[x][y] = button;
                clicked[x][y] = false;
            }
        return buttons;
    }

    public static int[] randomizeArray(int[] array){
        Random random = new Random();  // Random number generator
        for (int i=0; i<array.length; i++) {
            int randomPosition = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        return array;
    }

    public void setButtonsText(Button[][] buttons, int[] array, int counter) {
        for (int x = 0; x < X_CELLS; x++)
            for (int y = 0; y < Y_CELLS; y++) {
                Button button = buttons[x][y];
                int key = array[counter];
                button.setText(bingoMap.get(key));
                counter++;

                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        button.setStyle("-fx-background-color: firebrick; -fx-border-color: black");
                        //clicked[x][y] = true;
                        //checkClicked(clicked);
                    }
                });
            }
    }

    public void checkClicked(boolean[][] clicked) {
        //rows
        for (int i = 0; i < X_CELLS; i++) {
            int counter = 0;
            for (int j = 0; j < Y_CELLS; j++) {
                if (clicked[i][j]) {
                    counter++;
                    if (counter == Y_CELLS)
                        win();
                }
            }
        }
        //columns
        for (int i = 0; i < Y_CELLS; i++) {
            int counter = 0;
            for (int j = 0; j < X_CELLS; j++) {
                if (clicked[j][i]) {
                    counter++;
                    if (counter == X_CELLS)
                        win();
                }
            }
        }
        //diag
        for (int i = 0; i < X_CELLS; i++) {
            int counter = 0;
            if (clicked[i][i])
                counter++;
            if (counter == X_CELLS)
                win();
        }
    }

    public void win() {}

    public static void main(String[] args) {
        launch(args);
    }
}
