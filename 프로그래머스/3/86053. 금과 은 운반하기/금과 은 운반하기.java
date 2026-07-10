class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        // 최악의 경우 : (금 10억 + 은 10억) * 1kg씩 * (편도 100000시간 * 2왕복)
        long right = 400_000_000_000_000L;

        // 이분탐색
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canTransport(mid, a, b, g, s, w, t)) {
                // mid 시간 안에 운반 가능
                right = mid;
            } else {
                // mid 시간으로는 부족
                left = mid + 1;
            }
        }

        return left;
    }
    
    private boolean canTransport(
            long time,
            int rGold, // 필요한 금의 양
            int rSilver,
            int[] g,
            int[] s,
            int[] w,
            int[] t
    ) {
        long gSum = 0;
        long sSum = 0;
        long tSum = 0; // 금,은 전체 합계

        for (int i = 0; i < g.length; i++) {
            long tt = 2L * t[i]; // tt는 왕복시간

            // time 동안 광물을 건설 장소에 전달할 수 있는 횟수
            long cnt = time / tt;

            // 편도 운반이 가능하면 한 번 추가
            if (time % tt >= t[i])
                cnt++;

            // 트럭이 해당 시간 동안 운반할 수 있는 최대 무게
            long capa = cnt * w[i];

            // 도시가 보유한 광물보다 많이 운반할 수는 없음
            // t는 transportable
            long tTotal = Math.min(capa, (long) g[i] + s[i]);
            long tGold = Math.min(capa, (long) g[i]);
            long tSilver = Math.min(capa, (long) s[i]);

            gSum += tGold;
            sSum += tSilver;
            tSum += tTotal;
        }

        return gSum >= rGold
                && sSum >= rSilver
                && tSum >= (long) rGold + rSilver;
    }
}