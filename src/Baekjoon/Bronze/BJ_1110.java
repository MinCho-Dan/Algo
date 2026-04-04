import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int now = input;
		int cnt = 0;
		
		while (true) {
			int tens = now / 10;
			int ones = now % 10;
			int sum = tens + ones;

			now = ones * 10 + (sum % 10);
			cnt++;

			if (now == input) break;
		}
		
		System.out.println(cnt);
    }
}