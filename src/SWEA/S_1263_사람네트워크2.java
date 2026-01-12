import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_1263_사람네트워크2 {

	static final int INF = 100001; // 최대 인원수(100) * 최대 거리(1000)보다 큰 값으로 설정

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());

            // 인접 행렬 (거리 행렬) 초기화
            int[][] D = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int connect = Integer.parseInt(st.nextToken());
                    // 직접 연결된 경우
                    if (connect == 1) {
                        D[i][j] = 1;
                    } 
                    // 직접 연결되지 않은 경우
                    else {
                        // 자기 자신인 경우 거리는 0
                        if (i == j) {
                            D[i][j] = 0;
                        } 
                        // 다른 노드와 연결되지 않은 경우 거리는 무한대
                        else {
                            D[i][j] = INF;
                        }
                    }
                }
            }
            
            // k는 경유 노드
            for (int k = 0; k < N; k++) {
                // i는 출발 노드
                for (int i = 0; i < N; i++) {
                    // j는 도착 노드
                    for (int j = 0; j < N; j++) {
                        // i에서 j로 가는 거리와 i -> k -> j로 가는 거리 중 더 짧은 것을 선택
                        if (D[i][j] > D[i][k] + D[k][j]) {
                            D[i][j] = D[i][k] + D[k][j];
                        }
                    }
                }
            }

            int minCC = INF; // 최소 CC 값

            // 각 노드의 CC 값 계산
            // 한 행의 합계 -> CC값
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += D[i][j];
                }
                // 최소 CC 값 갱신
                if (sum < minCC) {
                    minCC = sum;
                }
            }

            sb.append("#" + test_case + " " + minCC +"\n");
        }

        System.out.print(sb);
    }
}