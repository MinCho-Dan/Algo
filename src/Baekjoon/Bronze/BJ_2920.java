import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2920 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String str = in.readLine();
		
		if (str.equals("1 2 3 4 5 6 7 8")) {
			System.out.println("ascending");
			return;
		} else if (str.equals("8 7 6 5 4 3 2 1")) {
			System.out.println("descending");
			return;
		}
		else
			System.out.println("mixed");
	}
}