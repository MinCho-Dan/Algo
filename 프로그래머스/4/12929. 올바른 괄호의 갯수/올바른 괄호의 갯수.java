class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        // " (inside)outside "
        // 무조건 "("로 시작하기 때문에 짝맞춰서 "(안쪽)바깥쪽" 구조를 유지해야한다.
        for (int total = 1; total <= n; total++) {
            for (int inside = 0; inside < total; inside++) {
                int outside = total - 1 - inside;

                dp[total] += dp[inside] * dp[outside];
            }
        }

        return dp[n];
    }
}