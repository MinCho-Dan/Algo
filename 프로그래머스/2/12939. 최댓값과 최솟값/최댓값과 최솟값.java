class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (String str : arr) {
            int n = Integer.parseInt(str);
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        answer = min + " " + max;
        return answer;
    }
}