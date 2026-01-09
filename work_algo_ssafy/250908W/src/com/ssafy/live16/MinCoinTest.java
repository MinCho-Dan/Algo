package com.ssafy.live16;

import java.util.Scanner;

public class MinCoinTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		
		// 1. 동적 테이블 작성
		// 인덱스 번호 : 거슬러야 할 돈
		// 값 : 거슬러 줘야하는 최소 동전 개수
		int[] D = new int[money + 1];
		
		// 2. 베이스 값 채우기
		D[0] = 0;
		
		// 3. 점화식
		for (int i = 2; i < money + 1 ; i++) {
			
			int min = Integer.MAX_VALUE;
			
			// 현재 금액 i가 1보다 커야 1원을 거슬러 줄 수 있고
			// 1원을 제외하고 남은 금액에 대한 최소 동전 개수 + 1원짜리 1개 
			if (i >= 1 && D[i - 1] + 1 < min) min = D[i - 1] + 1;
			
			// 현재 금액 i가 1보다 커야 1원을 거슬러 줄 수 있고
			// 1원을 제외하고 남은 금액에 대한 최소 동전 개수 + 1원짜리 1개 
			if (i >= 4 && D[i - 4] + 1 < min) min = D[i - 4] + 1;
			
			// 현재 금액 i가 1보다 커야 1원을 거슬러 줄 수 있고
			// 1원을 제외하고 남은 금액에 대한 최소 동전 개수 + 1원짜리 1개 
			if (i >= 6 && D[i - 6] + 1 < min) min = D[i - 6] + 1;
			
			D[i] = min;
		}
		
		System.out.println(money+"원을 거슬러 주는 최소 동전 개수 : " + D[money]);
	}

}