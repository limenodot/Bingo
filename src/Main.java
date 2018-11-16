import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int WINDOW_WIDTH = 596;
    public static final int WINDOW_HIGHT = 596;
    public static final int X_CELLS = 4;
    public static final int Y_CELLS = 4;

    public Button[][] buttons = new Button[X_CELLS][Y_CELLS];

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HIGHT);

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
