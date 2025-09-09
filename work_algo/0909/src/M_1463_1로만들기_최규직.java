import java.io.BufferedReader;
import java.io.InputStreamReader;

public class M_1463_1로만들기_최규직 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(in.readLine());
		
		int[] D = new int[X + 1];
		
		// 2. 베이스 값 채우기
		D[1] = 0;
		
		// 3. 점화식
		for (int i = 2; i < X + 1 ; i++) {
			
			// -1 하는 부분
			D[i] = D[i - 1] + 1;

            // 만약 i가 2로 나누어 떨어진다면,
            // (i/2)를 1로 만드는 연산 횟수 + 1과 현재 값 비교
            if (i % 2 == 0) {
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }

            // 만약 i가 3으로 나누어 떨어진다면,
            // (i/3)을 1로 만드는 연산 횟수 + 1과 현재 값 비교
            if (i % 3 == 0) {
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
		}
		
		System.out.println(D[X]);
	}
}
