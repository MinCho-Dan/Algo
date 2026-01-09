import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class M_7579_앱_최규직 {
	
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
			String[] temp = in.readLine().split(" ");
			int N = Integer.parseInt(temp[0]); // 앱 개수
			int M = Integer.parseInt(temp[1]); // 확보해야하는 메모리 용량
			
			int[] memory = new int[N]; // 앱이 차지하는 메모리
			int[] cost = new int[N]; // 앱을 비활성화하는데 드는 비용
			
			temp = in.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				memory[i] = Integer.parseInt(temp[i]);
			}
			
			temp = in.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				cost[i] = Integer.parseInt(temp[i]);
			}
			
			// 최대 비용의 합 계산
			int maxCost = 0;
			for (int c : cost) {
			    maxCost += c;
			}
			
			// 보통의 배낭이라면 "d[메모리] = 최소비용"이지만, 
			// 이 문제에서는 "d[비용] = 최대 메모리"
            int[] dp = new int[maxCost + 1];
            
            for (int i = 0; i < N; i++) {
            	// 무한배낭문제라면 0부터 최대값까지 순회시키면 됨
                for (int j = maxCost; j >= cost[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
                }
            }
            
            // 결과 찾기
            int result = 0;
            for (int j = 0; j <= maxCost; j++) {
                if (dp[j] >= M) {
                    result = j;
                    break;
                }
            }

            sb.append(result + "\n");
		
		System.out.println(sb);
	}
}


