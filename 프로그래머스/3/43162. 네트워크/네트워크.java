class Solution {
    int[][] computers;
    boolean[] visited;
    int n;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        this.computers = computers;
        this.n = n;
        
        for (int i = 0;i < n;i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int node) {
        visited[node] = true;
        for (int i = 0;i < n;i++) {
            if (computers[node][i] == 1 && !visited[i])
                dfs(i);
        }
    }
}