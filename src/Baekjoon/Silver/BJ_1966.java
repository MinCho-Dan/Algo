import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_1966 {

	static class Doc {
		int index;
		int priority;

		public Doc(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int T = 0; T < TC; T++) {

			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);

			ArrayDeque<Doc> q = new ArrayDeque<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			tmp = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				int pri = Integer.parseInt(tmp[i]);
				q.add(new Doc(i, pri));
				pq.add(pri);
			}

			int cnt = 0;
			
			while (!q.isEmpty()) {
				Doc current = q.poll();

				// 최고 중요도(pq.peek())와 비교
				if (current.priority == pq.peek()) {
					// 인쇄
					cnt++;
					pq.poll(); // 최고 중요도를 pq에서 제거

					// 3-3. 이 문서가 우리가 찾던 M번째 문서인지 확인
					if (current.index == M) {
						sb.append(cnt).append('\n');
						break; // 이번 테스트 케이스 종료
					}
				} else {
					// [인쇄하지 못하는 경우]
					// 큐의 맨 뒤로 다시 보냄
					q.add(current);
				}
			}
		}
		System.out.print(sb);
	}
}

