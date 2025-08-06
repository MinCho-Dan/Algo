package com.ssafy.live03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubSetInputTest {
	
	private static int N;
	private static int totalCnt;
	private static int[] input;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		input = new int[N];
		isSelected = new boolean[N];
		
		String[] split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(split[i]);
		}
		
		generateSubSet(0);
		
		System.out.println("총 경우의 수는 \"" + totalCnt + "\" 입니다.");
	}

	// cnt = 선택한 원소의 개수.
	private static void generateSubSet(int cnt) {
		
		//기저 부분
		if (cnt == N) { // 모든 원소를 고려한 경우
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i] ? input[i] : "X") + " ");
			}
			System.out.println();
			
			totalCnt++;
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

}
