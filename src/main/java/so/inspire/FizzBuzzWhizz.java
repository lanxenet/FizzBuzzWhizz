/*
 * Copyright (c) 2014. Inspireso and/or its affiliates.
 * Licensed under the Apache 2.0 License.
 */

package so.inspire;

/**
 * @author ENOCH
 */
public final class FizzBuzzWhizz {

    private static final String EMPTY = "";
    private static final String[] SAY_WORDS = new String[] {"Fizz", "Buzz", "Whizz"};

    private final int numberOfStudents = 100;
    private final String[] output = new String[numberOfStudents];


    public final void numberOffAndDisplay(int num1, int num2, int num3) {
        String[] result = this.numberOff(num1, num2, num3);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%s: %s",
                    String.valueOf(i + 1),
                    EMPTY.equals(result[i]) ? String.valueOf(i + 1) : result[i]);
            System.out.println();
        }
    }

    public final String[] numberOff(int num1, int num2, int num3) {
        Preconditions conditions =
                Preconditions.newInstance()
                        .checkInSingleDigits(num1)
                        .checkInSingleDigits(num2)
                        .checkInSingleDigits(num3);

        if (conditions.isNotReady()) {
            return new String[] {conditions.getMessage()};
        }

        return this.fill(0, num1)
                .fill(1, num2)
                .fill(2, num3)
                .replaceFizz(num1)
                .output;

    }

    private FizzBuzzWhizz fill(int word, int num) {
        int index = num - 1;
        while (index < numberOfStudents) {
            output[index] += SAY_WORDS[word];
            index = index + num;
        }
        return this;

    }

    private FizzBuzzWhizz replaceFizz(int num) {
        String fizz = SAY_WORDS[0];

        for (int i = 0, j = 10;
             i * j < numberOfStudents;
             i++) {
            output[i * j + num - 1] = fizz;
            output[num * j + i - 1] = fizz;
        }

        if (num == 1) {
            output[99] = fizz;
        }
        return this;
    }

    public static FizzBuzzWhizz newInstance() {
        return new FizzBuzzWhizz();
    }

    private FizzBuzzWhizz() {
        for (int i = 0; i < 100; i++) {
            this.output[i] = EMPTY;
        }
    }

    /**
     * for testing
     *
     * @param args
     */
    public static void main(String[] args) {
        FizzBuzzWhizz.newInstance().numberOffAndDisplay(3, 5, 7);
    }

    private static final class Preconditions {
        private final StringBuilder message = new StringBuilder();

        private Preconditions() {

        }

        public static Preconditions newInstance() {
            return new Preconditions();
        }

        public final Preconditions checkInSingleDigits(int num) {
            if (num < 1 || num > 9) {
                this.message.append("input number( ").append(num).append(") is not  in single digits");
            }
            return this;
        }


        public final boolean isNotReady() {
            return this.message.length() > 0;
        }

        public final String getMessage() {
            return this.message.toString();
        }
    }


}
