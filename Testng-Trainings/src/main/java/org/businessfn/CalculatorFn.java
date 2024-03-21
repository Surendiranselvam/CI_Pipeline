package org.businessfn;
import com.epam.tat.module4.Calculator;



public class CalculatorFn {

    private Calculator calculator ;
    public CalculatorFn(){
        calculator = new Calculator() ;
    }
    public double add(double a, double b) {
        return calculator.sum(a, b);

    }

    public double subtract(double a, double b) {
        return calculator.sub(a, b);
    }

    public double multiply(double a, double b) {
        return calculator.mult(a,b);
    }

    public double divide(double a, double b) {
    if(a == 0 || b==0 ){
        throw new NumberFormatException("cannot be divided by zero");
    }
        return calculator.div(a,b);
    }

    public double pow(double a, double b) {
        return calculator.pow(a, b);
    }


}
