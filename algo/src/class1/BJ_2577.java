package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2577 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		int c = Integer.parseInt(in.readLine());

		int abc = a * b * c;
		String num = abc + "";
		int[] res = new int[10];

		for (int i = 0; i < num.length(); i++) {
			res[num.charAt(i) - '0'] += 1;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(res[i]);
		}
	}

}