package assign1.ui;
import assign1.GameRules;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Optional;
import java.util.StringTokenizer;

public class GameOfLifeGUI extends Application
{
    public boolean[][] board;
    final static boolean DEAD = false;
    final static boolean ALIVE = true;
    GridPane grid = new GridPane();

    public void displayBoard()
    {
        board = GameRules.stepToNextGeneration(board);

        for(int row = 0; row < board.length; row++)
        {
            for(int column = 0; column < board[0].length; column++)
            {
                String style;
                if(board[row][column] != ALIVE)
                {
                     style = "-fx-border-color:red; -fx-background-color: white;";
                }
                else
                {
                     style = "-fx-border-color:red; -fx-background-color: blue;";
                }

                getNodeFromGridPane(grid, column, row).ifPresent(node -> node.setStyle(style));
            }
        }
    }

    private Optional<Node> getNodeFromGridPane(GridPane gridPane, int column, int row)
    {
           return gridPane.getChildren()
                          .stream()
                          .filter(node -> GridPane.getColumnIndex(node) == column)
                          .filter(node -> GridPane.getRowIndex(node) == row)
                          .findFirst();
    }

    @Override
    public void start(final Stage stage)
    {
        int SIZE = promptUserForSizeOfTheGrid();
        stage.setTitle("Game of Life");
        board = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0 ; j < SIZE; j++)
            {
                Button gridButton = new Button();
                gridButton.setText("");
                gridButton.setVisible(true);
                gridButton.setId(i + "," + j );
                gridButton.setOnMousePressed(event -> setInitialPatternHandler(gridButton.getId()));
                grid.add(gridButton, j, i);
            }
        }

        stage.setTitle("Game of Life");
        StackPane layout = new StackPane();
        layout.setStyle("-fx-background-color: white;");
        layout.getChildren().addAll(grid);
        grid.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(layout, 600, 600));
        addButtons(SIZE, stage);
        stage.show();
    }

    public void addButtons(int size, Stage stage)
    {
        Button buttonStart = new Button("Start");
        buttonStart.setPrefSize(50, 5);
        buttonStart.setVisible(true);
        buttonStart.setOnMousePressed(event -> timePlay());

        Button buttonExit = new Button("Exit");
        buttonExit.setPrefSize(50, 5);
        buttonExit.setVisible(true);
        buttonExit.setOnMousePressed(event -> stage.close());

        grid.add(buttonStart, size + 5, size + 5);
        grid.add(buttonExit, size + 10, size + 5);
    }

    public int promptUserForSizeOfTheGrid()
    {
        final Stage sizePrompt = new Stage();
        sizePrompt.setTitle("Enter the value of n for nxn grid:");
        final TextField textField = new TextField();
        final Button submitButton = new Button("Submit");
        submitButton.setDefaultButton(true);
        submitButton.setOnAction(event -> sizePrompt.close());
        final VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER_RIGHT);
        layout.setStyle("-fx-background-color: azure; -fx-padding: 10;");
        layout.getChildren().addAll(textField, submitButton);
        sizePrompt.setScene(new Scene(layout, 400, 100));
        sizePrompt.showAndWait();
        int size = (Integer.parseInt(textField.getText()));
        return size;
    }

    public void setInitialPatternHandler(String id)
    {
        String point = id;
        StringTokenizer coordinates = new StringTokenizer(point, ",");
        int row = Integer.parseInt(coordinates.nextToken());
        int column = Integer.parseInt(coordinates.nextToken());
        String style;

        if(board[row][column] == ALIVE)
        {
            board[row][column] = DEAD;
            style = "-fx-border-color:white; -fx-background-color: white;";
        }
        else
        {
            board[row][column] = ALIVE;
            style = "-fx-border-color:red; -fx-background-color: blue;";
        }

        getNodeFromGridPane(grid, column, row).ifPresent(node -> node.setStyle(style));
    }

    public void timePlay()
    {
        final Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, event -> displayBoard()), new KeyFrame(Duration.millis(1000)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
