import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class S_3124_최소스패닝트리_유니온파인드 {

	// 1. 간선 리스트 준비
	private static class Edge implements Comparable<Edge> {
		
		public int from; // 시작 정점 번호
		public int to; // 도착 정점 번호
		public int weight; // 가중치
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;	
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight; // 가중치 오름차순 정렬
		}	
	}
	
	private static Edge[] edgeList;
	
	// 2. 서로소 집합 준비
	private static int[] parents; // 대표자 (인덱스 번호는 원소, 값은 대표자 원소 번호)
	
	private static void makeSet() {
		
		parents = new int[N + 1]; //
		
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
	
	
	private static int N; // 정점개수
	private static int E; // 간선개수
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine()); // TC 개수
        
        // T개의 TC 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");
             
            String[] tmp = in.readLine().split(" ");
            N = Integer.parseInt(tmp[0]);
            E = Integer.parseInt(tmp[1]);
            edgeList = new Edge[E];
            
            for (int i = 0; i < E; i++) {
            	String[] temp = in.readLine().split(" ");
            	int from = Integer.parseInt(temp[0]);
            	int to = Integer.parseInt(temp[1]);
            	int weight = Integer.parseInt(temp[2]);
            	edgeList[i] = new Edge(from, to, weight);
			}
            
            Arrays.sort(edgeList);
            
            makeSet();
            long result = 0; // MST 비용
    		int count = 0; // 연결 간선 수
    		for (Edge edge : edgeList) {
    			if (unionSet(edge.from, edge.to)) {
    				result += edge.weight;
    				if (++count == N - 1) {
    					break;
    				}
    			}
    		}
    		
            sb.append(result + "\n");
            
        }
        System.out.println(sb);
	}

}
