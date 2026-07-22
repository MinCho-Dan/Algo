class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int[] sum = new int[cookie.length];
        sum[0] = cookie[0];
        for (int i = 1;i < cookie.length;i++)
            sum[i] = cookie[i] + sum[i - 1];
        
        for (int mid = 0;mid < cookie.length - 1;mid++) {
            int left = mid;
            int right = mid + 1;
            
            while (left >= 0 && right < cookie.length) {
                int leftSum = (left == 0) ? sum[mid] : sum[mid] - sum[left - 1];
                int rightSum = sum[right] - sum[mid];
                
                if (leftSum > rightSum)
                    right++;
                else if (leftSum < rightSum)
                    left--;
                else {
                    answer = Math.max(answer, leftSum);
                    right++;
                    left--;
                }
            }
        }
        
        return answer;
    }
}