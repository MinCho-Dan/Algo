package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2798 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		tmp = br.readLine().split(" ");
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(tmp[i]);
		}
		int res = -1;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int hap = num[i] + num[j] + num[k];
					if (hap <= M && res < hap) {
						res = hap;
					}
				}
			}
		}

		System.out.println(res);

	}

}
