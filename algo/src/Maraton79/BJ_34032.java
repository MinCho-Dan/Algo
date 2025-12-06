package Maraton79;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_34032 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int cnt = 0;
		int mid = (n / 2) + ((n % 2 >= 1) ? 1 : 0);
		
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == 'O')
				cnt++;
			
			if (cnt >= mid)
				break;
		}
		
		if (cnt >= mid)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}
}