import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S_1251_하나로_최규직 {
	
	private static Edge[] edgeList;
	private static int N; // 원소의 개수
	private static int[] parents; // 대표자 (인덱스 번호는 원소, 값은 대표자 원소 번호)
	
	
	private static class Edge implements Comparable<Edge> {
		
		public int from; // 시작 정점 번호
		public int to; // 도착 정점 번호
		public long weight; // 가중치
		
		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;	
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight); // 가중치 오름차순 정렬
		}	
	}
	

	private static void makeSet() {
		
		parents = new int[N]; // 원소 번호는 0부터 출발
		
		// 각 원소가 집합의 대표자로 설정
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	
	// a 원소의 집합을 찾기 (a의 대표자 찾기)
	private static int findSet(int a) {
		
		// 기저부분 : a가 대표면 대표자라고 리턴
		if (parents[a] == a) {
			return a;
		}
		
		// 유도부분 : a가 대표가 아니면 대표자 찾으러 가기
//		return findSet(parents[a]); // 편향되는 depth가 깊은 그래프가 생김
		return parents[a] = findSet(parents[a]); // 경로 압축!
	}
	
	
	// a, b 두 집합 합치기
	private static boolean unionSet(int a, int b) {
		
		int aRoot = findSet(a); // a의 대표자 찾기
		int bRoot = findSet(b); // b의 대표자 찾기
		// 대표자가 같다면 이미 같은 집합. false 리턴.
		if (aRoot == bRoot) { 
			return false;
		}
		
		// 대표자가 다르면 하나의 집합으로 합치기
		// a의 대표자 집합으로 b 대표자 집합이 들어가는 방식
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int i = 1; i <= T; i++) { // 테케반복
			sb.append("#" + i + " ");
			
			N = Integer.parseInt(in.readLine());
			// 섬들의 x좌표 x배열에 저장
			int[] x = new int[N];
			String[] temp = in.readLine().split(" ");
			for (int k = 0; k < temp.length; k++) {
				x[k] = Integer.parseInt(temp[k]);
			}
			// 섬들의 y좌표 y배열에 저장
			int[] y = new int[N];
			temp = in.readLine().split(" ");
			for (int k = 0; k < temp.length; k++) {
				y[k] = Integer.parseInt(temp[k]);
			}
			
			double E = Double.parseDouble(in.readLine());
			
			edgeList = new Edge[(N * (N-1) / 2)];
			
			// 간선 저장
			int edgeIndex = 0;
			for (int from = 0; from < N; from++) {
			    for (int to = from + 1; to < N; to++) {
			        long weight = (long) Math.pow(x[from] - x[to], 2) + (long) Math.pow(y[from] - y[to], 2);
			        edgeList[edgeIndex++] = new Edge(from, to, weight);
			    }
			}
			
			
			// 가중치 오름차순 정렬
			Arrays.sort(edgeList);
			
			// 3. 크루스칼 알고리즘 적용
			makeSet();
			
			double result = 0; // MST 비용
			int count = 0; // 연결 간선 수
			for (Edge edge : edgeList) {
				if (unionSet(edge.from, edge.to)) {
					result += E * edge.weight;
					
					if (++count == N - 1) {
						break;
					}
				}
			}
			
			sb.append(Math.round(result) + "\n");
		}
		
		
		System.out.println(sb);
	}
}
