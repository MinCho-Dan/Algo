
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class S_1247_최적경로_최규직 {
	
	static int N;
	static xy company, home;
	static xy[] customers;
    static boolean[] visited;
    static int min;
	
    static class xy {
        int x, y;
        
        xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine());

        for (int q = 1; q <= T; q++) { 
        	sb.append("#" + q + " "); 
        	
        	N = Integer.parseInt(in.readLine());
        	customers = new xy[N];
        	visited = new boolean[N];
        	min = Integer.MAX_VALUE;
        	
        	// 회사, 집 저장
        	StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        	company = new xy(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); // 회사
        	home = new xy(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); // 집
        	// 고객 저장
        	for (int i = 0; i < N ; i++) { 
				customers[i] = new xy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
        	
        	 // 첫 번째 고객부터 탐색 시작
            for (int i = 0; i < N; i++) {
                visited[i] = true;
                dfs(customers[i], 1, distance(company, customers[i])); // 회사와 첫번째고객 거리 넣음
                visited[i] = false; // 백트래킹 위한 방문해제
            }
        	
            sb.append(min).append("\n");
            }
        System.out.println(sb);
		}

	private static void dfs(xy current, int cnt, int dist) {
		
		if (cnt == N) {
            dist += distance(current, home);
            min = Math.min(min, dist);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(customers[i], cnt + 1, dist + distance(current, customers[i]));
                visited[i] = false; // 백트래킹
            }
        }
		
	}

	private static int distance(xy xy11, xy xy22) {
		return Math.abs((xy11.x - xy22.x)) + Math.abs((xy11.y - xy22.y));
	}

}