import java.util.*;

class Solution {
    public int[] solution(int target) {
        final int INF = 1_000_000;

        // dp[i][0] = i점을 만드는 최소한의 다트 수 (dart)
        // dp[i][1] = i점을 만드는 최소한의 다트에서 싱글 또는 불의 개수 (cnt)
        int[][] dp = new int[target + 1][2];
        for (int i = 1; i <= target; i++)
            dp[i][0] = INF;

        // scores에 61가지 모든 점수 저장
        List<int[]> scores = new ArrayList<>();
        // 싱글
        for (int i = 1; i <= 20; i++)
            scores.add(new int[]{i, 1});
        // 불
        scores.add(new int[]{50, 1});
        // 더블
        for (int i = 1; i <= 20; i++)
            scores.add(new int[]{i * 2, 0});
        // 트리플
        for (int i = 1; i <= 20; i++)
            scores.add(new int[]{i * 3, 0});

        for (int i = 1; i <= target; i++) {
            for (int[] s : scores) {
                int score = s[0];
                int singleBull = s[1];

                if (i < score) continue;

                int dart = dp[i - score][0] + 1;
                int cnt = dp[i - score][1] + singleBull;

                if (dart < dp[i][0]) {
                    dp[i][0] = dart;
                    dp[i][1] = cnt;
                } else if (dart == dp[i][0] && cnt > dp[i][1]) {
                    dp[i][1] = cnt;
                }
            }
        }

        return dp[target];
    }
}