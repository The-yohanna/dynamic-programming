package com.johanna;

import java.util.HashMap;

public class SummingSquares {

    public static void main(String[] args) {
        System.out.println(summingSquares(10));
    }

    public static int summingSquares(int n) {
        return (int) summingSquares(n, new HashMap<>());
    }

    public static double summingSquares(int n, HashMap<Integer, Double> memo) {
        if (n == 0) {
            return 0;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        double minSquares = Double.POSITIVE_INFINITY;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int square = i * i;
            double numSquares = 1 + summingSquares(n - square, memo);
            if (numSquares < minSquares) {
                minSquares = numSquares;
            }
        }

        memo.put(n, minSquares);
        return minSquares;
    }
}
