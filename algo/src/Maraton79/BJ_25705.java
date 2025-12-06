package Maraton79;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_25705 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		int m = Integer.parseInt(br.readLine());
		char[] find = br.readLine().toCharArray();
		
		int i = str.length - 1;
		int chk = 0;
		int maxChk = str.length;
		int j = 0;
		int cnt = 0;
		
		while (true) {
			i = (i + 1) % n;
			cnt++;
			chk++;
			
			if (chk > maxChk) {
				System.out.println(-1);
				return;
			}
			
			if (str[i] == find[j]) {
				j++;
				chk = -1;
				if (j == m) {
					System.out.println(cnt);
					break;
				}
			}
		}
		
	}
}