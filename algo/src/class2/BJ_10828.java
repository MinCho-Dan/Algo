package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_10828 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();

			switch (command) {
			case "push":
				q.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (q.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(q.pop()).append('\n');
				}
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 : 0).append('\n');
				break;
			case "top":
				if (q.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(q.peek()).append('\n');
				}
				break;
			}
		}

		System.out.print(sb);
	}
}