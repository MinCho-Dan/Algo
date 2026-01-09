import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class M_1753_최단경로_최규직 {
	
	private static class Vertex {
		public int vertex;
		public int weight;
		public Vertex link;
		
		public Vertex(int vertex, int weight, Vertex link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
	}

	public static void main(String[] args) throws Exception {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(in.readLine(), " ");
	    int V = Integer.parseInt(st.nextToken());
	    int E = Integer.parseInt(st.nextToken());
	    
	    int K = Integer.parseInt(in.readLine()); // 둘째줄
	    
	    Vertex[] adjList = new Vertex[V+1];
	    
	    for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Vertex(to, weight, adjList[from]);
		}
	    
	    int[] distance = new int[V+1]; // 출발지에서 자신으로 오는데 소요되는 최소비용 기록
		boolean[] visited = new boolean[V+1]; // 정점 고려 여부
		Arrays.fill(distance, Integer.MAX_VALUE); // 무한대 값으로 초기화
		
		// 출발 정점 처리
		Queue<Vertex> pQueue = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
		pQueue.offer(new Vertex(K,  0, null));
		
		while (!pQueue.isEmpty()) {
			
			// 1단계 : 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점선택
			// 방문해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기
			Vertex current = pQueue.poll();

			// 방문처리
			visited[current.vertex] = true;
			
			
			// 2단계 : 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고
			// 기존 최적해보다 유리하면 갱신
			for (Vertex temp = adjList[current.vertex]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex] &&
					distance[temp.vertex] > current.weight + temp.weight) {
					distance[temp.vertex] = current.weight + temp.weight;
					pQueue.offer(new Vertex(temp.vertex, distance[temp.vertex], null));
				}
			}
		}
	    
	    for (int i = 1; i < V+1; i++) {
	    	if (i == K) System.out.println(0);
	    	else if (distance[i] != Integer.MAX_VALUE)
	    	System.out.println(distance[i]);
	    	else {
	    		System.out.println("INF");
	    	}
		}
       
        
    }
}