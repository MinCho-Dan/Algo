package Ssac;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5597 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] lst = new boolean[31];
		lst[0] = true;

		for (int i = 0; i < 28; i++) {
			int N = Integer.parseInt(br.readLine());
			lst[N] = true;
		}

		for (int i = 1; i < 31; i++) {
			if (lst[i] == false) {
				System.out.println(i);
			}
		}

	}
}