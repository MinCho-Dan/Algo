import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// TC
//5
//0 4
//0 2 2 5 9
//2 0 3 4 8
//2 3 0 7 6
//5 4 7 0 5
//9 8 6 5 0

public class Dijkstra_AdjMatrix_PQ {
	
	
	private static class Vertex implements Comparable<Vertex>{
		
		public int no;
		public int weight;
		
		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight; // 비용기준 오름차순 정렬
		}

		@Override
		public String toString() {
			return "Vertex [no=" + no + ", weight=" + weight + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(in.readLine()); // 정점개수
		
		int[][] adjMatrix = new int[V][V];
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()); // 출발 정점
		int end = Integer.parseInt(st.nextToken()); // 도착 정점
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 2. 알고리즘 구현
		int[] distance = new int[V]; // 출발지에서 자신으로 오는데 소요되는 최소비용 기록
		boolean[] visited = new boolean[V]; // 정점 고려 여부
		Arrays.fill(distance, Integer.MAX_VALUE); // 무한대 값으로 초기화
		
		// 출발 정점 처리
		distance[start] = 0; // 비용 0으로 처리
		
		Queue<Vertex> pQueue = new PriorityQueue<>();
		pQueue.offer(new Vertex(start, 0));		

		
		while (!pQueue.isEmpty()) {
			
			// 1단계 : 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점선택
			// 방문해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기
			Vertex current = pQueue.poll();


			// 방문처리
			visited[current.no] = true;
			
			// (선택사항) 가지치기 : 선택 정점이 도착정점이면 바로 빠져나가기
			if (current.no == end) break;
			
			// 2단계 : 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고
			// 기존 최적해보다 유리하면 갱신
			for (int i = 0; i < V; i++) {
				if (!visited[i] &&
					adjMatrix[current.no][i] != 0 &&
					distance[i] > current.weight + adjMatrix[current.no][i]) {
					distance[i] = current.weight + adjMatrix[current.no][i];
					pQueue.offer(new Vertex(i, distance[i]));
				}
			}
		}
		
		System.out.println("정답은? " + distance[end]);
	}
	
}
