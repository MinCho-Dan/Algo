package Maraton;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_15727 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		while (L > 0) {
			if (L > 5) {
				L -= 5;
				cnt++;
			}
			else {
				L -= L;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
