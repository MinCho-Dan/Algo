package com.ssafy.live10;

import java.util.Arrays;

public class BinarySerchTest {
	
	private static int[] values = { 3, 11, 15, 20, 21, 29, 45, 59, 65, 72 };
	
	// 반복문
	// key : 찾고자 하는 값
	private static int binarySerch(int key) {
		int start = 0; // 찾을 범위의 시작 인덱스
		int end = values.length - 1; // 찾을 범위의 끝 인덱스
		int mid = 0; // 중앙 인덱스 값
		
		while (start <= end) {
			mid = (start + end) / 2;
			
			if (values[mid] == key) return mid;
			else if (values[mid] < key) start = mid + 1;
			else end = mid - 1;
		}
//	return -1 // 못 찾은 경우는 -1 리턴	
	return (start * -1) - 1; 
	}
	
	// 재귀문
	private static int binarySerch2(int key, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			
			if (values[mid] == key) return mid;
			else if (values[mid] < key) return binarySerch2(key, mid + 1, end);
			else return binarySerch2(key, start, mid - 1);
		}
//	return -1; // 못 찾은 경우는 -1 리턴
	return (start * -1) - 1;
	}
	
	public static void main(String[] args) {
		// 1. 반드시 오름차순 정렬
		Arrays.sort(values);
		
		// 2. 찾기
		System.out.println(Arrays.toString(values));
		System.out.println("반복문 : " + binarySerch(65));
		System.out.println("반복문 : " + binarySerch(4));
		System.out.println("반복문 : " + binarySerch(80));
		System.out.println("====================");
		System.out.println("재귀문 : " +binarySerch2(65, 0, values.length - 1));
		System.out.println("재귀문 : " +binarySerch2(4, 0, values.length - 1));
		System.out.println("재귀문 : " +binarySerch2(80, 0, values.length - 1));
		System.out.println("====================");
		
		//2. 찾기 JDK 메서드 사용
		int result = Arrays.binarySearch(values, 65);
		System.out.println("JDK 메서드 : " + result);
		
		// 없는값을 입력하면?
		// ( (-1 * 삽입인덱스) -1 )값 리턴됨
		// 여기서는 원래 1번 위치가 리턴 되었어야 하니까.
		// -1-1 = -2가 리턴됨.
		result = Arrays.binarySearch(values, 4);
		System.out.println("JDK 메서드 : " + result);
		
		// 얘는 10번자리.( 맨끝)
		result = Arrays.binarySearch(values, 80);
		System.out.println("JDK 메서드 : " + result);

	}
}