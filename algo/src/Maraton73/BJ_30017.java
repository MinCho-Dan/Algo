package Maraton73;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_30017 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		int res = 0;

		if (N > M)
			res = (M * 2) + 1;
		if (N <= M)
			res = (N * 2) - 1;

		System.out.println(res);
	}
}
