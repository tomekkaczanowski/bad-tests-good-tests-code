package com.practicalunittesting;

/**
 * Copied from http://codereview.stackexchange.com/questions/9749/ways-to-improve-my-coding-test-fizzbuzz-solution-for-a-tdd-role
 */
public class FizzBuzz {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static String getResult(int input) {
        boolean multipleOfThree = ((input % 3) == 0);
        boolean multipleOfFive = ((input % 5) == 0);

        if (multipleOfThree && multipleOfFive) {
            return "FizzBuzz";
        }
        else if (multipleOfThree) {
            return "Fizz";
        }
        else if (multipleOfFive) {
            return "Buzz";
        }
        return String.valueOf(input);
    }

    public static String buildOutput() {
        StringBuilder output = new StringBuilder();

        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            output.append(getResult(i));

            if (i < MAX_VALUE) {
                output.append(", ");
            }
        }

        return output.toString();
    }

    public static final void main(String[] args) {
        System.out.println(buildOutput());
    }
}
