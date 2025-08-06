package com.ssafy.live03;

import java.io.BufferedReader;

/*
 * 5 0
 * -7 -3 -2 5 8
 * 
 * 원소가 자연수일 경우?
 * 5 21
 * 5 6 10 11 16 (정렬된 상태)
 */
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSetSumTest {

	private static int N;
	private static int totalCnt;
	private static int[] input;
	private static boolean[] isSelected;
	
	private static int S; // 우리가 원하는 부분집합의 총합
	
	private static int callCnt; // 재귀 호출 횟수
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
//		String[] split = in.readLine().split(" ");
//		N = Integer.parseInt(split[0]);
//		S = Integer.parseInt(split[1]);
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		isSelected = new boolean[N];
		
		String[] split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(split[i]);
		}
		
		generateSubSet(0);
		System.out.println("generateSubSet의 호출횟수는 : " + callCnt);
		System.out.println("총 경우의 수는 \"" + totalCnt + "\" 입니다.");
		callCnt = 0;
		totalCnt = 0;
		
		generateSubSet2(0, 0);
		System.out.println("generateSubSet2의 호출횟수는 : " + callCnt);
		System.out.println("총 경우의 수는 \"" + totalCnt + "\" 입니다.");
		callCnt = 0;
		totalCnt = 0;
		
		generateSubSet3(0, 0);
		System.out.println("generateSubSet3의 호출횟수는 : " + callCnt);
		System.out.println("총 경우의 수는 \"" + totalCnt + "\" 입니다.");
	}

	// cnt = 선택한 원소의 개수.
	private static void generateSubSet(int cnt) {
		callCnt++;
		
		//기저 부분
		if (cnt == N) { // 모든 원소를 고려한 경우
			
			int sum = 0;
			
			// 구한 부분집합의 총합
			for (int i = 0; i < N; i++) {
				
				if (isSelected[i]) {
					sum += input[i];
				}
			}
			
			// 목표로 하는 부분집합과 같은지 비교
			if (sum == S) {
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						System.out.print(input[i] + " ");
					}
				}
				System.out.println();
				totalCnt++;
			}
			return;
		}	
		
		// 유도 부분
		// 현재원소를 부분집합에 포함
		isSelected[cnt] = true; 
		generateSubSet(cnt + 1);
		
		// 현재원소를 부분집합에 미포함
		isSelected[cnt] = false;
		generateSubSet(cnt + 1);
	}
	
	// cnt = 선택한 원소의 개수.
	// sum = 직전까지 선택된 원소들의 누적 합
	private static void generateSubSet2(int cnt, int sum) {
		callCnt++;
		
		//기저 부분
		if (cnt == N) { // 모든 원소를 고려한 경우
			
			// 목표로 하는 부분집합과 같은지 비교
			if (sum == S) {
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						System.out.print(input[i] + " ");
					}
				}
				System.out.println();
				totalCnt++;
			}
			return;
		}	
		
		// 유도 부분
		// 현재원소를 부분집합에 포함
		isSelected[cnt] = true; 
		generateSubSet2(cnt + 1, sum + input[cnt]);
		
		// 현재원소를 부분집합에 미포함
		isSelected[cnt] = false;
		generateSubSet2(cnt + 1, sum);
	}
	
	// 모든원소가 자연수, 오름차순 정렬된 상태에서만 동작하는 코드.
	// cnt = 선택한 원소의 개수.
	// sum = 직전까지 선택된 원소들의 누적 합
	private static void generateSubSet3(int cnt, int sum) {
		callCnt++;
		
		// 가지치기 (백트래킹)
		if (sum > S) { return; }
		
		//기저 부분
		if (cnt == N) { // 모든 원소를 고려한 경우
			
			// 목표로 하는 부분집합과 같은지 비교
			if (sum == S) {
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						System.out.print(input[i] + " ");
					}
				}
				System.out.println();
				totalCnt++;
			}
			return;
		}	
		
		// 유도 부분
		// 현재원소를 부분집합에 포함
		isSelected[cnt] = true; 
		generateSubSet3(cnt + 1, sum + input[cnt]);
		
		// 현재원소를 부분집합에 미포함
		isSelected[cnt] = false;
		generateSubSet3(cnt + 1, sum);
	}

}
