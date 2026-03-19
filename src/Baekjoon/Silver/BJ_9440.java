import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_9440 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        	int n = Integer.parseInt(st.nextToken());
        	if (n == 0) break;
        	
        	for (int i = 0; i < n; i++)
        		pq.offer(Integer.parseInt(st.nextToken()));
        	
        	int a = 0;
        	int b = 0;

        	// a의 첫 자리
            PriorityQueue<Integer> temp = new PriorityQueue<>();
            while (!pq.isEmpty()) {
                int x = pq.poll();
                if (x != 0) {
                    a = x;
                    break;
                }
                temp.offer(x);
            }
            while (!temp.isEmpty()) pq.offer(temp.poll());

            // b의 첫 자리
            temp = new PriorityQueue<>();
            while (!pq.isEmpty()) {
                int x = pq.poll();
                if (x != 0) {
                    b = x;
                    break;
                }
                temp.offer(x);
            }
            while (!temp.isEmpty()) pq.offer(temp.poll());
            
            
            boolean turn = true;
            while (!pq.isEmpty()) {
                int x = pq.poll();
                if (turn) a = a * 10 + x;
                else b = b * 10 + x;
                turn = !turn;
            }

        	sb.append((a + b) + "\n");
        }
        System.out.println(sb);
    }
}