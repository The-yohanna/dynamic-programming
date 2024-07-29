package com.johanna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountPath {

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> row1 = List.of(1, 4, 6);
        List<Integer> row2 = List.of(4, 3, 7);
        List<Integer> row3 = List.of(7, 5, 2);
        grid.add(row1);
        grid.add(row2);
        grid.add(row3);
        int paths = countPath(grid);
        System.out.println(paths);
    }

    public static int countPath(List<List<Integer>> grid) {
        return countPath(0, 0, grid, new HashMap<>());
    }

    public static int countPath(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>, Integer> memo) {
        if (r == grid.size() || c == grid.get(0).size()) {
            return 0;
        }

        if (grid.get(r).get(c) == 'X') {
            return 0;
        }

        if (r == grid.size() -1 && c == grid.get(0).size() - 1) {
            return 1;
        }

        List<Integer> pos = List.of(r,c);

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        int result = countPath(r + 1, c, grid, memo) + countPath(r, c + 1, grid, memo);
        memo.put(pos, result);
        return result;
    }
}
