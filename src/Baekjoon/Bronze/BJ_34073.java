import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_34073 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] a = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			sb.append(a[i] + "DORO ");
		}
		
		System.out.println(sb);
	}

}
