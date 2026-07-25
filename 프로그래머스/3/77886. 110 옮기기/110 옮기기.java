class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0;i < s.length;i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (char c : s[i].toCharArray()) {
                sb.append(c);
                int len = sb.length();
                if (len >= 3 &&
                    sb.charAt(len - 3) == '1' &&
                    sb.charAt(len - 2) == '1' &&
                    sb.charAt(len - 1) == '0') {
                    sb.setLength(len - 3);
                    cnt++;
                }
            }
            
            int idx = sb.lastIndexOf("0");
            sb.insert(idx + 1, "110".repeat(cnt));
            
            answer[i] = sb.toString();
        }
        return answer;
    }
}