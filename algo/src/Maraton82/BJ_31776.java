package Maraton82;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_31776 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			int[] temp = new int[3];
			for (int j = 0; j < 3; j++) {
				temp[j] = Integer.parseInt(tmp[j]);
			}
			if (temp[0] >= 0) {
				if (temp[1] == -1 && temp[2] == -1)
					cnt++;
				else if (temp[1] >= temp[0] && (temp[2] >= temp[1] || temp[2] == -1))
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
