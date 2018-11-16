
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
    int mapSize = 16;
    int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    Map<Integer, String> bingoMap = new HashMap<>();

    public Button[][] buttons = new Button[X_CELLS][Y_CELLS];

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HIGHT);
        bingoMap.put(1, "Принести на пару кофе");
        bingoMap.put(2, "Поднять руку и отказаться выходить к доске");
        bingoMap.put(3, "Покачаться на слуле");
        bingoMap.put(4, "Опоздать на пару");
        bingoMap.put(5, "Несмешно пошутить");
        bingoMap.put(6, "Смешно пошутить");
        bingoMap.put(7, "Задать тупой вопрос препу");
        bingoMap.put(8, "Позалипать в телефон");
        bingoMap.put(9, "Выйти к доске");
        bingoMap.put(10, "Доебать Данилу Хайдукова");
        bingoMap.put(11, "Задать тупой вопрос соседу");
        bingoMap.put(12, "Поспорить с одногруппником");
        bingoMap.put(13, "Выйти из кабинета во время пары");
        bingoMap.put(14, "Ответить на вопрос, заданный препу");
        bingoMap.put(15, "Поспорить препом");
        bingoMap.put(16, "Сказать очевидную вещь");

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
            }

        for (int x = 0; x < X_CELLS; x++)
            for (int y = 0; y < Y_CELLS; y++) {
                Button button = buttons[x][y];
                int key = new Random().nextInt(array.length);
                button.setText(bingoMap.get(key));
                int j;
                int length = array.length;
                for (j = key; j < length; j++)
                    if (array[j] == key)
                        break;
                for (int k = j; k < length - 1; k++)
                    array[k] = array[k + 1];
                length--;
                bingoMap.remove(key);

                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        button.setStyle("-fx-background-color: firebrick; -fx-border-color: black");
                    }
                });
            }


        primaryStage.setScene(scene);
        primaryStage.setTitle("BINGO");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}