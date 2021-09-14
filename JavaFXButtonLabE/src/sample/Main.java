package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

//--module-path C:\Java\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml 

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {

        stage.setTitle("This is Kiet's Button");

        var label = new Label("Button not pressed");

        var button = new Button("Kiet's button");

        button.setOnAction((e) -> label.setText("Button pressed"));

        var tilePane = new TilePane();
        tilePane.getChildren().addAll(button, label);
        var scene = new Scene(tilePane, 300, 400);
        stage.setScene(scene);
        stage.show();
    }
}

