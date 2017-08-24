package com.abhi.datastructure;

/**
 * Write a function for doing an in-place shuffle of an array.
 * The shuffle must be "uniform," meaning each item in the original array must have the same probability of ending up in each spot in the final array.
 * Assume that you have a function getRandom(floor, ceiling) for getting a random integer that is >= floor and <= ceiling.
 */

import java.util.Random;

import org.junit.Test;

public class Shuffle {

	private static Random rand = new Random();

	private static int getRandom(int floor, int ceiling) {
		return rand.nextInt((ceiling - floor) + 1) + floor;
	}
	/**
	 *      * @param bound the upper bound (exclusive).  Must be positive.
     * @return the next pseudorandom, uniformly distributed {@code int}
     *         value between zero (inclusive) and {@code bound} (exclusive)
     *         from this random number generator's sequence
     * @throws IllegalArgumentException if bound is not positive
	 * @return
	 */
	private static int getRandom5() {
		//nextInt(5) exclusive 5 but inclusive 0
		return rand.nextInt(5) + 1;
	}
	
	private static int getRandom7() {
		//nextInt(5) exclusive 5 but inclusive 0
		return rand.nextInt(7) + 1;
	}
	
	public static int getRand5(){
		int randNumber = getRandom7();
		if(randNumber<=5){
			return randNumber;
		}else{
			return getRand5();
		}
	}
	
	int[] input7 = {1,2,3,4,5,6,7};
	
	public static int getRand7(){
		int randNumber = getRandom5();
		if(randNumber<=7){
			return randNumber;
		}else{
			return getRand7();
		}
	}

	public static void shuffle(int[] theArray) {

		// if it's 1 or 0 items, just return
		if (theArray.length <= 1) {
			return;
		}

		// walk through from beginning to end
		for (int indexWeAreChoosingFor = 0; indexWeAreChoosingFor < theArray.length - 1; indexWeAreChoosingFor++) {

			// choose a random not-yet-placed item to place there
			// (could also be the item currently in that spot)
			// must be an item AFTER the current item, because the stuff
			// before has all already been placed
			int randomChoiceIndex = getRandom(indexWeAreChoosingFor, theArray.length - 1);

			// place our random choice in the spot by swapping
			if (randomChoiceIndex != indexWeAreChoosingFor) {
				int valueAtIndexWeChoseFor = theArray[indexWeAreChoosingFor];
				theArray[indexWeAreChoosingFor] = theArray[randomChoiceIndex];
				theArray[randomChoiceIndex] = valueAtIndexWeChoseFor;
			}
		}
	}

	@Test
	public void testgetRand7(){
		System.out.println(35%7);
		System.out.println(34%7);
		System.out.println(33%7);
		System.out.println(32%7);
		System.out.println(31%7);
		System.out.println(30%7);
		System.out.println(29%7);
		System.out.println(28%7);
	}
}
