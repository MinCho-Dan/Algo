import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2908 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num1 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int num2 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

		System.out.println(num1 > num2 ? num1 : num2);
	}
}