package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {

    /**
     * Problem: Sales by Match
     * There is a large pile of socks that must be paired by color.
     * Given an array of integers representing the color of each sock,
     *      determine how many pairs of socks with matching colors there are.
     * @param n size of array
     * @param ar array elements
     * @return pairs
     */
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> socksToCount = new HashMap();
        IntStream.range(0, ar.length).forEach(i -> {
            if (socksToCount.containsKey(ar[i])) {
                socksToCount.put(ar[i], socksToCount.get(ar[i]) + 1);
            } else {
                socksToCount.put(ar[i], 1);
            }
        });
        return socksToCount.values().stream().filter(count -> count > 1).mapToInt(count -> count / 2).sum();
    }
}
