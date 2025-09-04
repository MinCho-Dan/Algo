import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 그리디 접근
// sum(win) == sum(lose)
// 예제3처럼 C혼자 무승부 2번 -> case 판별 불가해서 그리디로 불가능.
// -> 그리디로 가지치기 정도는 가능할듯

// 걍 백트래킹해야겠지?


public class M_6987_월드컵_최규직 {
    static int[][] results;
    static int[][] matches;
    static boolean possible;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 6C2 = 15개의 경기 만들어 놓기
        matches = new int[15][2];
        int matchIdx = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                matches[matchIdx][0] = i;
                matches[matchIdx][1] = j;
                matchIdx++;
            }
        }
        
        // 문제에서 입력으로 4개의 결과가 주어짐
		for (int T = 0; T < 4; T++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

	        // 변수 초기화
	        results = new int[6][3];
            int sumWins = 0;
            int sumDraws = 0;
            int sumLosses = 0;
            possible = false;
            
            // 승부 결과 저장
	        for (int i = 0; i < 6; i++) {
	        	results[i][0] = Integer.parseInt(st.nextToken()); //승
	        	results[i][1] = Integer.parseInt(st.nextToken()); //무
	        	results[i][2] = Integer.parseInt(st.nextToken()); //패
                sumWins += results[i][0];
                sumDraws += results[i][1];
                sumLosses += results[i][2];
			}

	        // 그리디 가지치기
	        // 총 경기 수 15개 -> 경기결과는 총 30개
	        // 승리합계 = 패배합계
	        if (sumWins + sumDraws + sumLosses != 30 || sumWins != sumLosses) {
                System.out.print("0 ");
                continue;
            }

	        dfs(0);
	        
	        System.out.print(possible ? "1 " : "0 ");
		}
	}

	// cnt번째 매치를 판별해서 results 배열에 횟수 차감시킴
	// results 배열 중 음수가 되는 값이 나오면 성립하지 않고 재귀에서 빠져나옴.
	// cnt가 15가 될때까지 다 돌았다면, 음수가 되지 않는 경우의 수가 있다는 뜻.
	private static void dfs(int cnt) {
		
		if (possible) return;
		
		if (cnt == 15) {
			possible = true;
			return;
		}
		
		int team1 = matches[cnt][0];
        int team2 = matches[cnt][1];

        // 재귀호출 이후 백트래킹을 위해 차감시킨것 다시 복구.
        // 1. 승-패
        if (results[team1][0] > 0 && results[team2][2] > 0) {
            results[team1][0]--;
            results[team2][2]--;
            dfs(cnt + 1);
            results[team1][0]++;
            results[team2][2]++;
        }

        // 2. 무승부
        if (results[team1][1] > 0 && results[team2][1] > 0) {
            results[team1][1]--;
            results[team2][1]--;
            dfs(cnt + 1);
            results[team1][1]++;
            results[team2][1]++;
        }

        // 3. 패-승
        if (results[team1][2] > 0 && results[team2][0] > 0) {
            results[team1][2]--;
            results[team2][0]--;
            dfs(cnt + 1);
            results[team1][2]++;
            results[team2][0]++;
        }
    }
}
