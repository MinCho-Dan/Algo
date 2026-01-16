import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2303 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxValue = 0;
		int result = 0;
		
		for (int k = 0; k < n; k++) {
			// 카드정보 입력 (5장)
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] card = new int[5];
			for (int i = 0; i < 5; i++) 
				card[i] = Integer.parseInt(st.nextToken());
			
			// 삼중 for문으로 조합 뽑기
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 4; j++) {
					for (int q = j + 1; q < 5; q++) {
						int tmp = (card[i] + card[j] + card[q]) % 10;
						if (sum < tmp)
							sum = tmp;
					}
				}
			}
			
			if (maxValue <= sum) {
				result = k + 1;
				maxValue = sum;
			}
		}
		
		System.out.println(result);
	
	}
}