import java.util.*;

class Solution {

    public int solution(int[] a) {
        if (a.length <= 1) return 0;

        int answer = 0;
        int len = a.length;
        int[] count = new int[len];
        int[] lastUsedIndex = new int[len];
        Arrays.fill(lastUsedIndex, -1);

        // 첫번째
        if (a[0] != a[1]) {
            count[a[0]]++;
            lastUsedIndex[a[0]] = 1;
        }

        // 중간 구간 확인
        for (int i = 1; i < len - 1; i++) {
            if (a[i] != a[i - 1] && lastUsedIndex[a[i]] != i - 1) {
                count[a[i]]++;
                lastUsedIndex[a[i]] = i - 1;
            } else if (a[i] != a[i + 1] && lastUsedIndex[a[i]] != i + 1) {
                count[a[i]]++;
                lastUsedIndex[a[i]] = i + 1;
            }
        }

        // 마지막 보기
        if (a[len - 1] != a[len - 2] && lastUsedIndex[a[len - 1]] != len - 2) {
            count[a[len - 1]]++;
            lastUsedIndex[a[len - 1]] = len - 2;
        }
        
        for (int c : count)
            answer = Math.max(answer, c * 2);

        return answer;
    }

}