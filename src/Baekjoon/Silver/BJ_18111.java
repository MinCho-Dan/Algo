import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18111 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int minHeight = -1;
		int minTime = Integer.MAX_VALUE;
		int min = 300;
		int max = -1;

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] < min)
					min = map[i][j];
				if (map[i][j] > max)
					max = map[i][j];
			}
		}

		for (int h = min; h <= max; h++) {
			int getb = 0;
			int setb = 0;
			int time = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 타겟 높이보다 높을경우
					if (h < map[i][j]) {
						int a = map[i][j] - h;
						time += a * 2;
						getb += a;
					} else if (h > map[i][j]) { // 타겟 높이보다 낮을경우
						int a = h - map[i][j];
						time += a;
						setb += a;
					}
				}

			}
			if (B + getb >= setb) {
				if (time <= minTime) {
					minTime = time;
					minHeight = h;
				}
			}
		}
		System.out.println(minTime + " " + minHeight);
	}
}