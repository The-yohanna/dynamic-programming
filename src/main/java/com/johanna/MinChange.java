package com.johanna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinChange {

    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(3);
        coins.add(3);

        int minCoins = minChange(7, coins);
        System.out.println(minCoins);
    }

    public static int minChange(int amount, List<Integer> coins) {
        return minChange(amount, coins, new HashMap<>());
    }

    public static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int minCoins = -1;

        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins, memo);
            if (subCoins != -1) {
                int numCoins = subCoins + 1;
                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }
        }

        memo.put(amount, minCoins);
        return minCoins;
    }
}
