class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int p = schedules.length;
        
        // 출근 희망 시각을 출근 인정시각으로 변환
        for (int i = 0;i < p;i++) {
            schedules[i] += 10;
            if (schedules[i] % 100 >= 60) {
                schedules[i] += 40;
            }
        }
        
        boolean[] check = new boolean[p];
        
        for (int i = 0;i < p;i++) {
            for (int j = 0;j < 7;j++) {
                if (check[i])
                    break;
                int d = (j + startday) % 7;
                if (d == 0 || d == 6)
                    continue;
                if (schedules[i] < timelogs[i][j]){
                    check[i] = true;
                }
            }
        }
        
        for (int i = 0;i < p;i++) {
            if (!check[i])
                answer++;
        }
        
        return answer;
    }
}