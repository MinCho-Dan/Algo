import java.util.Scanner;

public class KnapsackTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 아이템 개수
		int W = sc.nextInt(); // 가방에 담을 수 있는 무게
		
		int[] weights = new int[N + 1]; // 무게 배열
		int[] profits = new int[N + 1]; // 가치 배열
		
		for (int i = 1; i < N + 1; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		// 1.  동적테이블
		// 행 인덱스 : 현재까지 고려한 물건들 개수
		// 열 인덱스 : 현재 배낭 무게
		// 값 : 현재까지 고려한 물건들을 현재 배낭 무게에 넣었을 때의 최대 가치
		int[][] D = new int[N + 1][W + 1];
		
		// 2. 베이스 값
		
		
		// 3. 점화식
		int itemWeight = 0, itemBenefit = 0;
		for (int item = 1; item <= N; item++ ) {
			itemWeight = weights[item]; // 현 아이템 무게
			itemBenefit = profits[item];
			
			for (int weight = 1; weight <= W; weight++) {
				if (itemWeight <= weight) {
					D[item][weight] = Math.max(D[item - 1][weight], itemBenefit + D[item - 1][weight - itemWeight]);
				}
				else {
					D[item][weight] = D[item - 1][weight];
				}
			}
		}
		
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(D[N][W]);
	}
}
