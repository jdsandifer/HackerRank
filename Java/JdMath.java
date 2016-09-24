/*
 * Copyright 2016 J.D. Sandifer - See "LICENSE" file for more info.
 * 
 */

import java.io.*;
import java.util.*;

public class JdMath {

    static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.pow(num, 0.5); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int sumArray(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

}