package com.johanna;

import java.util.HashMap;
import java.util.List;

public class MaxPathSum {

    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(
                List.of(1, 3, 12),
                List.of(5, 6, 2)
        );
        int maxPath = maxPathSum(grid);
        System.out.println(maxPath);
    }

    public static int maxPathSum(List<List<Integer>> grid) {
        return (int) maxPathSum(0, 0, grid, new HashMap<>());
    }

    public static double maxPathSum(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>, Double> memo) {
        if (r == grid.size() || c == grid.get(0).size()) {
            return Double.NEGATIVE_INFINITY;
        }

        if (r == grid.size() -1 && c == grid.get(0).size() - 1) {
            return grid.get(r).get(c);
        }

        List<Integer> pos = List.of(r,c);

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        double result = grid.get(r).get(c) + Math.max(
                maxPathSum(r + 1, c, grid, memo),
                maxPathSum(r, c + 1, grid, memo)
        );

        memo.put(pos, result);
        return result;
    }

}
