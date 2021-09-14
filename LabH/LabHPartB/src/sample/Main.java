package sample;

import sample.SerialPortService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javax.swing.*;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        var sp = SerialPortService.getSerialPort("COM8");
        var outputStream = sp.getOutputStream();

        var pane = new BorderPane();

        var slider = new Slider();
        slider.setMin(0.0);
        slider.setMax(100.0);


        var label1 = new Label();

        // TODO: Add a 'listener' to the {@code valueProperty} of the slider. The listener
        //  should write the {@code byteValue()} of the new slider value to the output stream.

        slider.valueProperty().addListener((observableValue, oldNumber, newNumber) -> {

            try{
                outputStream.write(newNumber.byteValue());
            }catch(IOException e){
                e.printStackTrace();
            }

            label1.setText(newNumber.toString());
        });

        var label = new Label();
        var button = new Button("Pump");

        button.setOnMousePressed(value -> {
            try{
                outputStream.write(255);
            }catch(IOException e){
                e.printStackTrace();
            }
        });

        button.setOnMouseReleased(value -> {
            try{
                outputStream.write(0);
            }catch(IOException e){
                e.printStackTrace();
            }
        });

        pane.setTop(button);
        pane.setBottom(label1);

        pane.setCenter(slider);
        pane.setPadding(new Insets(0, 20, 0, 20));

        var scene = new Scene(pane, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
