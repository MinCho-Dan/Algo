import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_27434 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		BigInteger res = BigInteger.ONE;
		for (int i = 2; i < N + 1; i++) {
			res = res.multiply(BigInteger.valueOf(i));
		}
		System.out.println(res);
	}
}

// 이 문제는 그냥 pypy로 풀어야함...
// JAVA로 하려면 분할정복 해야함.

//# 가장 간단한 반복문 코드
//import sys
//
//# 빠른 입력을 위해 sys.stdin.readline 사용
//N = int(sys.stdin.readline())
//
//result = 1
//# 1부터 N까지 순차적으로 곱합니다.
//for i in range(1, N + 1):
//    result *= i
//
//print(result)