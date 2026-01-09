import java.io.BufferedReader;
import java.io.InputStreamReader;

public class M_17135_캐슬디펜스_최규직 {
	
	
	public static void main(String[] args) throws Exception {
		 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     
        String[] split = in.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int D = Integer.parseInt(split[2]);
        
        int[][] map = new int[N+1][M];
        
        for (int i = 0; i < N; i++) {
        	String[] tmp = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
 
	}
}



/*
 * 문제에 대해 고민해보기.
 * 주어지는 N*M 행렬, 궁수의 공격가능 거리 D.
 * 3 ≤ N, M ≤ 15
 * 1 ≤ D ≤ 10
 * N * M map이 있다.
 * 행렬에 1로 표시한 부분이 적군이다.
 * 거리가 D 이하인 적 중에서 가장 가까운 적을 공격할 수 있다.
 * 거리는 |x1-x2| + |y1-y2| 이다. -> Math.abs 함수 활용
 * 모든 공격 이후에 적들은 한칸씩 내려온다. (성쪽으로 온다.)
 * 적이 성으로 도착하면 적은 사라진다.
 * 
 * N+1행 중에서 M개의 장소 중에 궁수를 3명 배치할 수 있다.
 * MC3으로 조합을 뽑아서,
 * DFS로 돌리면 풀리나?
 */