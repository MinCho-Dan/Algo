package com.safy.live07;

import java.util.Arrays;

public class DisjoinSetTest {
	
	private static int N; // 원소의 개수
	private static int[] parents; // 대표자 (인덱스 번호는 원소, 값은 대표자 원소 번호)
	
	
	private static void makeSet() {
		
		parents = new int[N]; // 원소 번호는 0부터 출발
		
		// 각 원소가 집합의 대표자로 설정
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	
	// a 원소의 집합을 찾기 (a의 대표자 찾기)
	private static int findSet(int a) {
		
		// 기저부분 : a가 대표면 대표자라고 리턴
		if (parents[a] == a) {
			return a;
		}
		
		// 유도부분 : a가 대표가 아니면 대표자 찾으러 가기
//		return findSet(parents[a]); // 편향되는 depth가 깊은 그래프가 생김
		return parents[a] = findSet(parents[a]); // 경로 압축!
	}
	
	
	// a, b 두 집합 합치기
	private static boolean unionSet(int a, int b) {
		
		int aRoot = findSet(a); // a의 대표자 찾기
		int bRoot = findSet(b); // b의 대표자 찾기
		// 대표자가 같다면 이미 같은 집합. false 리턴.
		if (aRoot == bRoot) { 
			return false;
		}
		
		// 대표자가 다르면 하나의 집합으로 합치기
		// a의 대표자 집합으로 b 대표자 집합이 들어가는 방식
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		
		N = 5;
		
		// 1. 집합 생성
		makeSet();
		System.out.println(Arrays.toString(parents));
		
		// 2. 0번 원소와 1번 원소 합치기
		System.out.println(unionSet(0, 1));
		System.out.println(Arrays.toString(parents));
		
		System.out.println(unionSet(2, 1));
		System.out.println(Arrays.toString(parents));
		
		System.out.println(unionSet(3, 2));
		System.out.println(Arrays.toString(parents));
		
		System.out.println(unionSet(4, 3));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("========== findSet ==========");
		
		// 3. 경로 압축을 위해 findSet 호출
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
		
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		
		
	}
	
}
