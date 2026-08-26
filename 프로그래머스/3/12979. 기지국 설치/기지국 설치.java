class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 0;
        int coverage = 2 * w + 1;

        for (int station : stations) {
            int end = station - w - 1;
            int gap = end - start;
            
            // ceil(a / b) a/b의 올림을 구하기
            // => (a + b - 1) / b
            answer += (gap + coverage - 1) / coverage;
            start = station + w;
        }

        // stations[stations.length - 1]이 커버하는 범위 이후 값 계산
        int gap = n - start;
        answer += (gap + coverage - 1) / coverage;

        return answer;
    }
}