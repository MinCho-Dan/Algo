package com.ssafy.live10;

import java.util.Scanner;

public class SquareNumberDivideTest {
	
	private static int callCnt1, callCnt2;

	// 1. 단숨 재귀함수
	// x : 밑수
	// n : 지수
	// 시간복잡도 O(N)
	private static long exp1(long x, long n) {
		callCnt1++;
		
		if (n == 1) {
			return x;
		}
		
		return x * exp1(x, n-1);
	}
	
	// 2. 분할정복
	// 시간복잡도 O(log N)
	private static long exp2(long x, long n) {
		callCnt2++;
		
		if (n == 1) {
			return x;
		}
		
		long y = exp2(x, n / 2); // (n/2)를 통해 분할정복 적용
		
//		return y * y; // 짝수일 때
//		return y * y * x; // 홀수일 때
		
		return n % 2 == 0 ? y * y : y * y * x;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt(); // 밑수
		int n = sc.nextInt(); // 지수
		
		System.out.println("exp1 결과 :" + exp1(x, n));
		System.out.println("exp1 호출 횟수 : " + callCnt1);
		System.out.println("====================");
		System.out.println("exp2 결과 :" + exp2(x,n));
		System.out.println("exp2 호출 횟수 : " + callCnt2);
	}

}
