package com.practicalunittesting.testng;

import com.practicalunittesting.FizzBuzz;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class FizzBuzzTest {

	@DataProvider
	public static Integer[][] multipleOf3And5() {
		return new Integer[][]{{15}, {30}, {75}};
	}

	@Test(dataProvider = "multipleOf3And5")
	public void testMultipleOfThreeAndFivePrintsFizzBuzz(int multipleOf3And5) {
		assertEquals("FizzBuzz", FizzBuzz.getResult(multipleOf3And5));
	}

	@DataProvider
	public static Integer[][] multipleOf3() {
		return new Integer[][]{{9}, {36}, {81}};
	}

	@Test(dataProvider = "multipleOf3")
	public void testMultipleOfThreeOnlyPrintsFizz(int multipleOf3) {
		assertEquals("Fizz", FizzBuzz.getResult(multipleOf3));
	}

	@DataProvider
	private static final Object[][] multipleOf5(){
		return new Object[][] {{10}, {40}, {100}};
	}

	@Test(dataProvider = "multipleOf5")
	public void testMultipleOfFiveOnlyPrintsBuzz(int multipleOf5) {
		assertEquals("Buzz", FizzBuzz.getResult(multipleOf5));
	}

	@DataProvider
	private static final Object[][] numbers(){
		return new Object[][] {{2}, {16}, {23}, {47}, {52}, {56}, {67}, {68}, {98}};
	}

	@Test(dataProvider = "numbers")
	public void testInputOfEightPrintsTheNumber(int expectedNumber) {
		assertEquals("" + expectedNumber, FizzBuzz.getResult(expectedNumber));
	}
}

