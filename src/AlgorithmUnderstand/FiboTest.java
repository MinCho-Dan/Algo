import java.util.Scanner;

public class FiboTest {
	
	private static int fibo (int n) {
		
		// 기저 조건
		if (n == 0 || n == 1) {
			return n;
		}
		
		// 유도 조건
			return fibo(n-1) + fibo(n-2);
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibo(n));
	}
}


// 재귀의 단점 : 동일한 계산을 반복한다.
// 반복을 하지 않기 위해 메모를한다.(memorization)
// 메모 대신 쓰려면? DP -> A형엔 안나옴.
