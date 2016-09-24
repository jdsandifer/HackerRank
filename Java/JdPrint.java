/*
 * Copyright 2016 J.D. Sandifer - See "LICENSE" file for more info.
 */

import java.io.*;
import java.util.*;

public class JdPrint {

    static void printDouble(double number) {
        System.out.println(String.format("%.1f", number));
    }

    static void printFirstDouble(double number) {
        System.out.print(String.format("%.1f", number));
    }

    static void printInt(int number) {
        System.out.println(number);
    }

    static void printDev(String comment) {
        System.err.println(comment);
    }

    static void printDev(int integer) {
        System.err.println(integer);
    }

}