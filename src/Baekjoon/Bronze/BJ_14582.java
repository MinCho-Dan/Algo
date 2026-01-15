import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14582 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] my = new int[9];
		for (int i = 0; i < 9; i++) 
			my[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] your = new int[9];
		for (int i = 0; i < 9; i++) 
			your[i] = Integer.parseInt(st.nextToken());
		
		int a = 0, b = 0;
		
		for (int i = 0; i < 9; i++) {
			a += my[i];
			if (a > b) {
				System.out.println("Yes");
				return;
			}
			b += your[i];
		}
		
		System.out.println("No");
	}
}