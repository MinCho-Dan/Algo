class Solution {
    static int answer;

    public int solution(int n) {
        answer = 0;
        dfs(n, 0);
        return answer;
    }

    // cnt를 통해 '+'와 '*'를 컨트롤
    // (n -> 3)을 찾는 역방향으로 dfs
    public static void dfs(int n, int cnt) {
        // 첫문자는 무조건 *이므로 3이 최종 목표 || 3^*보다 n이 작다면 불가능
        if(n < 3 || n < Math.pow(3, cnt / 2))
            return;
        
        if(n == 3 && cnt == 2) { // n -> 3까지 도달
            answer++;
            return;
        }
        
        if (n > 3) {
            if(n % 3 == 0 && cnt >= 2) // *로 판별
                dfs(n / 3, cnt - 2);
            dfs(n - 1, cnt + 1); // +로 판별
        }
    }
}