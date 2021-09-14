package com.eecs1021.PartC;

import com.eecs1021.DataController;
import com.eecs1021.SerialPortService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.FormatStringConverter;

import java.text.DateFormat;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static TableView<XYChart.Data<Number, Number>> getTableView() {
        // TODO: Create a `TableView<XYChart.Data<Number, Number>>`.
        //  Refer to the documentation for further details.

        var table = new TableView<XYChart.Data<Number, Number>>(); //1
        var time = new TableColumn<XYChart.Data<Number,Number> , Number> ("x");//2
        time.setCellValueFactory(row -> row.getValue().XValueProperty()); //3
        var dateFormat = DateFormat.getTimeInstance();//4
        var converter = new FormatStringConverter<Number>(dateFormat); //5
        time.setCellFactory(column -> new TextFieldTableCell<> (converter)); //6
        var value = new TableColumn<XYChart.Data<Number,Number> , Number> ("y");
        value.setCellValueFactory(row -> row.getValue().YValueProperty()); //7
        table.getColumns().setAll(List.of(time, value));
        return table;

    }

    @Override
    public void start(Stage primaryStage) {
        var serialPort = SerialPortService.getSerialPort("COM8");
        var table = getTableView();
        var controller = new DataController();

        serialPort.addDataListener(controller);
        table.setItems(controller.getDataPoints());

        var vbox = new VBox(table);
        var scene = new Scene(vbox);


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}