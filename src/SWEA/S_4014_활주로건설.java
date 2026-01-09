import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_4014_활주로건설_최규직 {
	
	static int N, X;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
        	String[] temp = in.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            X = Integer.parseInt(temp[1]);
            
            int[][] map = new int[N][N];
            int cnt = 0;
            
            for (int i = 0; i < N; i++) {
            	temp = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
            
            int[] chk = new int[N];
            // 가로방향 확인
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
            		chk[j] = map[i][j];
				}
            	if (runway(chk)) cnt++; 
			}
            // 세로방향 확인
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
            		chk[j] = map[j][i]; // 위에서 map의 i와 j만 반대로
				}
            	if (runway(chk)) cnt++;
			}

            sb.append("#" + test_case + " " + cnt +"\n");
        }

        System.out.print(sb);
    }

	private static boolean runway(int[] chk) {
		
		boolean[] visited = new boolean[N];
		
        for (int i = 0; i < N - 1; i++) {
            int diff = chk[i] - chk[i+1];

            if (diff == 0) continue; // 높이가 같은 경우 패스
            
            else if (Math.abs(diff) > 1) return false; // 높이 차이가 1보다 큰 경우 안됨
            
            else if (diff == 1) { // 내려가는 경우
            	// 다음 칸부터 X 길이만큼 평탄한지, 경사로가 놓이지 않았는지 확인
                for (int j = 1; j <= X; j++) {
                    if (i + j >= N) return false; // 배열 범위를 벗어나는 경우
                    if (chk[i+1] != chk[i+j]) return false; // 평탄하지 않은 경우
                    if (visited[i+j]) return false;// 이미 경사로가 놓인 경우
                }
                // 조건을 모두 만족하면 경사로를 놓았다고 표시
                for (int j = 1; j <= X; j++) {
                    visited[i+j] = true;
                }
                
            } else { // 올라가는 경우 (diff==-1)
            	// 위에서 부호만 반대로 보면 됨.
                for (int j = 0; j < X; j++) { // 현재 위치 기준으로 왼쪽을 봄.
                    if (i - j < 0) return false;
                    if (chk[i] != chk[i-j]) return false;
                    if (visited[i-j]) return false;
                }
                for (int j = 0; j < X; j++) {
                    visited[i-j] = true;
                }
            }
        }
        return true;
    }
		
}