import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2501 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		int cnt = 0;
		int res = 0;

		for (int i = 1; i < N + 1; i++) {
			if (N % i == 0) {
				cnt++;
				if (cnt == K)
					res = i;
			}
		}

		System.out.println(res);
	}
}
