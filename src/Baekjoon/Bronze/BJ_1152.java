import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1152 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine().trim();
		
		if (str.isEmpty()) {
			System.out.println(0);
			return;
		}
		String[] tmp = str.split(" ");
		System.out.println(tmp.length);
	}

}