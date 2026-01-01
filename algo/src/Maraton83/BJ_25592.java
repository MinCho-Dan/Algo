package Maraton83;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_25592 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = 1;
		while (true) {
			if (n < k) {
				if (k % 2 == 1) {
					System.out.println(k - n);
				} else {
					System.out.println(0);
				}
				break;
			}
			n  -= k;
			k++;
		}
	}
}