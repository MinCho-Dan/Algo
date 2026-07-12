import java.util.*;

class Solution {
    List<int[]>[] graph;
    String[] path;
    int k, answer = 1;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.k = k;
        graph = new ArrayList[n + 1];
        path = new String[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        dfs(infection, 0, 0, "");
        search(0, 0, "");

        return answer;
    }

    void dfs(int now, int parent, int last, String str) {
        path[now] = str;

        for (int[] next : graph[now]) {
            if (next[0] == parent) continue;

            int type = next[1];
            dfs(next[0], now, type, type == last ? str : str + type);
        }
    }

    void search(int depth, int last, String order) {
        if (depth == k) {
            int count = 0;

            for (int i = 1; i < path.length; i++)
                if (isSub(path[i], order))
                    count++;

            answer = Math.max(answer, count);
            return;
        }

        for (int type = 1; type <= 3; type++)
            if (type != last)
                search(depth + 1, type, order + type);
    }

    boolean isSub(String path, String order) {
        int index = 0;

        for (int i = 0; i < order.length() && index < path.length(); i++)
            if (order.charAt(i) == path.charAt(index))
                index++;

        return index == path.length();
    }
}