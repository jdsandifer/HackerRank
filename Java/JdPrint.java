/*
 * Copyright 2016 J.D. Sandifer - See "LICENSE" file for more info.
 */

import java.io.*;
import java.util.*;

public class JdPrint {

    static void print(double number) {
        System.out.println(String.format("%.1f", number));
    }

    static void print(int number) {
        System.out.println(number);
    }

    static void printDev(String comment) {
        System.err.println(comment);
    }

    static void printDev(int integer) {
        System.err.println(integer);
    }

}
