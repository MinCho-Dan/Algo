import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_29751 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		int W = Integer.parseInt(tmp[0]);
		int H = Integer.parseInt(tmp[1]);
		
		System.out.printf("%.1f", (float) W*H/2);
	}
}
