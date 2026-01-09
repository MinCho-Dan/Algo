import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_27866 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int n = Integer.parseInt(br.readLine()) - 1;

		System.out.println(str.charAt(n));
	}
}