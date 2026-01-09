// 부분집합 (반복문)
public class SubSetLoopTest {

	
	public static void main(String[] args) {
		
		int N = 3; // 원소의 개수
		boolean[] isSelected = new boolean[N + 1]; // 원소번호 = 인덱스로 작성
		// 0번 인덱스는 사용하지 않는다는 뜻.
		
		for (int i = 0; i <= 1; i++) {
			isSelected[1] = (i == 1); // 원소1 비선택 / 선택
			
			for (int j = 0; j <= 1; j++){
				isSelected[2] = (j == 1); // 원소2 비선택 / 선택
				
				for (int k = 0; k <= 1; k++){
					isSelected[3] = (k == 1); // 원소3 비선택 / 선택
					
					// 부분집합 원소 출력
					for (int m = 1; m<= N; m++) {
						System.out.print((isSelected[m] ? m : "X") + " ");
					}
					System.out.println(" ");
				}
			}
		}
		
		
		
	}
}
