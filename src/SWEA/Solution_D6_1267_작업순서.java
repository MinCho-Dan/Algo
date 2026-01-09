import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D6_1267_작업순서 {

		
	private static class Node {
		public int vertex;
		public Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	
	private static int V, E;
	private static Node[] adjList; // 인접리스트
	private static int[] inDegree; // 진입차수 (idx번호=정점번호, 값=진입차수)
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			V = Integer.parseInt(st.nextToken()); // 정점 수
			E = Integer.parseInt(st.nextToken()); // 간선 수
			
			adjList = new Node[V + 1]; // 정점번호 1부터 시작.
			inDegree = new int[V + 1]; // 0번 인덱스는 안쓴다는 소리겠쥬?
			
			int from, to;
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < E; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
				inDegree[to]++; // 진입차수 기록
			}
			
			List<Integer> list = topologySort();
			
			if (list.size() == V) {
				for (Integer vertex : list) {
					sb.append(vertex + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static List<Integer> topologySort() {
		
		List<Integer> orderList = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i <= V; i++) {
			// 1. 진입 차수가 0인 노드(시작점)를 큐에 모두 넣는다.
			if (inDegree[i] == 0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			
			// 2. 큐에서 진입 차수가 0인 노드를 꺼내어 자신과 인접한 노드의 간선을 제거한다.
			Integer cur = queue.poll();
			orderList.add(cur);
		
			for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
				
				if (--inDegree[temp.vertex] == 0) {
					// 3. 간선 제거 후 진입 차수가 0이 된 노드를 큐에 넣는다.
					queue.offer(temp.vertex);
				}
			}
		}
		return orderList;
	}
	
}
