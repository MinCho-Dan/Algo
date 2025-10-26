package Maraton72;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_33515 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = in.readLine().split(" ");
		int res = Math.min(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		System.out.println(res);
	}
}