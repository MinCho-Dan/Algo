package Ssac;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9086 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			char[] tmp = br.readLine().toCharArray();
			System.out.print(tmp[0]);
			System.out.print(tmp[(tmp.length) - 1] + "\n");
		}
	}
}