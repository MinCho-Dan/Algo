package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2675 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int TC = 0; TC < T; TC++) {
			String[] tmp = in.readLine().split(" ");
			int R = Integer.parseInt(tmp[0]);
			String str = tmp[1];
			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < R; j++) {
					System.out.print(str.charAt(i));
				}
			}
			System.out.println();
		}
	}
}