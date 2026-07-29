class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = (long) n * 1_000_000_000L;
        answer = right;
        
        while (left < right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (long value : times)
                cnt += mid / value;
            
            if (cnt < n)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}