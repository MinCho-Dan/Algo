package com.ssafy.live02;

public class CombinationLoopTest {
	
	// 조합 (반복문)
	// 4C2 = 6가지
	public static void main(String[] args) {
		
		for (int i = 1; i <= 4; i++) {
			for (int j = i + 1; j <= 4; j++) {
				System.out.println(i + " " + j);
			}
		}
	}

}
