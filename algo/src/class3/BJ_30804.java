package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_30804 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] chk = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int left = 0;
		int right = 0;
		int maxLen = -1;
		int uniq = 0;
		
		while (right < N) {
			int current = arr[right];
			if (chk[current]==0)
				uniq++;
			chk[current]++;
			
			while(uniq > 2) {
				int leftFruit = arr[left];
				chk[leftFruit]--;
				
				if (chk[leftFruit]==0)
					uniq--;
				left++;
			}
			
			maxLen = Math.max(maxLen, right-left+1);
		
			right++;
		}
		System.out.println(maxLen);
	}
}