package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2115_벌꿀채취 {

    static int N, M, C;
    static int[][] map;
    static int result;
    static int maxProfitInArea;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            
            // 두 명의 일꾼이 벌꿀을 채취할 수 있는 모든 경우 탐색
            // 첫 번째 일꾼의 시작 위치 (i1, j1)
            for (int i1 = 0; i1 < N; i1++) {
                for (int j1 = 0; j1 <= N - M; j1++) {
                    // 두 번째 일꾼의 시작 위치 (i2, j2)
                    for (int i2 = i1; i2 < N; i2++) {
                        int j2 = (i1 == i2) ? j1 + M : 0;
                        for (; j2 <= N - M; j2++) {
                            // 각 일꾼의 최대 수익 계산
                            int profit1 = getMaxProfit(i1, j1);
                            int profit2 = getMaxProfit(i2, j2);
                            result = Math.max(result, profit1 + profit2);
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }

    // 주어진 벌통 구간에서 백트래킹을 이용해 최대 수익 계산
    public static int getMaxProfit(int row, int col) {
        // M개의 벌통 정보
        int[] honey = new int[M];
        for (int i = 0; i < M; i++) {
            honey[i] = map[row][col + i];
        }

        maxProfitInArea = 0; // 해당 구역의 최대 수익을 0으로 초기화
        
        // 재귀 호출을 통해 모든 부분집합 탐색
        findSubsets(honey, 0, 0, 0);

        return maxProfitInArea;
    }

    // 벌통의 부분집합을 탐색하는 재귀 메서드 (백트래킹)
    // idx: 현재 확인 중인 벌통의 인덱스
    // currentSum: 현재까지 선택한 벌통의 꿀 총합
    // currentProfit: 현재까지 선택한 벌통의 수익 총합
    public static void findSubsets(int[] honey, int idx, int currentSum, int currentProfit) {
        // 백트래킹: 꿀 총합이 C를 초과하면 리턴
        if (currentSum > C) {
            return;
        }

        // 모든 벌통을 다 확인했다면, 최대 수익인지 판별.
        if (idx == M) {
            maxProfitInArea = Math.max(maxProfitInArea, currentProfit);
            return;
        }

        // 1. 현재 벌통을 선택하는 경우
        // 다음 벌통으로 넘어가되, 꿀과 수익을 더한 상태로 재귀 호출
        findSubsets(honey, idx + 1, currentSum + honey[idx], currentProfit + (honey[idx] * honey[idx]));

        // 2. 현재 벌통을 선택하지 않는 경우
        // 다음 벌통으로 넘어가되, 꿀과 수익을 그대로 둔 상태로 재귀 호출
        findSubsets(honey, idx + 1, currentSum, currentProfit);
    }
}