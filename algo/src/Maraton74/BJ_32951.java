package Maraton74;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_32951 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int year = Integer.parseInt(br.readLine());
		
		System.out.println(year-2024);
	}
}
