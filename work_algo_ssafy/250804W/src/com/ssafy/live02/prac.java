package com.ssafy.live02;

import java.util.Arrays;
import java.util.Scanner;

public class prac {
	
	private static int N;
	private static int R;
	private static int[] input;
	private static boolean[] isSelect;
	private static int[] numbers;
	private static int totalCnt;

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		for (int i = 0; i< N; i++) {
			input[i] = sc.nextInt();
		}
		
		numbers = new int[R];
		isSelect = new boolean[N];
		Permutation(0);
		System.out.println("순열의 총 경우의 수는" + totalCnt);
		totalCnt = 0;
		
		Permutation2(0);
		System.out.println("중복순열의 총 경우의 수는" + totalCnt);
		totalCnt = 0;
		
		Combi(0,0);
		System.out.println("조합의 총 경우의 수는" + totalCnt);
		totalCnt = 0;
		
		Combi2(0,0);
		System.out.println("중복조합의 총 경우의 수는" + totalCnt);
		
		sc.close();
		
	}


	private static void Permutation(int cnt) {
		
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
			
		for (int i = 0; i< N; i++) {
			if (isSelect[i] == true) {continue;}
			
			numbers[cnt] = input[i];
			isSelect[i] = true;
			Permutation(cnt+1);
			isSelect[i] = false;
		}

	}
	
private static void Permutation2(int cnt) {
		
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
			
		for (int i = 0; i< N; i++) {
//			if (isSelect[i] == true) {continue;}
			
			numbers[cnt] = input[i];
//			isSelect[i] = true;
			Permutation2(cnt+1);
//			isSelect[i] = false;
		}

	}

private static void Combi(int cnt, int start) {
	
	if (cnt == R) {
		System.out.println(Arrays.toString(numbers));
		totalCnt++;
		return;
	}
		
	for (int i = start; i < N; i++) {
//		if (isSelect[i] == true) {continue;}
		
		numbers[cnt] = input[i];
//		isSelect[i] = true;
		Combi(cnt+1, i+1);
//		isSelect[i] = false;
	}

}

private static void Combi2(int cnt, int start) {
	
	if (cnt == R) {
		System.out.println(Arrays.toString(numbers));
		totalCnt++;
		return;
	}
		
	for (int i = start; i < N; i++) {
//		if (isSelect[i] == true) {continue;}
		
		numbers[cnt] = input[i];
//		isSelect[i] = true;
		Combi2(cnt+1, i);
//		isSelect[i] = false;
	}

}
	
}
