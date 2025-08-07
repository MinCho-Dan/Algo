import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_1861_정사각형방__최규직 {

	private static int N;
	private static int[][] room;
    private static int cnt;
    private static int[] dx = {-1, 1, 0, 0}; // 상하좌우 순서로
    private static int[] dy = {0, 0, -1, 1}; // 상하좌우 순서로
    private static boolean[][] checked;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine()); // TC 개수
         
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");
             
            N = Integer.parseInt(in.readLine());
            
            room = new int[N][N]; // 방 배열 만들기
            for (int i = 0; i < N; i++) {
                String line = in.readLine();
                for (int j = 0; j < N; j++) {
                    room[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }
             
            checked = new boolean[N][N];
            for(int i = 0; i < N; i++) {
            cnt = 0;
            int result = countMove(i, i);
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
     
    private static int countMove(int x, int y) {
    	
    	if (checked[x][y] == true) return -1;

    	for (int k = 0; k < N*N; k++) {
    		for (int l = 0; l < N*N; l++) {
		        // 4방향 탐색
		        for (int i = 0; i < 4; i++) {
		            int nx = x + dx[i];
		            int ny = y + dy[i];
		            // 다음 위치가 범위 내에 있고, 갈 수 있는 경우
		            if (nx >= 0 && nx < N && ny >= 0 && ny < N && // 행렬 범위 내
		                room[nx][ny] == room[x][y] + 1) { // 갈수있음
		                // 위의 if문 조건성립 -> 방문해야할곳 -> 재귀 호출
		            	countMove(nx, ny);
		            	cnt++;
		            }
		            else {
		            	if (cnt > max) {
		            		max = cnt;
		            	}
		            }
		        }
    		}
    	}
        return -1;
    }
 
}




/*
 * N * N의 행렬에서 상하좌우 인접한 위치가 +1값이면 이동 가능.
 * 그렇게 이동해서 최대한 많이 움직이는 경우의 시작점의 값.
 * 많이 움직이는 경우가 여럿이라면 그중에 시작점의 숫자가 가장 작은 값 출력.
 * 
 * 
 * 
 * 
 * 
*/
