import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5534 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String target = br.readLine(); // 가게명
		int targetLen = target.length(); // 가게명 길이
        int answer = 0; // 몇개의 간판이 만들어지는지?

		for (int tc = 0; tc < n; tc++) {
            String current = br.readLine(); // 낡은 간판
            int currentLen = current.length();
            boolean found = false;

            for (int start = 0; start < currentLen; start++) {
                if (current.charAt(start) == target.charAt(0)) {
                    
                    // 간격( 설정: i는 글자 사이의 실제 거리 (인덱스 차이)
                    // 시작점부터 마지막 글자가 들어갈 공간이 나올 수 있는 최대 간격까지만 탐색
                    for (int gap = 1; start + gap * (targetLen - 1) < currentLen; gap++) {
                        boolean isMatch = true;
                        
                        // 간격마다 존재하는지 확인
                        for (int k = 1; k < targetLen; k++) {
                            if (current.charAt(start + gap * k) != target.charAt(k)) {
                                isMatch = false;
                                break;
                            }
                        }

                        if (isMatch) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found) break;
            }
            if (found) answer++;
        }
        System.out.println(answer);
	}
}