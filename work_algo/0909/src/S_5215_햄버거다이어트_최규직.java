import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_5215_햄버거다이어트_최규직 {
	
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) { // 테케반복
			sb.append("#" + tc + " ");
			
			String[] temp = in.readLine().split(" ");
			int N = Integer.parseInt(temp[0]); // 재료 수
			int L = Integer.parseInt(temp[1]); // 제한 칼로리
			
			int[] t = new int[N];
			int[] c = new int[N];
			
			for (int i = 0; i < N; i++) {
				temp = in.readLine().split(" ");
				t[i] = Integer.parseInt(temp[0]); // 맛점수
				c[i] = Integer.parseInt(temp[1]); // 칼로리
			}
			
			// i 칼로리 내에서 얻을 수 있는 최대 점수는 dp[i]
			// 인덱스 - 제한 칼로리
			// 값 - 인덱스 칼로리 내에서 얻을 수 있는 최대 점수
            int[] dp = new int[L + 1];

            for (int i = 0; i < N; i++) {
                // 칼로리가 큰 값부터 작은 값으로 순회 -> 0-1 배낭문제니까.
            	// 무한배낭문제라면 0부터 최대값까지 순회시키면 됨
                for (int j = L; j >= c[i]; j--) {
                    // 현재 재료를 담지 않았을 때와 담았을 때 중 더 큰 값 선택
                    dp[j] = Math.max(dp[j], dp[j - c[i]] + t[i]);
                }
            }
            
            sb.append(dp[L] + "\n");
		}
		
		System.out.println(sb);
	}
}
