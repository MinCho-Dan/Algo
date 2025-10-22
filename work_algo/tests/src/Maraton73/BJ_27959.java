package Maraton73;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_27959 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		if (100 * N >= M)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
