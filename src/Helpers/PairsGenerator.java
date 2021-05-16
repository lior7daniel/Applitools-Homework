package Helpers;

/**
 * A class that provides a static function that produces an array with the required number of pairs and with random values.
 * 
 * @author Lior Daniel.
 *
 */
public class PairsGenerator {

	/**
	 * A static function that provides an array with the required amount of pairs and with 'double' random values.
	 * @param numOfPairs number of pairs.
	 * @return Pair<Double, Double>[]
	 */
	public static Pair<Double, Double>[] getPairOfDoublesArray(int numOfPairs){
		Pair<Double, Double>[] pairs = new Pair[numOfPairs];
		for (int i = 0; i < numOfPairs; i++) {
			pairs[i] = new Pair<Double, Double>(Math.random() * 10, Math.random() * 10);
		}
		return pairs;
	}
	
}
