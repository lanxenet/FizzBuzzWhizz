/*
 * Copyright (c) 2014. Inspireso and/or its affiliates.
 * Licensed under the Apache 2.0 License.
 */

package so.inspire;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author Inspireso Team
 */
public class FizzBuzzWhizzTests {

    @Test
    public void testNumberOff() {
        Random random = new Random(1);
        for (int i = 0; i < 50; i++) {
            int num1 = getRandomInt(random);
            int num2 = getRandomInt(random);
            int num3 = getRandomInt(random);
            System.out.println(
                    String.format("###test number off with:%s, %s, %s", num1, num2, num3));
            this.testNumberOff(num1, num2, num3);
        }

    }

    @Test
    public void testNumberOffZero() {
        this.testNumberOff(0, 0, 0);
    }

    @Test
    public void testNumberOff185() {
        this.testNumberOff(1, 8, 5);
    }

    @Test
    public void testNumberOffGT9() {
        this.testNumberOff(10, 10, 10);
    }

    private int getRandomInt(Random random) {
        int num = random.nextInt(10);
        while (num <= 0) {
            num = random.nextInt(10);
        }
        return num;
    }

    private void testNumberOff(int num1, int num2, int num3) {

        String[] output = FizzBuzzWhizz.newInstance().numberOff(num1, num2, num3);

        if (output.length == 1) {
            System.out.println(output[0]);
            return;
        }

        for (int i = 0; i < output.length; i++) {
            if (String.valueOf(i + 1).contains(String.valueOf(num1))) {
                Assert.assertEquals(String.format("index: %s", i), "Fizz", output[i]);
            } else if ((i + 1) % num1 == 0) {
                Assert.assertTrue(output[i].contains("Fizz"));
            } else if ((i + 1) % num2 == 0) {
                Assert.assertTrue(output[i].contains("Buzz"));
            } else if ((i + 1) % num3 == 0) {
                Assert.assertTrue(output[i].contains("Whizz"));
            }
        }

    }

}
