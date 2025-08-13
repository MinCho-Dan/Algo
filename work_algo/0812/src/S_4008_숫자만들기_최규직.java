import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_4008_숫자만들기_최규직 {

	private static int N, M, maxans, minans;
	private static int[] opArr; // 연산자 개수 카운팅
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine()); // TC 개수
        
        // T개의 TC 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");
            
            N = Integer.parseInt(in.readLine());
            opArr = new int[4]; // 연산자 4개
            String[] temp = in.readLine().split(" ");
            for (int i = 0; i < 4; i++) {
				opArr[i] = Integer.parseInt(temp[i]);
			} // index기준으로 (0 : +) (1 : -) (2 : *) (3 : /)
            
            maxans = Integer.MIN_VALUE;
            minans = Integer.MAX_VALUE;
            
            solve(0, 0);
            
            
            
            sb.append("\n");
            
        }
        System.out.println(sb);
	}

	private static void solve(int cnt, int value) {
		
		if (cnt == N - 1) {
			if (maxans < value) {
				maxans = value;
			}
			if (minans > value) {
				minans = value;
			}
		}
		else {
			if (opArr[0]!=0) {
				opArr[0]--;
				solve(cnt+1, value + );
			}
			
			
			
			
		}
		
		
		
	}
	
}

/*
 * 연산자 4종류가 N-1개니까, 중복순열 횟수만큼 연산해서
 * 최소값, 최대값 구하고 차이 리턴?
 */
