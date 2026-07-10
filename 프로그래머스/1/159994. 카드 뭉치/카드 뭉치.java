import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> q1 = new ArrayDeque<>();
        ArrayDeque<String> q2 = new ArrayDeque<>();
        
        for(String str : cards1)
            q1.offerLast(str);
        for(String str : cards2)
            q2.offerLast(str);
        
        for (String str : goal) {
            if (str.equals(q1.peekFirst())){
                q1.removeFirst();
                continue;
            } else if (str.equals(q2.peekFirst())){
                q2.removeFirst();
                continue;
            } else
                return "No";
        }
        
        return "Yes";
    }
}