import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_25640 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String jinho = br.readLine();
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (jinho.equals(br.readLine()))
				cnt++;
		}
		System.out.println(cnt);
	}
}