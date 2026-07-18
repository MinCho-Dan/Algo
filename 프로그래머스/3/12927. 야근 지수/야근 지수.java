import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int work : works)
            pq.add(work);

        for (int i = 0;i < n;i++) {
            int work = 0;
            if (!pq.isEmpty())
                work = pq.poll() - 1;
            if (work > 0)
                pq.add(work);
        }
        
        while (!pq.isEmpty()) {
            long work = pq.poll();
            answer += work * work;
        }
        
        return answer;
    }
}