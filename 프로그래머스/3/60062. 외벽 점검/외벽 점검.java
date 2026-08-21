import java.util.*;

class Solution {

    int answer;
    int[] weak;
    int[] dist;

    public int solution(int n, int[] weak, int[] dist) {
        
        int wLen = weak.length;
        int dLen = dist.length;
        this.weak = new int[wLen * 2];
        this.dist = dist;
        answer = dLen + 1;
        Arrays.sort(dist);
        
        for (int i = 0; i < wLen; i++) {
            this.weak[i] = weak[i];
            this.weak[i + wLen] = weak[i] + n;
        }

        // 각 weak를 시작점으로 시도
        for (int start = 0; start < wLen; start++)
            dfs(start, start, 0, new boolean[dLen]);

        return answer == dLen + 1 ? -1 : answer;
    }

    void dfs(int start, int idx, int cnt, boolean[] used) {

        if (cnt >= answer)
            return;

        int endIdx = start + weak.length / 2;

        if (idx >= endIdx) {
            answer = cnt;
            return;
        }

        // 긴 친구부터 사용
        for (int i = dist.length - 1; i >= 0; i--) {

            if (used[i])
                continue;

            used[i] = true;

            int end = weak[idx] + dist[i];
            int next = idx;

            while (next < endIdx && weak[next] <= end)
                next++;

            dfs(start, next, cnt + 1, used);

            used[i] = false;
        }
    }
}