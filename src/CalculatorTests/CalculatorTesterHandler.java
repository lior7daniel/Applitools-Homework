package CalculatorTests;

import java.util.concurrent.CountDownLatch;

import Calculator.Calculator;
import Helpers.Pair;
import Helpers.PairsGenerator;

/**
 * This class is a thread that performs the test operations for each the calculator.
 * 
 * @author Lior Daniel.
 *
 */
public class CalculatorTesterHandler extends Thread {

	private final int NUM_OF_TESTS = 10; 

	private CalculatorsTester calculatorsTester;
	private Calculator calc;
	private String logHistory;
	private CountDownLatch countDownLatch;
	private int numberOfSuccesses;
	private double successRate;


	public CalculatorTesterHandler(CalculatorsTester calculatorsTester, Calculator calc, CountDownLatch latch) {
		this.calculatorsTester 	= calculatorsTester;
		this.calc 				= calc;
		this.countDownLatch 	= latch;
		this.numberOfSuccesses 	= 0;
		this.successRate 		= 0.0;
		this.logHistory 		= "Calculator " + calc.getName() + ":\n";
	}

	@Override
	public void run() {
		addTests();
		calculateSuccessRate();
		countDownLatch.countDown();
	}

	/**
	 * This function performs tests for the "add" function of the calculator.
	 */
	private void addTests() {
		Pair<Double, Double>[] pairs = PairsGenerator.getPairOfDoublesArray(NUM_OF_TESTS);
		double result, calcResult, first, second;
		boolean success;
		for(int i = 0; i < NUM_OF_TESTS; i++) {
			first = pairs[i].getFirst();
			second = pairs[i].getSecond();
			result = first + second;
			calcResult = calc.add(first , second);
			if(result == calcResult) {
				success = true;
				numberOfSuccesses++;
			}
			else success = false;
			insertOperationToLogHistory("+", first, second, calcResult, success);
		}
	}

	/**
	 * This function represents the mathematical operation as a string and adds it to the calculation history log.
	 * @param operator double
	 * @param first double
	 * @param second double
	 * @param calcResult double
	 * @param success boolean
	 */
	private void insertOperationToLogHistory(String operator, double first, double second, double calcResult, boolean success) {
		if(success) logHistory += String.valueOf(first) + " " + String.valueOf(operator) + " " + String.valueOf(second) + " = " + String.valueOf(calcResult) + "\t(correct)\n";
		else logHistory += String.valueOf(first) + " " + String.valueOf(operator) + " " + String.valueOf(second) + " = " + String.valueOf(calcResult) + "\t(error)\n";
	}

	/**
	 * This function calculates the success rate of the calculator.
	 */
	private void calculateSuccessRate() {
		successRate = numberOfSuccesses / (double)NUM_OF_TESTS;
		calculatorsTester.getCalcsNratesMap().put(calc, successRate);
	}
	
	/**
	 * Function that returns the calculation history log.
	 * @return String
	 */
	public String getLogHistory(){
		return logHistory;
	}

}
