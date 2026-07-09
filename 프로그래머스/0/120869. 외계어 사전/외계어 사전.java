class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        int n = dic.length;
        int sn = spell.length;
        for (int i = 0;i < n;i++) {
            if (dic[i].length() == sn) {
                for (int j = 0;j < sn;j++) {
                    if (dic[i].contains(spell[j])) {
                        if (j == sn - 1){
                            answer = 1;
                            return answer;
                        }
                        continue;
                    } else {
                        answer = 2;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}