import Calculator.Calculator;
import CalculatorTests.CalculatorsTester;

public class RunExample {

	public static void main(String[] args) {
		
		Calculator c0 = new Calculator("Crystal 1");
		Calculator c1 = new Calculator("Crystal 2");

		CalculatorsTester ct = new CalculatorsTester(c0, c1);
		ct.runTest();
		
	}		

}

