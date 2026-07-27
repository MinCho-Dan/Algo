import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {

        if (n <= cores.length) return n;
        
        int left = 0;
        int right = n * 10000;
        int time = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long count = cores.length; // 0초일때 코어개수만큼 카운트
            for (int core : cores)
                count += mid / core;

            if (count >= n) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        int workCount = cores.length;
        for (int core : cores)
            workCount += (time - 1) / core;
        
        for (int i = 0; i < cores.length; i++) {
            if (time % cores[i] == 0) {
                workCount++;
                if (workCount == n)
                    return i + 1;
            }
        }

        return 0;
    }
}

// 처음엔 아래처럼 pq로 풀었는데 시간복잡도 통과 못함.

// class Solution {
//     public int solution(int n, int[] cores) {
//         int answer = 0;
        
//         PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
//             if (a[0] == b[0])
//                 return a[2] - b[2];
//             return a[0] - b[0];
//         });
        
//         int len = cores.length;
//         for (int i = 0;i < len;i++)
//             q.offer(new int[]{0, cores[i], i + 1}); // 가용시간, 처리시간, 코어번호
        
//         for (int i = 0;i < n;i++) {
//             int[] cur = q.poll();
//             if (i == n - 1)
//                 answer = cur[2];
//             else {
//                 cur[0] += cur[1];
//                 q.offer(cur);
//             }
//         }
        
//         return answer;
//     }
// }