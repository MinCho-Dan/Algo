import java.io.BufferedReader;
import java.io.InputStreamReader;

public class M_15683_감시_최규직 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] tmp = br.readLine().split(" "); // 첫줄
	    int N = Integer.parseInt(tmp[0]);
	    int M = Integer.parseInt(tmp[1]);
	    
	    int[][] office = new int[N][M]; 
	    for (int i = 1; i < N; i++) { 
	    	tmp = br.readLine().split(" ");
	    	for (int j = 0; j < M; j++) {
	    		office[i][j] = Integer.parseInt(tmp[j]); // 사무실 행렬 입력
			}
	    }
	    
	    // 인접행렬 생성
	    int[][] adj = new int[N + 1][N + 1];
	    for (int from = 1; from <= N; from++) {
            String[] temp = br.readLine().split(" ");
            int num = Integer.parseInt(temp[0]);
            for (int j = 1; j <= num; j++) {
            	int to = Integer.parseInt(temp[j]);
            	adj[from][to] = 1;
            	adj[to][from] = 1;
            }
        }
	    
        System.out.println();
        
       
        
    }
}


/*
 *  N * M 사이즈의 사무실.
 *  1, 2, 3, 4개의 방향을 볼 수 있는 카메라.
 *  6을 만나면 빠져나오고. 1~5인 카메라라면 패스 가능.
 *  볼 수 있는 부분을 #으로 대체하고, 0의 수(사각지대수)를 최소로 하는 값 출력...
 *  
 *  1번 카메라 -> 상 / 하 / 좌 / 우 : 4개
 *  2번 카메라 -> 상하 / 좌우 : 2개
 *  3번 카메라 -> 상우 / 우하 / 하좌/ 좌상 : 4개
 *  4번 카메라 -> 4방향중 3방향 : 4개
 *  5번 카메라 -> 상하좌우 모두 : 1개
 */
