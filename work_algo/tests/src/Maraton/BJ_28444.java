package Maraton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_28444 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		
		String[] tmp = in.readLine().split(" ");
		int[] num = new int[5];
		for (int i = 0; i < tmp.length; i++) {
			num[i] = Integer.parseInt(tmp[i]);
		}
		
		int res = (num[0] * num[1]) - (num[2] * num[3] * num[4]);
		
		System.out.println(res);
	}

}
