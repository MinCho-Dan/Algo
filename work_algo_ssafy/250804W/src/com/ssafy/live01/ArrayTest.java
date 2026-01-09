package com.ssafy.live01;

public class ArrayTest {
	
	private static int[] arr = { 10, 20, 30 };
	
	
	// 반복문
	private static void printArray1() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	
	// 재귀 함수
	private static void printArray2(int index) {
		
		// 기저부분 (2. 반복문의 반복조건)
		if (index >= arr.length) {
			return ;
		}
		// 유도부분
		System.out.print(arr[index] + "\t"); // 4. for문의 반복 Body
		printArray2(index + 1); // 3. 증감식
		
	}
	
	
	public static void main(String[] args) {
		printArray1();
		printArray2(0); // 1. index 초기값
	}
}

