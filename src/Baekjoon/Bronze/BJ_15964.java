import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_15964 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		long a = Integer.parseInt(tmp[0]);
		long b = Integer.parseInt(tmp[1]);

		long res = (a + b) * (a - b);
		System.out.println(res);

	}
}