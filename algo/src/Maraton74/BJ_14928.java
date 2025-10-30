package Maraton74;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_14928 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger num = new BigInteger(br.readLine());
		System.out.println(num.mod(new BigInteger("20000303")).toString());

	}
}
