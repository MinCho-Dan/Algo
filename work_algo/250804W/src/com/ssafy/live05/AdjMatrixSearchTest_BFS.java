package com.ssafy.live05;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// 인접행렬
public class AdjMatrixSearchTest_BFS {
	
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
		
		bfs(0);
	}

	// start : 탐색을 시작하는 정점의 번호
	// BFS에서는 방문예약을 한다 -> 방문처리를 미리한다. 세트로 외워둘것.
	private static void bfs(int start) {
		
		Queue<Integer> queue = new ArrayDeque<>(); // 큐 선언
		boolean[] visited = new boolean[V]; // 방문체크용 배열
		
		// 첫번째 정점 방문 예약
		queue.offer(start); 
		visited[start] = true; // 방문 예약시 방문처리
		
		int current = start; // current를 시작 정점으로 초기화.
		while (!queue.isEmpty()) {
			
			// 방문예약 한 것 중 맨 앞에 있는 정점
			current = queue.poll();
			
			// 방문한 정점에서 해야할 일 처리 -> 예시는 알파벳 출력.
			System.out.print((char) (current + 65) + " ");
			
			// for문을 이용해서 0번 정점부터 V-1번 정점까지 탐색
			for (int i = 0; i < V; i++) {
				if (adjMatrix[current][i] != 0 && // 인접여부 확인
						!visited[i]) { // 방문여부 체크
					
					// 다음 정점을 방문예약.
					queue.offer(i);
					visited[i] = true; // 첫정점과 마찬가지로 방문예약시 방문처리
				}
			}
		}
		
	}

}
