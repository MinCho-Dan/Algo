import java.util.Arrays;
import java.util.Scanner;

// 조합 (재귀함수)
public class CombinationInputTest {

	private static int N;
	private static int R;
	private static int[] numbers;
	private static int totalCnt;
	
	private static int[] input;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		combination(0, 0);
		System.out.println("총 경우의 수는 \"" + totalCnt + "\" 입니다.");
		sc.close();
	}
	
	
	// cnt : 직전까지 뽑은 조합에 포함된 원소 개수
	// start : 뽑을 원소의 인덱스 시작 번호
	private static void combination(int cnt, int start) {
		
		// 기저부분
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		
		//유도부분
		for (int i = start; i < N; i++) {
			
			//원소 뽑기
			numbers[cnt] = input[i];
			
			// 다음 원소 뽑으러 가기
			combination(cnt +1, i + 1);
		}
		
	}

	
}
