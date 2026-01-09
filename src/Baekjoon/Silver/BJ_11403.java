import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11403 {
	
	static int N;
	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		// 인접 행렬
		matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
            	matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 3중 for문을 통한 F-W알고리즘
        // k = 거쳐가는 노드
        for (int k = 0; k < N; k++) {
            // i = 출발 노드
            for (int i = 0; i < N; i++) {
                // j = 도착 노드
                for (int j = 0; j < N; j++) {
                    if (matrix[i][k] == 1 && matrix[k][j] == 1)
                    	matrix[i][j] = 1;
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(matrix[i][j] + " ");
			sb.append("\n");
		}

        
        System.out.print(sb);
	}
}