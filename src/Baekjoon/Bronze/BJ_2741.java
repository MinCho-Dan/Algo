import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2741 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			System.out.println(i);
		}
	}
}