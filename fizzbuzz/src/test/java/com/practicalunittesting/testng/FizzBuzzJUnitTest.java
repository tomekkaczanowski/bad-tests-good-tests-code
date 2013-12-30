package com.practicalunittesting.testng;

import com.practicalunittesting.FizzBuzz;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.testng.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzJUnitTest {

	@Test
    @Parameters(value = {"15", "30", "75"})
	public void testMultipleOfThreeAndFivePrintsFizzBuzz(int multipleOf3And5) {
		assertEquals("FizzBuzz", FizzBuzz.getResult(multipleOf3And5));
	}

	@Test
    @Parameters(value = {"9", "36", "81"})
    public void testMultipleOfThreeOnlyPrintsFizz(int multipleOf3) {
		assertEquals("Fizz", FizzBuzz.getResult(multipleOf3));
	}

	@Test
    @Parameters(value = {"10", "55", "100"})
    public void testMultipleOfFiveOnlyPrintsBuzz(int multipleOf5) {
		assertEquals("Buzz", FizzBuzz.getResult(multipleOf5));
	}

	@Test
    @Parameters(value = {"2", "16", "23", "47", "52", "56", "67", "68", "98"})
	public void testInputOfEightPrintsTheNumber(int expectedNumber) {
		assertEquals("" + expectedNumber, FizzBuzz.getResult(expectedNumber));
	}
}

