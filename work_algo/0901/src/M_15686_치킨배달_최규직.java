import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M_15686_치킨배달_최규직 {
	
    static int N, M, ans = Integer.MAX_VALUE;
    static ArrayList<int[]> house = new ArrayList<>(); // 집
    static ArrayList<int[]> chik = new ArrayList<>();  // 치킨집
    static boolean[] sel; // 치킨집 선택 여부 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 입력받아서 리스트에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) house.add(new int[]{i, j});
                else if (type == 2) chik.add(new int[]{i, j});
            }
        }
        
        sel = new boolean[chik.size()];
        dfs(0, 0);
        

        System.out.println(ans);
    }


    static void dfs(int start, int cnt) {
        // M개의 치킨집을 모두 골랐을 경우
        if (cnt == M) {
            int totalDist = 0; // 토탈 거리 선언
            for (int[] h : house) { // 모든 집 순회
                int minDist = Integer.MAX_VALUE;
                for (int i = 0; i < chik.size(); i++) {
                    if (sel[i]) { // i번째 치킨집이 선택된 경우
                        int[] c = chik.get(i);
                        int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                        minDist = Math.min(minDist, dist); // 집에서 가장 가까운 치킨집만 저장
                    }
                }
                totalDist += minDist;
            }
            // 현재 조합에서 최소값이면 갱신
            ans = Math.min(ans, totalDist);
            return;
        }

        // 조합을 위한 재귀 호출
        for (int i = start; i < chik.size(); i++) {
            sel[i] = true; // 현재 치킨집 선택
            dfs(i + 1, cnt + 1); // 다음 치킨집을 고르러 이동
            sel[i] = false; // 백트래킹
        }
    }
}