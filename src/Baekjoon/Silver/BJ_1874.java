import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BJ_1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		int num = 1;

		for (int i = 0; i < N; i++) {
			while (num <= arr[i]) {
				q.push(num);
				num++;
				sb.append("+" + "\n");
			}
			if (arr[i] == q.peek()) {
				q.pop();
				sb.append("-" + "\n");
			} else {
				System.out.println("NO");
				return;
			}

		}

		System.out.print(sb);
	}
}
