import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3003 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = {1, 1, 2, 2, 2, 8};
		
		for (int i = 0; i < 6; i++) {
			arr[i] -= Integer.parseInt(st.nextToken());
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}

}
