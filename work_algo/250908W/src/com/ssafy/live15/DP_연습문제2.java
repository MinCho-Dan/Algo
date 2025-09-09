package com.ssafy.live15;

import java.util.Scanner;

public class DP_연습문제2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 1. 동적 테이블 작성
		// D[N][0] = 맨 위층을 노란색으로 칠할 때 경우의 수
		// D[N][1] = 맨 위층을 파란색으로 칠할 때 경우의 수
		int[] D = new int[N + 1];
		
		// 2. 베이스 값 채우기
		D[0] = 1;
		D[1] = 2;
		
		// 3. 점화식
		for (int i = 2; i < N + 1 ; i++) {
			D[i] = 2 * D[i - 1] + D[i - 2]; 
		}
		
		
		System.out.println(D[N]);
	}

}
