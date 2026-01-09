import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BJ_11866 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		sb.append("<");
		
		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		while (!q.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				q.offer(q.poll());
			}
			
			sb.append(q.poll());
			
			if (!q.isEmpty()) {
				sb.append(", ");
			}
		}
		
		sb.append(">");

		System.out.println(sb);
	}
}

