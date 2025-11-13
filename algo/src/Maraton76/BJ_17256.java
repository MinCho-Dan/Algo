package Maraton76;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17256 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int arr[][] = new int[2][3];
		
		for (int in = 0; in < 2; in++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++)
				arr[in][i] = Integer.parseInt(st.nextToken());
		}

		sb.append(arr[1][0] - arr[0][2] + " ");
		sb.append(arr[1][1] / arr[0][1] + " ");
		sb.append(arr[1][2] - arr[0][0]);
		
		System.out.println(sb);
	}

}
