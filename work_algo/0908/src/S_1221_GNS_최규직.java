import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_1221_GNS_최규직 {
	
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		String[] Num = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		
		for (int tc = 1; tc <= T; tc++) { // 테케반복
			sb.append("#" + tc + " ");
			String[] temp = in.readLine().split(" ");
			int N = Integer.parseInt(temp[1]);
			int[] cnt = new int[10];
			
			temp = in.readLine().split(" ");
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 10; j++) {
					if (temp[i].equals(Num[j])) {
						cnt[j]++;
						break;
					}
				}
				
			}
			
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < cnt[j]; k++) {
					sb.append(Num[j] + " ");
				}
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb);
	}
	
}
