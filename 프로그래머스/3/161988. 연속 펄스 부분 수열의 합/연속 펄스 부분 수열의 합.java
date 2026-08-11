class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int len = sequence.length;
        
        long[][] dp = new long[len][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        
        for (int i = 1;i < len;i++) {
            dp[i][0] = Math.max(dp[i - 1][1], 0) + sequence[i];
            dp[i][1] = Math.max(dp[i - 1][0], 0) - sequence[i];
        }
        
        for(long[] s : dp)
            answer = Math.max(answer, Math.max(s[0], s[1]));
        
        return answer;
    }
}