package Maraton78;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_29716 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		
		int j = Integer.parseInt(tmp[0]);
		int n = Integer.parseInt(tmp[1]);
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			String str = br.readLine();
			for (int k = 0; k < str.length(); k++) {
				char a = str.charAt(k);
				if (a == ' ')
					cnt++;
				else if (a-'Z' >= -25 && a-'Z' <= 0)
					cnt += 4;
				else
					cnt += 2;
			}
			if (cnt <= j)
				res++;
		}
		
		System.out.println(res);
	}
}