class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] ss = new int[24 + k + 1]; // ss[i] = i시간에 반납될 서버 수

        int server = 0; // 현재 운영 중인 서버 수

        for (int i = 0; i < 24; i++) {
            // 서버 반납
            server -= ss[i]; 

            // 필요한 만큼 서버 증설
            while (players[i] >= m * (server + 1)) {
                server++;
                ss[i + k]++;
                answer++;
            }
        }

        return answer;
    }
}