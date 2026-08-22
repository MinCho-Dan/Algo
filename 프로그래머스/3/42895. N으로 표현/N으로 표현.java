import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new HashSet[9];

        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();

            // N, NN, NNN, ...
            int value = 0;
            for (int j = 0; j < i; j++)
                value = value * 10 + N;
            dp[i].add(value);

            // 두 그룹으로 나눠서 사칙연산
            for (int j = 1; j < i; j++) {
                int k = i - j;

                for (int a : dp[j]) {
                    for (int b : dp[k]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);

                        if (b != 0)
                            dp[i].add(a / b);
                    }
                }
            }

            // i번 사용해서 number를 만들 수 있으면 종료
            if (dp[i].contains(number))
                return i;
        }

        return -1;
    }
}