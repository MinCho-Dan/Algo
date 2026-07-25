class Solution {
    public int solution(int[] money) {
        int len = money.length;
        int[] dp1 = new int[len];
        dp1[0] = 0;
        dp1[1] = money[0];
        for (int i = 2;i < len;i++) 
            dp1[i] = Math.max(money[i - 1] + dp1[i - 2], dp1[i - 1]);
        
        int[] dp2 = new int[len];
        dp2[0] = money[1];
        dp2[1] = Math.max(money[1], money[2]);
        for (int i = 2;i < len - 1;i++)
            dp2[i] = Math.max(money[i + 1] + dp2[i - 2], dp2[i - 1]);
        dp2[len - 1] = Math.max(dp2[len - 3], dp2[len - 2]);
        
        return Math.max(dp1[len - 1], dp2[len - 1]);
    }
}