package Maraton78;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_23968 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		
		int n = Integer.parseInt(tmp[0]);
		int k = Integer.parseInt(tmp[1]);
		
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i <n; i++)
			arr[i] = Integer.parseInt(str[i]);
		
		int cnt = 0;
		
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < n-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					cnt++;
				}
				if (cnt == k) {
					System.out.println(arr[j] + " " + arr[j+1]);
					return;
				}
			}
		}
		
		System.out.println(-1);
	}
}