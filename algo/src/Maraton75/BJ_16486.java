package Maraton75;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_16486 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 double d1 = Integer.parseInt(br.readLine());
		 double d2 = Integer.parseInt(br.readLine());
		 
		 double p = 3.141592;
		 
		 System.out.println((d1 * 2) + (p * 2 * d2));
	}

}
