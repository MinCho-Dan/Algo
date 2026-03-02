import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15876 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int num = 0;
		while (sb.length() < n * 5) {
			sb.append(binary(num));
			num++;
		}

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 5; i++)
			res.append(sb.charAt((k - 1) + (i * n)) + " ");

		System.out.println(res);
	}

	private static String binary(int num) {
		StringBuilder tmp = new StringBuilder();
		while (true) {
			if (num >= 2) {
				tmp.append(num % 2);
				num /= 2;
			} else if (num == 1) {
				tmp.append(1);
				break;
			} else if (num == 0) {
				tmp.append(0);
				break;
			}
		}
		return tmp.reverse().toString();
	}
}