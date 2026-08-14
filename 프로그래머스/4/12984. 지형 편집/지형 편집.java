import java.util.*;

public class Solution {
    public long solution(int[][] land, int P, int Q) {
        long max = -1;
        long min = 1000000001;
        
        for (int[] r : land) {
            for (int c : r) {
                max = Math.max(max, c);
                min = Math.min(min, c);
            }
        }

        long left = min;
        long right = max;

        while (left < right) {
            long mid = (left + right) / 2;
            long cost1 = getCost(land, mid, P, Q);
            long cost2 = getCost(land, mid + 1, P, Q);

            if (cost1 < cost2)
                right = mid;
            else
                left = mid + 1;
        }

        return getCost(land, left, P, Q);
    }
    
    public long getCost(int[][] land, long target, int P, int Q) {
    long cost = 0;
    for (int[] r : land) {
        for (int h : r) {
            if (h < target)
                cost += (target - h) * P;
            else
                cost += (h - target) * Q;
        }
    }
    return cost;
    }
}