import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_28358 {

	static int[] daysInMonth = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int[] used;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			used = new int[10];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				if (Integer.parseInt(st.nextToken()) == 1)
					used[i] = 1;
			}

			int count = 0;
			for (int month = 1; month <= 12; month++) {
				if (!isPossible(month))
					continue;

				// 1일부터 해당 월의 마지막 날까지 순회
				for (int day = 1; day <= daysInMonth[month]; day++) {
					// 일(Day)에 금지된 숫자가 없으면 카운트
					if (isPossible(day)) {
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	static boolean isPossible(int num) {

		String s = String.valueOf(num);

		for (char c : s.toCharArray()) {
			if (used[c - '0'] == 1) {
				return false;
			}
		}
		return true;
	}

}