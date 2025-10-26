package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2292 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int temp = N;
		int res = 1;
		for (int i = 1; i < N; i++) {
			if (temp <= 1)
				break;
			temp -= 6 * i;
			res++;
		}

		System.out.println(res);

	}

}
