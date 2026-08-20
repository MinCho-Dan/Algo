import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        Stack<Integer> deleted = new Stack<>();

        for (String command : cmd) {
            char type = command.charAt(0);

            if (type == 'U') {
                int cnt = Integer.parseInt(command.substring(2));
                while (cnt-- > 0)
                    k = prev[k];

            } else if (type == 'D') {
                int cnt = Integer.parseInt(command.substring(2));
                while (cnt-- > 0)
                    k = next[k];

            } else if (type == 'C') {
                deleted.push(k);
                int p = prev[k];
                int ne = next[k];

                if (p != -1)
                    next[p] = ne;

                if (ne != -1) {
                    prev[ne] = p;
                    k = ne;
                } else { // k가 마지막행인경우
                    k = p;
                }

            } else if (type == 'Z') {
                int restored = deleted.pop();
                int p = prev[restored];
                int ne = next[restored];

                if (p != -1)
                    next[p] = restored;
                
                if (ne != -1)
                    prev[ne] = restored;
            }
        }

        StringBuilder answer = new StringBuilder();
        boolean[] isDeleted = new boolean[n];

        while (!deleted.isEmpty())
            isDeleted[deleted.pop()] = true;

        for (int i = 0; i < n; i++)
            answer.append(isDeleted[i] ? 'X' : 'O');

        return answer.toString();
    }
}