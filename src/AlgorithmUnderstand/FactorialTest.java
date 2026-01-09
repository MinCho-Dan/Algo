public class FactorialTest {
	
	// 반복문 사용한 함수
	private static int factorial1(int n) {
		int result = 1;
		for (int i = n; i > 0; i--) {
			result *= i;
		}
		
	return result;
	}
	
	// 재귀함수
	private static int factorial2(int n) {
		// 기저 부분
		if (n == 1) {return 1;}
		// 유도 부분
		return (n * factorial2(n-1));
	}
	
	
	public static void main(String[] args) {
		// 반복문을 이용한 팩토리얼 함수
		int result1 = factorial1(5);
		System.out.println(result1);
		
		// 재귀를 이용한 팩토리얼 함수
		int result2 = factorial2(5);
		System.out.println(result2);
	}
	
}