package Maraton78;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_11943 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int c = Integer.parseInt(str[0]);
		int d = Integer.parseInt(str[1]);
		
		System.out.println(Math.min(a+d, b+c));
		
	}
}