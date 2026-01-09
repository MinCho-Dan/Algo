import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_34692 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < m; i++)
			pq.add(0);

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			int tmp = pq.poll();
			pq.add(a + tmp);
		}

		int A = pq.poll();
		if (A > k)
			System.out.println("GO");
		else
			System.out.println("WAIT");
	}
}