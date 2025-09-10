import java.io.BufferedReader;
import java.io.InputStreamReader;

public class M_12865_평범한배낭_최규직 {
	
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
			String[] temp = in.readLine().split(" ");
			int N = Integer.parseInt(temp[0]); // 물품 수
			int K = Integer.parseInt(temp[1]); // 버틸 수 있는 무게
			
			int[] W = new int[N];
			int[] V = new int[N];
			
			for (int i = 0; i < N; i++) {
				temp = in.readLine().split(" ");
				W[i] = Integer.parseInt(temp[0]); // 물건 무게
				V[i] = Integer.parseInt(temp[1]); // 물건의 가치
			}
			
			// i 무게 내에서 얻을 수 있는 최대 가치는 dp[i]
			// 인덱스 - 제한 무게
			// 값 - 제한무게 내에서 얻을 수 있는 최대 가치
            int[] dp = new int[K + 1];

            for (int i = 0; i < N; i++) {
            	// 무한배낭문제라면 0부터 최대값까지 순회시키면 됨
                for (int j = K; j >= W[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
                }
            }

            sb.append(dp[K] + "\n");
		
		System.out.println(sb);
	}
}
