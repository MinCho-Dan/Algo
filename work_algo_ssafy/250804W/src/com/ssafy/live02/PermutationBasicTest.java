package com.ssafy.live02;

import java.util.Arrays;

public class PermutationBasicTest {
	
	private static int N = 3; // 총 원소의 개수
	private static int R = 3; // 뽑을 원소의 개수
	private static boolean[] isSelected; // 원소가 뽑힌 것을 체크하는 배열
	private static int[] numbers; // 뽑힌 하나의 경우
	private static int totalCnt; // 전체 경우의 수
	
	
	public static void main(String[] args) {
		
		// 순열 (재귀함수)
		// nPr
		numbers = new int[R];
		isSelected = new boolean[N + 1]; // +1? = 원소 숫자 1번이 1 (0사용X)
		Permutation(0);
		System.out.println("총 경우의 수는 \"" + totalCnt + "\" 입니다.");
		
	}

	// cnt : 현재까지 뽑은 원소의 수
	private static void Permutation(int cnt) {
		
		// 기저부분
		if (cnt == R) {
			// 하나의 경우의 수에 대한 로직 처리
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		
		// 유도부분
		for (int i = 1; i <= N; i++) { // i : 원소, 가능한 모든 수 시도
			// 원소 선택여부 확인
			if (isSelected[i]) {
				continue;
			}
			
			numbers[cnt] = i; // numbers 배열에 원소 뽑아 넣기
			isSelected[i] = true; // 뽑았다고 체크
			Permutation(cnt + 1); // 다음 숫자 뽑으로 가기 (재귀)
			isSelected[i] = false; // 리턴하고 돌아 왔을 때 뽑지 않은 상태로 되돌림
		}
	}

}
