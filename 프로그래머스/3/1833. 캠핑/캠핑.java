import java.util.*;

class Solution {

    public int solution(int n, int[][] data) {
        Arrays.sort(data, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int baseY = data[i][1];

            int upper = Integer.MAX_VALUE;
            int lower = Integer.MIN_VALUE;

            int nextUpper = upper;
            int nextLower = lower;

            for (int j = i + 1; j < n; j++) {
                // x가 바뀌면 이전 x까지의 정보를 확정
                if (j > i + 1 && data[j - 1][0] != data[j][0]) {
                    upper = nextUpper;
                    lower = nextLower;
                }

                int y = data[j][1];
                
                // 같은 x 또는 같은 y면 넓이 0
                if (data[i][0] == data[j][0] || baseY == y)
                    continue;

                if (y > baseY) {
                    if (upper >= y)
                        answer++;
                    nextUpper = Math.min(nextUpper, y);
                } else {
                    if (lower <= y)
                        answer++;
                    nextLower = Math.max(nextLower, y);
                }
            }
        }

        return answer;
    }
}