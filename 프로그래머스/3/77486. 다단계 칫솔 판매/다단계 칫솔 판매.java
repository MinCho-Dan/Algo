import java.util.*;

class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put(enroll[i], i);

        for (int i = 0; i < seller.length; i++) {
            int idx = map.get(seller[i]);
            int money = amount[i] * 100;

            while (money > 0) {
                int parent = money / 10;
                answer[idx] += money - parent;

                if (referral[idx].equals("-") || parent == 0)
                    break;

                idx = map.get(referral[idx]);
                money = parent;
            }
        }

        return answer;
    }
}