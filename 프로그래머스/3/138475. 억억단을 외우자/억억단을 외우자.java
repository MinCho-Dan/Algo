import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        
        // count[i] = i의 약수 개수
        int[] count = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i)
                count[j]++;
        }
        
        // best[i] = i ~ e 중 가장 좋은 숫자
        int[] best = new int[e + 1];
        best[e] = e;
        for (int i = e - 1; i >= 1; i--) {
            if (count[i] >= count[best[i + 1]])
                best[i] = i;
            else
                best[i] = best[i + 1];
        }
        
        // 각 시작점에 대한 답
        int len = starts.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++)
            answer[i] = best[starts[i]];
        
        return answer;
    }
}