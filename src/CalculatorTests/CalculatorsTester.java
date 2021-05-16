package CalculatorTests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;

import Calculator.Calculator;

/**
 * This class represents a tester for calculators based on quantum technology.
 * This implementation makes it possible to check which calculator provides the answer with the highest success rate.
 * 
 * @author Lior Daniel.
 *
 */
public class CalculatorsTester {

	private HashMap<Calculator, Double> 		calcsNratesMap;
	private ArrayList<CalculatorTesterHandler> 	ctHandlers;
	private CountDownLatch 						countDownLatch;

	
	/**
	 * Constructor for two calculators.
	 * @param c1 calculator #1.
	 * @param c2 calculator #2.
	 */
	public CalculatorsTester(Calculator c1, Calculator c2) {
		calcsNratesMap 	= new HashMap<Calculator, Double>();
		calcsNratesMap.put(c1, null);
		calcsNratesMap.put(c2, null);
		ctHandlers 		= new ArrayList<CalculatorTesterHandler>();
		countDownLatch 	= new CountDownLatch(calcsNratesMap.size());
	}

	/**
	 * A function that allows the addition of another calculator.
	 * @param calc Calculator.
	 */
	public void addCalc(Calculator calc) {
		calcsNratesMap.put(calc, 0.0);
		countDownLatch 	= new CountDownLatch(calcsNratesMap.size());
	}

	/**
	 * This function runs the test scheme.
	 */
	public void runTest() {
		executeCalculatorsTestersThreads();
		printCalcsLogs();
		recommendedCalc();
	}

	/**
	 * This function produces a separate test thread for each calculator.
	 */
	private void executeCalculatorsTestersThreads() {
		CalculatorTesterHandler tempHandler;
		for(Calculator calc : calcsNratesMap.keySet()) {
			tempHandler = new CalculatorTesterHandler(this, calc, countDownLatch);
			tempHandler.start();
			ctHandlers.add(tempHandler);
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A function that prints the calculation history of the calculators.
	 */
	private void printCalcsLogs() {
		for(CalculatorTesterHandler ctHandler : ctHandlers) {
			System.out.println(ctHandler.getLogHistory());
		}
	}

	/**
	 * This function checks what is the calculator with the highest success rates and prints the data.
	 */
	private void recommendedCalc() {
		Entry<Calculator, Double> maxRateEntry = null;
		for (Entry<Calculator, Double> entry : calcsNratesMap.entrySet()) {
			System.out.println(entry.getKey().getName() + " Success rate: " + entry.getValue());
			if (maxRateEntry == null || maxRateEntry.getValue() < entry.getValue()) {
				maxRateEntry = entry;
			}
		}
		System.out.println(maxRateEntry.getKey().getName() + " is better!");	
	}

	/**
	 * This function returns the map containing the calculators with their success rate data.
	 * @return HashMap<Calculator, Double>
	 */
	public HashMap<Calculator, Double> getCalcsNratesMap(){
		return calcsNratesMap;
	}

}


