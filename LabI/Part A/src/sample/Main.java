package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {

    private static final int NUM_DATA = 100;
    private static final int MAX_X = 50; //x-axis max value
    private static final int MAX_Y = 60; //y-axis max value

    public static void main(String[] args) {
        launch(args);
    }

    static CoefficientsForEquations<Integer> readCoefficients(InputStream inputStream){
        try( var scanner = new Scanner(inputStream)){
            System.out.println("Value of A: ");
            var a = scanner.nextInt();

            System.out.println("Value of B: ");
            var b = scanner.nextInt();

            System.out.println("Value of C: ");
            var c = scanner.nextInt();

            return new CoefficientsForEquations<>(a,b,c);
        }




    }

    @Override
    public void start(Stage primaryStage) {

        var coefficients = readCoefficients(System.in);

        var equation = new EquationForData(coefficients);
        var equationData = equation.getData(NUM_DATA);

        List <LineChart.Data <Number, Number>> data;
//        data = List.of( new LineChart.Data<> (10,15),
//                        new LineChart.Data<> (15,20),
//                        new LineChart.Data<> (20,30),
//                        new LineChart.Data<> (25,2));

        var xAxis = new NumberAxis("x", 0 , MAX_X, 10);
        var yAxis = new NumberAxis("y", 0, MAX_Y,10); // create x and y axis

        var series = new XYChart.Series<>(FXCollections.observableList(equationData)); //series in data
        var lineChart = new LineChart<>(xAxis, yAxis, FXCollections.singletonObservableList(series)); // creates the chart
        lineChart.setTitle("My Line Chart");
        primaryStage.setTitle("My chart");

        Scene scene = new Scene(lineChart, 800, 600); //creates the JavaFX window

        primaryStage.setScene(scene);
        primaryStage.show();



    }



}
