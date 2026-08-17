import java.util.*;

class Solution {
    
    class Food {
        int time;
        int idx;
        
        Food(int t, int i) {
            this.time = t;
            this.idx = i;
        }
    }
    
    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        Food[] foods = new Food[n];
        
        for (int i = 0; i < n; i++) 
            foods[i] = new Food(food_times[i], i + 1);

        Arrays.sort(foods, (a, b) -> a.time - b.time);
        
        long prev = 0;
        int count = n;
        
        for (int i = 0; i < n; i++) {
            long spend = (long)(foods[i].time - prev) * count;
            
            if (k >= spend) {
                k -= spend;
                prev = foods[i].time;
                count--;
            } else break;
        }
        
        if (count == 0) return -1;
        
        Arrays.sort(foods, (a, b) -> a.idx - b.idx);

        int target = (int) (k % count);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (foods[i].time <= prev)
                continue;
            if (cnt == target)
                return foods[i].idx;
            cnt++;
        }

        return -1;
    }
}