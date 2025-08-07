package com.ssafy.live04;

import java.util.Scanner;

// 인접행렬
public class AdjMatrixSearchTest_DFS {
	
	private static int V; // 정점개수
	private static int[][] adjMatrix; // 인접행렬
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjMatrix = new int [V][V];
		
		int from, to;
		
		for (int i = 0; i < E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			// 유향 그래프 ( 방향이 있는 경우 )
//			adjMatrix[from][to] = 1;
			
			//무향 그래프 ( 방향이 없는 경우 )
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		
		// 인접행렬 출력해보기
//		for (int i = 0; i < V; i++) {
//			for (int j = 0; j < V; j++) {
//				System.out.print(adjMatrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		dfs(0, new boolean[V]);
	}

	
	// current : 현재 방문한 정점 번호
	// visited : 정점 방문 기록
	private static void dfs(int current, boolean[] visited) {
		
		// 현재 정점 방문처리
		visited[current] = true;
		
		// 방문한 정점에서 해야할 일 작성
		System.out.print((char) (current + 65) + " ");
		
		//자신과 인접한 정점 방문
		for (int i = 0; i < V; i++) {
			if (adjMatrix[current][i] != 0  // 인접 확인
					&& !visited[i]) { // 방문여부 확인
				dfs(i, visited); // 정점 i 방문
			}
		}
	}

}
