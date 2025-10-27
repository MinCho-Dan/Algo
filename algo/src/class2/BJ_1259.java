package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1259 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			if (str.equals("0"))
				break;
			int len = str.length();
			if (len == 1) {
				System.out.println("yes");
				continue;
			}
			boolean chk = true;
			for (int i = 0; i < len / 2; i++) {
				if (str.charAt(i) != str.charAt(len - i - 1)) {
					System.out.println("no");
					chk = false;
					break;
				}
			}

			if (chk)
				System.out.println("yes");
		}
	}
}