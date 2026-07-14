import java.util.*;

class Solution {
    List<Integer>[] graph;
    int[] info;
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        
        graph = new ArrayList[info.length];
        for (int i = 0;i < info.length; i++)
            graph[i] = new ArrayList<>();
        
        for (int[] e : edges)
            graph[e[0]].add(e[1]);
        
        ArrayList<Integer> next = new ArrayList<>();
        next.add(0);
        
        dfs(0, 0, next);

        return answer;
    }
    
    // next: 현재 방문 가능한 노드
    void dfs(int sheep, int wolf, List<Integer> next) {
        answer = Math.max(answer, sheep);
        
        for (int cur : new ArrayList<>(next)){
            int ns = sheep + (info[cur] == 0 ? 1 : 0);
            int nw = wolf + (info[cur] == 1 ? 1 : 0);
            
            if (nw >= ns) continue;
            
            List<Integer> list = new ArrayList<>(next);
            list.remove(Integer.valueOf(cur));
            list.addAll(graph[cur]);
            
            dfs(ns, nw, list);
        }
    }
}