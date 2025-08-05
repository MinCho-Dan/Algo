package com.ssafy.live02;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationInputTest {
	
	private static int N; // 총 원소의 개수
	private static int R; // 뽑을 원소의 개수
	private static boolean[] isSelected; // 원소가 뽑힌 것을 체크하는 배열
	private static int[] numbers; // 뽑힌 하나의 경우
	private static int totalCnt; // 전체 경우의 수
	
	private static int[] input; // 입력받은 원소들
	
	
	// 메인함수 : 입력받고, Permutation 함수 실행
	public static void main(String[] args) {
		
		// 순열 (재귀함수, 입력)
		// nPr
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		for (int i =0; i< N; i++) {
			input[i] = sc.nextInt();
		} 
		
		numbers = new int[R];
		isSelected = new boolean[N]; // 인덱스 번호는 원소번호와 다름.
		Permutation(0);
		System.out.println("총 경우의 수는 \"" + totalCnt + "\" 입니다.");
		sc.close();
	}

	// Permutation함수. 재귀함수임. 기저부분, 유도부분 개념과 작동되는 원리 이해 필요.
	// cnt : 현재까지 뽑은 원소의 수
	private static void Permutation(int cnt) {
		
		// 기저부분
		if (cnt == R) {
			// 경우의 수 한가지에 대한 로직 처리
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		
		// 유도부분
		for (int i = 0; i < N; i++) { // i : 원소, 가능한 모든 수 시도
			// 원소 선택여부 확인
			if (isSelected[i]) {
				continue;
			}
			
			numbers[cnt] = input[i]; // numbers 배열에 원소 뽑아 넣기
			isSelected[i] = true; // 뽑았다고 체크
			Permutation(cnt + 1); // 다음 숫자 뽑으로 가기 (재귀)
			isSelected[i] = false; // 리턴하고 돌아 왔을 때 뽑지 않은 상태로 되돌림
		}
	}

}
