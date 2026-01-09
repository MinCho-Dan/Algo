/*
 * 테스트케이스
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1 
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1

==> 
9
7
*/

import java.util.Scanner;

public class EX_같은색공간만들기 {

	private static int white = 0;
	private static int green = 0;
	private static int[][] spaces;

	// 주어진 영역의 공간의 셀 체크하여 모두 초록색이나 하얀색으로 이루어져있는지 확인 후
	// 4개로 쪼개기.
	// 하얀색 0 , 초록색 1
	private static void cut(int x, int y, int size) {

		int sum = 0;

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				sum += spaces[i][j];
			}
		}

		// size가 1인 공간은 결국 초록색이나 하얀색이므로 아래 조건이 곧 size가 1인 경우의 기저조건이 됨
		// sum이 넓이와 같다면 모두 초록색이므로 그린카운트 누적하고 리턴 (더이상 쪼개지 않음. 즉, 재귀리턴)
		if (sum == size * size) {
			green++;	
		}
		// sum이 0과 같다면 모두 하얀색이므로 화이트카운트 누적하고 리턴 (더이상 쪼개지 않음. 즉, 재귀리턴)
		else if (sum == 0) {
			white++;
		}
		else {
			int newSize = size / 2;

			// 4개로 쪼개기 : 분할된 각 영역의 공간도 온전한 하나의 공간로 본다면 동일한 작업 수행해야하므로 재귀.
			cut(x, y, newSize);// 좌상
			cut(x, y + newSize, newSize); //우상
			cut(x + newSize, y, newSize); //좌하
			cut(x + newSize, y + newSize, newSize);//우하
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		spaces = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				spaces[i][j] = sc.nextInt();
			}
		}

		cut(0, 0, n);
		System.out.println(white);
		System.out.println(green);
		sc.close();
	}
}