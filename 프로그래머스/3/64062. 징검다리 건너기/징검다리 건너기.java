class Solution {
    public int solution(int[] stones, int k) {

        int left = 0;
        int right = 200000000;
        while (left < right) {
            int mid = (right + left) / 2;
            boolean res = check(stones, k, mid);
            if (res)
                left = mid + 1;
            else
                right = mid;
        }
        
        return left;
    }
    
    public boolean check(int[] stones, int k, int mid) {
        int cnt = 0;
        for(int i = 0;i < stones.length;i++){
            if (stones[i] - mid <= 0)
                cnt++;
            else
                cnt = 0;
            
            if (cnt == k)
                return false;
        }
        return true;
    }
}