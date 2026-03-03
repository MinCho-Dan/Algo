import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_27433 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long res = 1;
		for (int i = 1; i < n + 1; i++) {
			res *= i;
		}
		System.out.println(res);
	}

}