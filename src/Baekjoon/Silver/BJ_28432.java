import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ_28432 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        Set<String> usedWords = new HashSet<>(n);
        int targetIdx = -1;

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            if (words[i].equals("?")) {
                targetIdx = i;
            } else {
                usedWords.add(words[i]);
            }
        }

        // 2. '?'의 앞뒤 조건 문자 미리 추출 (불필요한 반복 연산 제거)
        char requiredFirst = ' ';
        char requiredLast = ' ';

        if (targetIdx > 0) {
            String prev = words[targetIdx - 1];
            requiredFirst = prev.charAt(prev.length() - 1);
        }
        if (targetIdx < n - 1) {
            String next = words[targetIdx + 1];
            requiredLast = next.charAt(0);
        }

        // 3. 후보 단어 검증
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String candidate = br.readLine();

            // 조건 1: 중복 검사 (O(1))
            if (usedWords.contains(candidate)) continue;

            // 조건 2: 앞 단어 연결성 확인
            if (requiredFirst != ' ' && candidate.charAt(0) != requiredFirst) continue;

            // 조건 3: 뒷 단어 연결성 확인
            if (requiredLast != ' ' && candidate.charAt(candidate.length() - 1) != requiredLast) continue;

            // 모든 조건을 만족하면 즉시 출력 후 종료
            System.out.println(candidate);
            return;
        }
    }
}