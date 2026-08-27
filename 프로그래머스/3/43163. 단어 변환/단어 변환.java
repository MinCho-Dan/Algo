class Solution {
    String[] words;
    String target;
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        this.target = target;
        visited = new boolean[words.length];
        dfs(begin, 0);
        
        if (answer == Integer.MAX_VALUE)
            answer = 0;
        
        return answer;
    }
    
    public void dfs(String str, int cnt) {
        if (str.equals(target)) {
            if (answer > cnt)
                answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i])
                continue;

            if(check(str, words[i])) {
                visited[i] = true;
                dfs(words[i], cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    boolean check(String s1, String s2) {
        int cnt = 0;
        for (int i = 0;i < s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i))
                cnt++;
        }
        
        return cnt == 1;
    }
}