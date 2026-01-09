import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_13909 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int res = (int) Math.sqrt(n);
		System.out.println(res);
	}
}