package sample;

public class CoefficientsForEquations<Number> {

    private final Number a, b, c;

    CoefficientsForEquations(Number a, Number b, Number c){

        this.a=a;
        this.b=b;
        this.c=c;
    }

    public Number getA(){
        return this.a;
    }

    public Number getB(){
        return this.b;
    }
    public Number getC(){
        return this.c;
    }

    @Override
    public String toString(){
        return String.format("Equation for a line: y = %s * x^2 + %s * x + %s", this.a,this.b,this.c);

    }


}
