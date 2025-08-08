import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class S_4193_수영대회결승전_최규직 {

	private static int N; // 길이
	private static int result;
	private static int[][] sea; // 바다
	private static int[][] visited;
	private static int[] dx = {-1, 1, 0, 0}; // 상하좌우 순서로
    private static int[] dy = {0, 0, -1, 1}; // 상하좌우 순서로
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
         
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");
            
            N = Integer.parseInt(in.readLine());
            
            sea = new int[N][N];
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
            	String[] tmp = in.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                	sea[i][j] = Integer.parseInt(tmp[j]);
                	visited[i][j] = Integer.MAX_VALUE;
                }
            }
            
            String[] tmp = in.readLine().split(" ");
            int startX = Integer.parseInt(tmp[0]);
            int startY = Integer.parseInt(tmp[1]);
            
            tmp = in.readLine().split(" ");
            int endX = Integer.parseInt(tmp[0]);
            int endY = Integer.parseInt(tmp[1]);
            

            result = bfs(startX, startY, endX, endY);

           
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
     
    private static int bfs(int startX, int startY, int endX, int endY) {
		
    	Queue<int[]> queue = new ArrayDeque<>(); // 큐선언
    	
    	// 큐에 {x, y, time} 형태로 저장
        queue.offer(new int[]{startX, startY, 0});
        
        // 위에서 max value로 채워놓은것, 0초부터 시작
        visited[startX][startY] = 0; 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];
            
            // 도착지점이라면 시간을 리턴하고 끝내기
            if (x == endX && y == endY) {return time;}
 
            for (int i = 0; i < 4; i++) {// 4방향 이동하기.
                int nx = x + dx[i];
                int ny = y + dy[i];

                // sea 범위 넘어가면 패스
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {continue; }
                
                // 장애물 패스
                if (sea[nx][ny] == 1) {continue;} 
                
                // 소용돌이를 만났다면
                if (sea[nx][ny] == 2) { 
                    int waitTime = 0;
                    if (time % 3 != 2) { // (시간%3=2)일때 소용돌이는 없어짐
                        waitTime = 2 - (time % 3); // 소용돌이가 있다면 기다려야할 시간
                    }
                    // 소용돌이가 사라지길 기다렸다가 다음 지점에 도착하는 최종시간 도출
                    int newTime = time + waitTime + 1;

                    // 위의 최종시간보다 더 빠른 경로일 경우에만 큐에 추가하기.
                    if (newTime < visited[nx][ny]) {
                        visited[nx][ny] = newTime;
                        queue.offer(new int[]{nx, ny, newTime});
                    }
                }
                
                else { // 갈 수 있는 경우(sea 범위내이고, 장애물이 아니고, 소용돌이도 아닌경우.)
                    int newTime = time + 1;

                    if (newTime < visited[nx][ny]) { // 더 빠른 경로일때만 큐에 추가.
                        visited[nx][ny] = newTime;
                        queue.offer(new int[]{nx, ny, newTime});
                    }
                }
            }
        }
        return -1;
    }
}


/*
 * BFS 사용.
 * 큐에 {x, y, time} 형태로 저장해서 time이 min인값을 return 하면 될것 같다.
 * 소용돌이쪽 처리가 어려울거 같은데.
 * 소용돌이(2)는 0초,1초(못지나감),2초(지나감) 반복하니까 시간%3=2일때 지나갈 수 있음.
 * 시간 % 3 했을때 2
 * 장애물(1)은 그냥 못가는곳으로 보면 되고..
 * 테케 15개 중에 9개 PASS...
*/
