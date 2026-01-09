import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1929 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] tmp = br.readLine().split(" ");
		int M = Integer.parseInt(tmp[0]);
		int N = Integer.parseInt(tmp[1]);
		
		boolean[] isNotPrime = new boolean[N + 1];

		isNotPrime[0] = true;
		isNotPrime[1] = true;

		for (int i = 2; i * i <= N; i++) {
			if (isNotPrime[i]) {
				continue;
			}
			
			for (int j = i * i; j <= N; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if (!isNotPrime[i])
				sb.append(i + "\n");
		}

		System.out.println(sb);

	}
}

