package Maraton84;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15664 {
	static int n, m;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		result = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.print(sb);

	}

	private static void dfs(int start, int depth) {
		
		if (depth == m) {
            for (int val : result) 
                sb.append(val).append(" ");
            sb.append("\n");
            return;
        }

        int lastUsed = -1;
        for (int i = start; i < n; i++) {
            if (lastUsed != arr[i]) {
                result[depth] = arr[i];
                lastUsed = arr[i];
                dfs(i + 1, depth + 1);
            }
        }
		
	}
}