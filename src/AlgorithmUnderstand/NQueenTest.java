import java.util.Scanner;

public class NQueenTest {
	static int N, answer;
	static int[] col;
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		
		col = new int[N + 1];
		
		setQueen(1);
		System.out.println(answer);
	}

	private static void setQueen(int rowNo) {
		if (rowNo > N) {
			answer++;
			return;
		}
		
		for (int j = 0; j < N; j++) {
			col[rowNo] = j;
			if (checking(rowNo)) {
			setQueen(rowNo + 1);
			}
		}
		
	}

	private static boolean checking(int rowNo) {
		
		for (int k = 1; k < rowNo; k++) { // 이전 퀸 순회
			if (col[rowNo] == col[k] || // 같은 열에 퀸이 있는지
					Math.abs(col[rowNo] - col[k]) == rowNo - k) { // 대각선에 퀸이 있는지
				return false;
			}
		}
		
		return true;
	}

}
	