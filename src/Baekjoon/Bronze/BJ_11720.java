import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11720 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		String a = in.readLine();
		
		int res = 0;
		
		for (int i = 0; i < N; i++) {
			int aa =(int) a.charAt(i) - '0';
			res += aa;
		}
		System.out.println(res);
	}

}
