/*
 * Copyright 2016 J.D. Sandifer - See "LICENSE" file for complete information.
 */

import java.io.*;
import java.util.*;

public class JdStats {

    static double calcMean(int[] numbers) {
        int sum = sumArray(numbers);
        return (double) sum / numbers.length;
    }
    
    static double calcMedian(int[] numbersToCopy) {
        int[] numbers = numbersToCopy.clone();   // non-destructive
        Arrays.sort(numbers);   // sorting copied array
        double median;
        int midIndex = (int) Math.round(numbers.length / 2) - 1;
            // first of two middle array indexes if array size is even
        if (numbers.length % 2 == 0) {
            median = (numbers[midIndex] + numbers[midIndex + 1]) / 2.0;
        } else {
            median = (double) numbers[midIndex];
        }
        return median;
    }
    
    static int calcMode(int[] numbersToCopy) {
        int[] numbers = numbersToCopy.clone();   // non-destructive
        Arrays.sort(numbers);   // sorting copied array
        
        int count = 1;
        int maxCount = 1;
        int currentMaxNum = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    currentMaxNum = numbers[i];
                }
            } else {
                count = 1;
            }
        }
        
        return currentMaxNum;
    }
    
    static double calcStdDeviation(int[] numbers, double mean) {
        double squareOfDifferences = 0.0;
        for (int num : numbers) {
            squareOfDifferences += Math.pow(num - mean, 2);
        }
        
        double stdDev = Math.pow(squareOfDifferences / numbers.length, 0.5);
            
        return stdDev;
    }
    
    static double calcMarginOfError(double stdDeviation, int sampleSize) {
        final double Z_FOR_95PERCENT_CONFIDENCE = 1.96;
        return Z_FOR_95PERCENT_CONFIDENCE * stdDeviation / Math.pow(sampleSize, 0.5);
    }
}