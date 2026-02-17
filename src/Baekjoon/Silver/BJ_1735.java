import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1735 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int ja = (a * d) + (b * c);
		int mo = b * d;

		int gcdValue = findGcd(ja, mo);

		System.out.println(ja / gcdValue + " " + mo / gcdValue);
	}

	private static int findGcd(int ja, int mo) {
		while (mo > 0) {
			int tmp = ja;
			ja = mo;
			mo = tmp % mo;
		}
		return ja;
	}
}