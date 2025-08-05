package com.ssafy.live02;

import java.util.Arrays;
import java.util.Scanner;

/**
주사위를 던진 횟수 N과 출력형식 M을 입력 받아서 M의 값에 따라 각각 아래와 같이 출력하는 프로그램을 작성하시오.

M = 1 : 주사위를 N번 던져서 나올 수 있는 모든 경우 : 중복순열 
M = 2 : 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우(순서의미) : 순열 
M = 3 : 주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우 : 중복 조합 
M = 4 : 주사위를 N번 던져서 나온 수들의 조합(순서 무관)이 모두 다른 수가 나올 수 있는 모든 경우 : 조합 

*/

public class EX_DiceTest {

	static int N;  // 던지는 주사위 수
	static int[] numbers;  // 각각의 주사위의 눈
	static int totalCnt;  // 경우의 수
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		N = sc.nextInt();

		numbers = new int[N];

		switch (mode) {
		case 1:  // 중복순열
			dice1(0);
			break;

		case 2:  // 순열
			isSelected = new boolean[6 + 1];  // 자동 초기화 : false
			dice2(0);
			break;

		case 3:  // 중복조합
			dice3(0, 1);
			break;

		case 4:  // 조합
			dice4(0, 1);
			break;
		}

		System.out.println("총 경우의 수: " + totalCnt);
	}

	// 중복순열
	// cnt: 기존까지 던져진 주사위 수 ==> 현재 주사위의 수를 기록하기 위한 인덱스로 사용
	private static void dice1(int cnt) {

		if (cnt == N) {  // 던져진 주사위가 목표 수가 되었다면 더 이상 던질 주사위 없음
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}

		// 주사위의 눈은 1-6의 경우가 있음
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;

			// 다음 주사위 던지러 가기
			dice1(cnt + 1);
		}
	}

	// 순열
	// cnt: 기존까지 던져진 주사위 수 ==> 현재 주사위의 수를 기록하기 위한 인덱스로 사용
	private static void dice2(int cnt) {

		if (cnt == N) {  // 던져진 주사위가 목표 수가 되었다면 더 이상 던질 주사위 없음
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}

		// 주사위의 눈은 1-6의 경우가 있음
		for (int i = 1; i <= 6; i++) {

			// 중복체크
			if (isSelected[i]) {
				continue;
			}

			numbers[cnt] = i;
			isSelected[i] = true;

			// 다음 주사위 던지러 가기
			dice2(cnt + 1);

			isSelected[i] = false;
		}
	}

	// 중복조합
	// cnt: 기존까지 던져진 주사위 수
	// start: 현 주사위의 눈의 시작
	private static void dice3(int cnt, int start) {

		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}

		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt + 1, i);  // i + 1을 i로 넘기면 이전에 선택된 주사위 눈부터 시작 (중복허용)
		}
	}

	// 조합
	// cnt: 기존까지 던져진 주사위 수
	// start: 현 주사위의 눈의 시작
	private static void dice4(int cnt, int start) {

		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}

		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}

}

