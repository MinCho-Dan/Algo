package Maraton75;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_15740 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] AB = br.readLine().split(" ");
		BigInteger A = new BigInteger(AB[0]);
		BigInteger B = new BigInteger(AB[1]);
		
		BigInteger res = A.add(B);
		
		System.out.println(res);
		
	}

}
