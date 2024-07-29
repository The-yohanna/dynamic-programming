package com.johanna;

import java.util.HashMap;
import java.util.List;

public class CountingChange {

    public static void main(String[] args) {
        List<Integer> coins = List.of(1, 2, 3);
        int amount = 4;
        System.out.println(countingChange(amount, coins));
    }

    public static int countingChange(int amount, List<Integer> coins) {
        return countingChange(amount, 0, coins, new HashMap<>());
    }

    public static int countingChange(
            int amount,
            int countIndex,
            List<Integer> coins,
            HashMap<List<Integer>, Integer> memo
    ) {
        if (amount == 0) {
            return 1;
        }

        if (countIndex >= coins.size()) {
            return 0;
        }

        List<Integer> key = List.of(amount, countIndex);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int totalWays = 0;
        int value = coins.get(countIndex);
        for (int qty = 0; qty * value <= amount; qty++) {
            int subAmount = amount - (qty * value);
            totalWays += countingChange(subAmount, countIndex + 1, coins, memo);
        }

        memo.put(key, totalWays);
        return totalWays;
    }
}
