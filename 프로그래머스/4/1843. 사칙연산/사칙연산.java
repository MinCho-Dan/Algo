import java.util.*;

class Solution {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2;
        int[][] max = new int[n][n];
        int[][] min = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
            max[i][i] = min[i][i] = Integer.parseInt(arr[i * 2]);
        }

        // l: left
        // r: right
        // k: mid
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;

                for (int k = l; k < r; k++) {
                    if (arr[k * 2 + 1].equals("+")) {
                        max[l][r] = Math.max(max[l][r], max[l][k] + max[k + 1][r]);
                        min[l][r] = Math.min(min[l][r], min[l][k] + min[k + 1][r]);
                    } else {
                        max[l][r] = Math.max(max[l][r], max[l][k] - min[k + 1][r]);
                        min[l][r] = Math.min(min[l][r], min[l][k] - max[k + 1][r]);
                    }
                }
            }
        }

        return max[0][n - 1];
    }
}