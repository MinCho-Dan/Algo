import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_8958 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int TC = 0; TC < T; TC++) {
			String str = in.readLine();
			int cnt = 1;
			int score = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'O') {
					score += cnt;
					cnt++;
				} else
					cnt = 1;
			}
			System.out.println(score);
		}
	}
}