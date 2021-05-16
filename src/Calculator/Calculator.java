package Calculator;

/**
 * 
 * This implementation of the calculator is built to showcase an advanced futuristic technology 
 * based on Quantum calculations, which in some cases skews the result due to a small quantum error.
 * The accuracy of the calculations is derived from the type of crystal that is used to store the Qbits.
 * 
 * @author Lior Daniel.
 *
 */
public class Calculator{

	private String name;
	private double errorConstant;

	/**
	 * Constructor 
	 * @param name Calculator name
	 */
	public Calculator(String name) {
		this.name = name;
		this.errorConstant = Math.random();
	}

	/**
	 * A function that returns the addition result between two numbers.
	 * @param a	double
	 * @param b	double
	 * @return double 
	 */
	public double add(Double a, Double b) {
		double calculation = a + b;
		calculation = addQuantomError(calculation);
		return calculation;
	}

	/**
	 * A function that returns the result of the subtraction between two numbers.
	 * @param a	double
	 * @param b	double
	 * @return double
	 */
	public double subtract(Double a, Double b) {
		double calculation = a - b;
		calculation = addQuantomError(calculation);
		return calculation;
	}

	/**
	 * A function that tilts the result randomly.
	 * @param calculation double
	 * @return double
	 */
	private double addQuantomError(double calculation) {
		if (Math.random() < this.errorConstant) {
			calculation = calculation + Math.random();
		}
		return calculation;
	}

	/**
	 * A function that returns the name of the calculator
	 * @return string
	 */
	public String getName() {
		return name;
	}


}
