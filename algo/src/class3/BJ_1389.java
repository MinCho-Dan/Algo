package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1389 {
	
	static int N, M;
	static int[][] dist;
	
	static final int INF = 999999999;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 최단거리를 dp처럼 구하는 플로이드-워셜 사용
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 최단거리 2차원 배열 초기화
		dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0; // 자기 자신으로 가는 경로는 0
                } else {
                    dist[i][j] = INF; // 나머지는 모두 무한대로 초기화
                }
            }
        }
        
        // 문제 간선정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            dist[start][end] = 1;
            dist[end][start] = 1;
        }
        
        // 3중 for문을 통한 F-W알고리즘
        // k = 거쳐가는 노드
        for (int k = 1; k <= N; k++) {
            // i = 출발 노드
            for (int i = 1; i <= N; i++) {
                // j = 도착 노드
                for (int j = 1; j <= N; j++) {
                    // i -> j 로 바로 가는 비용 vs i -> k -> j 로 거쳐 가는 비용 비교
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
            
        int compare = INF;
        int res = 0;
        for (int i = 1; i <= N; i++) {
        	int cnt = 0;
            for (int j = 1; j <= N; j++) {
                cnt += dist[i][j];
            }
            if (compare > cnt) {
            	compare = cnt;
            	res = i;
            }
        }
        System.out.print(res);
	}
}