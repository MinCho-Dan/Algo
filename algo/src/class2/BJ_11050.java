package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11050 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		
		if (K > N / 2) {
			K = N - K;
		}

		long bunja = 1;
		long bunmo = 1;

		for (int i = 0; i < K; i++) {
			bunja *= N - i;
			bunmo *= (i + 1);
		}

		System.out.println(bunja / bunmo);
	}
}