import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_31429 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] scores = { 12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6 };
		int[] penalties = { 1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773 };

		System.out.println(scores[N - 1] + " " + penalties[N - 1]);
	}
}
