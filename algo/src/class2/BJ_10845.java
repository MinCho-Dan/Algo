package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_10845 {

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
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (q.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(q.poll()).append('\n');
				}
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 : 0).append('\n');
				break;
			case "front":
				if (q.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(q.getFirst()).append('\n');
				}
				break;
			case "back":
				if (q.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(q.getLast()).append('\n');
				}
				break;
			}
		}

		System.out.print(sb);
	}
}