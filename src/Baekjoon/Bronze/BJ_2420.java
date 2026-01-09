import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2420 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		long N = Integer.parseInt(tmp[0]);
		long M = Integer.parseInt(tmp[1]);
		
		long res = Math.abs(N - M);
		
		System.out.println(res);

	}
}