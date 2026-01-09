import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_2117_홈방범서비스_최규직 {
	
	static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
        	String[] temp = in.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);
            
            int[][] map = new int[N][N];
            
            for (int i = 0; i < N; i++) {
            	temp = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
            
            
            
            
            
        }
    }
}


/*
- 도시 크기 N (5 ≤ N ≤ 20)
- 하나의 집이 지불할 수 있는 비용 M (1 ≤ M ≤ 10)
- 서비스영역 K

서비스 영역의 중심으로부터 (K - 1) 이하의 거리에 있으면 영역 안에 있음.
(K * K) + ((K - 1) * (K - 1))로 서비스 비용을 계산하고
영역안에 있는 집들이 지불하는 비용이랑 비교해서

서비스비용 < 집들 지불비용
을 만족하면서
집들의 수가 가장 많은 경우의
집들의 수를 리턴.

숫자가 작아서 완탐해도 되긴 될거같은데?
 */
