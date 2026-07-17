class Solution {

    int[][] matrix;
    int[][] dp;

    public int solution(int[][] matrix_sizes) {
        matrix = matrix_sizes;
        dp = new int[matrix.length + 1][matrix.length + 1];
        return solve(0, matrix.length);
    }

    // [start, end) 구간의 최소 곱셈 비용
    private int solve(int start, int end) {
        if (end - start == 1)
            return 0;

        if (dp[start][end] != 0)
            return dp[start][end];

        int min = Integer.MAX_VALUE;

        for (int split = start + 1; split < end; split++) {
            int cost = solve(start, split)
                     + solve(split, end)
                     + matrix[start][0] * matrix[split][0] * matrix[end - 1][1];

            min = Math.min(min, cost);
        }

        return dp[start][end] = min;
    }
}