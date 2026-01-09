import java.util.Scanner;

public class BinomialCoefTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		// 1. 동적테이블
		int[][] D = new int[n+1][k+1];
		
		
		for (int i = 0; i <= n; i++) {
			int end = Math.min(i, k);
			for (int j = 0; j <= end; j++) {
				
				// 2. 베이스값 채우기
				if (j == 0 || j == i) {
					D[i][j] = 1;
				}
				// 3. 점화식
				else D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
			}
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
		
		
		// ex) 3C2를 구하고싶다.
		System.out.println("3C2 = " + D[3][2]);
		
	}

}
