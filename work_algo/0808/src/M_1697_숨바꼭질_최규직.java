import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class M_1697_숨바꼭질_최규직 {
	

	private static int N;
	private static int K;
	private static boolean[] visited;
	private static int result;
	static int sec;

	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new boolean[100001];
		result = Integer.MAX_VALUE;
		sec = 0;
		
		
//		for (int i = 0; i < 100000; i++) {
//			if (N == K) break;
//			if (N*2 <= K) {N *= 2; sec++;}
//			else if (K-N > N-(K/2)){N++;sec++;}
//			else {N--; sec++;}
//		}
		
		System.out.println(sec);
//		sol(N,K,0);

//		System.out.println(result);
		
	}
	
	
	
	



	private static void sol(int n, int k, int min) {
		
		Queue<Integer> queue = new ArrayDeque<>(); // 큐 선언
		
		queue.offer(n);
		visited[n] = true;
		
		int current = n;

		while (!queue.isEmpty()) {
			
			// 방문예약 한 것 중 맨 앞에 있는 정점
			current = queue.poll();
			
			// 방문한 정점에서 해야할 일 처리 -> 예시는 알파벳 출력.
			System.out.println("현재위치는 " + current);
			sec++;
			System.out.println("걸린 시간은 " + sec);
			
			// +1 / -1 / *2의 조건을 어떻게 주면 좋을지?
			for (int i = 0; i < N; i++) {
	            if (i==0 && n!=0 && !visited[n+1]) {
	            	queue.offer(n+1);
	            	visited[n+1] = true;
	            }	
	            if (i==1 && n>=100000 && !visited[n-1]) {
	            	queue.offer(n-1);
	            	visited[n-1] = true;
	            }
	            if (i==2 && n<=50000 && !visited[n*2]) {
	            	visited[n*1] = true;
	            }
			}
		}
        result = sec;
	}
}



/*
 * 예전에 파이썬으로 비슷한 문제 풀어봤던거 같은데.. 어떻게 했는지 기억 안남
 * 얘도 BFS로 푸는거 같은데
 * 
 * 
 * 
*/
