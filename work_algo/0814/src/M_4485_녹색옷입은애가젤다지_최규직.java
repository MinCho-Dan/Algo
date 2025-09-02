import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class M_4485_녹색옷입은애가젤다지_최규직 {

    // 우선순위 큐에 사용할 커스텀 클래스 (Comparable 인터페이스 구현 필수)
    public static class Rupee implements Comparable<Rupee> {
        int x, y, cost;

        public Rupee(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        // 비용(cost)을 기준으로 정렬
        @Override
        public int compareTo(Rupee other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    private static int N;
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;

        while (true) {
            N = Integer.parseInt(in.readLine());
            if (N == 0) {
                break;
            }

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dijkstra();
            sb.append("Problem ").append(caseNum++).append(": ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static int dijkstra() {
        // 최소 비용을 저장할 2차원 배열
        int[][] minCost = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        // 우선순위 큐 (비용이 낮은 순으로 정렬)
        PriorityQueue<Rupee> pq = new PriorityQueue<>();

        // 시작 지점 초기화
        minCost[0][0] = map[0][0];
        pq.offer(new Rupee(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Rupee current = pq.poll();
            int x = current.x;
            int y = current.y;
            int cost = current.cost;
            
            // 현재 꺼낸 비용이 이미 기록된 최소 비용보다 크면 무시 (최적화)
            if (cost > minCost[x][y]) {
                continue;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 범위를 벗어나지 않는지 확인
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    // 새로운 경로의 총비용 계산
                    int newCost = cost + map[nx][ny];
                    
                    // 더 짧은 경로를 찾았다면 갱신하고 우선순위 큐에 추가
                    if (newCost < minCost[nx][ny]) {
                        minCost[nx][ny] = newCost;
                        pq.offer(new Rupee(nx, ny, newCost));
                    }
                }
            }
        }
        // 도착 지점의 최소 비용 반환
        return minCost[N - 1][N - 1];
    }
}