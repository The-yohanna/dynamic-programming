package com.johanna;

import java.util.HashMap;
import java.util.List;

public class NonAdjacentSum {

    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 4, 5, 12, 7);
        System.out.println(nonAdjacentSum(nums));
    }

    public static int nonAdjacentSum(List<Integer> nums) {
        return nonAdjacentSum(nums, 0, new HashMap<>());
    }

    public static int nonAdjacentSum(List<Integer> nums, int i, HashMap<Integer, Integer> memo) {
        if (i >= nums.size()) {
            return 0;
        }

        if (memo.containsKey(i)){
            return memo.get(i);
        }

        int result = Math.max(
                nums.get(i) + nonAdjacentSum(nums, i + 2, memo),
                nonAdjacentSum(nums, i + 1, memo)
        );

        memo.put(i, result);
        return result;
    }
}
