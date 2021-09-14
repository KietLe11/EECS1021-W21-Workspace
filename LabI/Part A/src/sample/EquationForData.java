package sample;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;



public class EquationForData{

    private final CoefficientsForEquations<Integer> coefficients;

    public EquationForData(CoefficientsForEquations<Integer> coefficients){
        this.coefficients = coefficients;
    }

    private int getY(int x){
        return (this.coefficients.getA() * x*x + this.coefficients.getB()*x + this.coefficients.getC()); //y=mx+b //y = ax +bx +c
    }
    public List<XYChart.Data <Number, Number>> getData(int dataPointsX){

        List<XYChart.Data <Number,Number>> data = new ArrayList<>();

        for (int i=0; i<dataPointsX; i=i+1){
            data.add(new XYChart.Data<>(i,getY(i))); //y=mx+b
        }
        return data;
    }
}
