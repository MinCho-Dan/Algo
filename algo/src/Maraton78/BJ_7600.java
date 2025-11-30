package Maraton78;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_7600 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		while (true) {
			String str = br.readLine();
			boolean[] chk = new boolean[26];
			if (str.equals("#"))
				break;
			str = str.toLowerCase();
			for (int i = 0; i < str.length(); i++) {
				char a = str.charAt(i);
				int n = (int) (a - 'a');
				if (n >= 0 && n <= 26 && chk[n] == false) {
					cnt++;
					chk[n] = true;
				}
			}
			sb.append(cnt + "\n");
			cnt = 0;
		}
		
		System.out.println(sb);
	}
}