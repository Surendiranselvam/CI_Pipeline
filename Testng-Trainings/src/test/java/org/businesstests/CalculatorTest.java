package org.businesstests;
import org.businessfn.CalculatorFn;
import org.testng.Assert;
import org.testng.annotations.*;
import org.listeners.RetryAnalyzer;

public class CalculatorTest {

public CalculatorFn calculator;

@BeforeTest(alwaysRun = true)
public void pre(){
    calculator = new CalculatorFn();

}

    @AfterTest(alwaysRun = true)
    public void post(){
        calculator =null ;
    }

    @Test(retryAnalyzer = RetryAnalyzer.class,groups = {"addition"})
    public void testSumPositive() {
     double actual = calculator.add(2, 3);
        Assert.assertEquals(actual, 10);
    }

    @Test(groups = {"addition"})
    public void testSumNegative() {
        
        double actual = calculator.add(0, -1);
        Assert.assertEquals(actual, -1);

    }

    @Test(groups = {"subtraction"})
    public void testSubPositive() {
        
        Assert.assertEquals(calculator.subtract(5, 3), 2);
    }

    @Test(groups = {"subtraction"})
    public void testSubNegative() {
        
        Assert.assertEquals(calculator.subtract(-3, 1), -4);
    }

    @Test(groups = {"multiplication"})
    public void testMultPositive() {
        
        Assert.assertEquals(calculator.multiply(2, 3), 6);
    }

    @Test(groups = {"multiplication"})
    public void testMultNegative() {
        
        Assert.assertEquals(calculator.multiply(2, -3), -6);
    }

    @Test(groups = {"division"})
    public void testDivPositive() {
        
        Assert.assertEquals(calculator.divide(6, 3), 2);
    }

    @Test(groups = {"division"})
    public void testDivByZero() {
        
        Assert.assertThrows(NumberFormatException.class, () -> calculator.divide(6, 0));
    }

    @Test(dataProvider = "valuesForPow", groups = {"exponentiation"})
    public void testPow(double a, double b, double expected) {
        
        Assert.assertEquals(calculator.pow(a, b), expected);
    }

    @DataProvider(name = "valuesForPow")
    public Object[][] valuesForPow() {
        return new Object[][] {
                {2, 3, 8},
                {3, 2, 9},
                {5, 0.5, 1},
        };
    }
}
