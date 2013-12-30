package com.practicalunittesting;

import com.practicalunittesting.FizzBuzz;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

/**
 * Copied from: http://codereview.stackexchange.com/questions/9749/ways-to-improve-my-coding-test-fizzbuzz-solution-for-a-tdd-role
 */
public class FizzBuzzTest  {

        @Test
        public void testMultipleOfThreeAndFivePrintsFizzBuzz() {
            Assert.assertEquals("FizzBuzz", FizzBuzz.getResult(15));
        }

        @Test
        public void testMultipleOfThreeOnlyPrintsFizz() {
            assertEquals("Fizz", FizzBuzz.getResult(93));
        }

        @Test
        public void testMultipleOfFiveOnlyPrintsBuzz() {
            assertEquals("Buzz", FizzBuzz.getResult(10));
        }

        @Test
        public void testInputOfEightPrintsTheNumber() {
            assertEquals("8", FizzBuzz.getResult(8));
        }
}