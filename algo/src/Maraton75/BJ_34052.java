package Maraton75;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_34052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int res = 0;
		for (int i = 0; i < 4; i++)
			res += Integer.parseInt(br.readLine());
		
		res += 300;
		
		if (res > 1800) 
			System.out.println("No");
		else
			System.out.println("Yes");
	}

}
