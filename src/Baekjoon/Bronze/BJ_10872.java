import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10872 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 0)
			System.out.println(1);
		else {
			int res = 1;
			for (int i = 2; i < N + 1; i++) {
				res *= i;
			}
			System.out.println(res);
		}
	}
}