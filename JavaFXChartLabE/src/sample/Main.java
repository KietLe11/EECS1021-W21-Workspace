package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("The digits in my student ID");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("# of digits in my student ID");
        yAxis.setLabel("Digit Value");
        //creating the chart
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("My student ID is 218052787");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("The digits in my student ID");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 2));
        series.getData().add(new XYChart.Data(2, 1));
        series.getData().add(new XYChart.Data(3, 8));
        series.getData().add(new XYChart.Data(4, 0));
        series.getData().add(new XYChart.Data(5, 5));
        series.getData().add(new XYChart.Data(6, 2));
        series.getData().add(new XYChart.Data(7, 7));
        series.getData().add(new XYChart.Data(8, 8));
        series.getData().add(new XYChart.Data(9, 7));

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
