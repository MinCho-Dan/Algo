import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == '(') {
                stack.push(1);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}