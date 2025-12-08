package Maraton79;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11059 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().toCharArray();
		
		int size = a.length;
		
		for (int i = size / 2; i > 0; i--) {

			for (int j = 0; j < size - (2 * i) + 1; j++) {
				
				int value1 = 0;
				int value2 = 0;
				
				for (int k = 0; k < i; k++) {
					value1 += a[j + k] - '0';
					value2 += a[j + i + k] - '0';
				}
			
				if (value1 == value2) {
					System.out.println(i * 2);
					return;
				}
			}
		}
		
	}
}