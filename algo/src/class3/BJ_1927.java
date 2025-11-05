package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		// 최소힙 ( 기본값)
		PriorityQueue<Integer> q = new PriorityQueue<>();

		// 최대힙
//		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> (o2 - o1));

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (q.isEmpty())
					sb.append(0 + "\n");
				else
					sb.append(q.poll() + "\n");
			} else
				q.offer(input);
		}

		System.out.println(sb);
	}
}