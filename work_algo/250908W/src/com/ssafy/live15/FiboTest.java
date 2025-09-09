package com.ssafy.live15;

import java.util.Arrays;
import java.util.Scanner;

public class FiboTest {
	
	private static long callCnt;
    
    // 재귀 함수
    private static long fibo(int n) {
    	
    	callCnt++;
    	
        // 기저조건
        if (n == 0 || n == 1) {
            return n;
        }
        
        // 유도조건
        return fibo(n - 1) + fibo(n - 2);
    }
    
    
    private static long[] memo; // -1로 초기화할 예정
    // 재귀 함수 - 메모이제이션 적용
    private static long fiboMemo(int n) {
    	
    	callCnt++;
    	
        // 기저조건
        if (n == 0 || n == 1) {
            return n;
        }
        
        // 유도조건
        if (memo[n] == -1) {
        	memo[n] = fiboMemo(n - 1) + fiboMemo(n -2);
        }
        
        return memo[n];
    }
    
    // DP 버전
    private static long fiboDP(int n) {
    	
    	
    	
    	// 1. 동적테이블 생성 ( 인덱스 번호, 값의 의미를 정확하게 사용)
    	// 인덱스 번호 : n항, 값 : n항의 결과 값
    	long[] D = new long[n + 1];
    	
    	// 2. 베이스 값 채우기 (재귀버전 기저부분)
    	D[0] = 0;
    	D[1] = 1;
    	D[2] = 1;
    	D[3] = 2;
    	
    	// 3. 점화식을 이용해서 상향식으로 동적테이블 채우기
    	for (int i = 4; i < n + 1; i++) {
			D[i] = D[i - 2] +  D[i - 1];
			callCnt++;
		}
    	
    	return D[n];
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
        System.out.println("재귀호출 횟수 : " + callCnt);
        
        memo = new long[n + 1];
        Arrays.fill(memo, -1);
        callCnt = 0;
        System.out.println(fiboMemo(n));
        System.out.println("메모이제이션 횟수 : " + callCnt);
        
        callCnt = 0;
        System.out.println(fiboDP(n));
        System.out.println("DP버전 호출 횟수 : " + callCnt);
        
    }

}