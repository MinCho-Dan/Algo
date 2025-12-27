package Maraton82;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1681 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		char l = tmp[1].charAt(0);
		int num = 1;
		boolean chk = false;
		int cnt = 0;
		
		while (true) {
			if (cnt == n) {
				System.out.println(--num);
				return;
			}
			String str = String.valueOf(num);
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == l) {
					chk = true;
				}
			}
			if (chk) {
				num++;
				chk = false;
				continue;
			} else {
				num++;
				cnt++;
			}
		}

	}

}
