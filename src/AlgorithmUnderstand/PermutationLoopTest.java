public class PermutationLoopTest {
	
	public static void main(String[] args) {
		
		// 순열 (반복문)
		// 3P2 = 6가지 (K for문 제외)
		// 3P3 = 6가지 (K for문 포함)
		for (int i = 1; i <=3; i++) {
			for (int j = 1; j <=3; j++) {
				if (j==i) {
					continue;
				}
				
				for (int k = 1; k <=3; k++) {
					if (j==k || i==k) {
						continue;
					}
				System.out.println(i + " " + j + " " + k);
				}
			}
		}
	}
}
