package com.ssafy.live04;

import java.util.Scanner;

// 인접리스트
public class AdjListSearchTest_DFS {
	
	// 정점 class 생성
	private static class Node {
		public int vertex; // 정점 번호
		public Node link; // 다음 연결된 정점
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}
	
	private static int V; // 정점개수
	private static Node[] adjList; // 인접리스트
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[V];
		
		int from, to;
		
		for (int i = 0; i < E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
		
		// 유향 그래프
//		adjList[from] = new Node(to, adjList[from]);
		
		// 무향 그래프
		adjList[from] = new Node(to, adjList[from]);
		adjList[to] = new Node(from, adjList[to]);
		}

		
		dfs(0, new boolean[V]);
	}

	
	// current : 현재 방문한 정점 번호
	// visited : 정점 방문 기록
	// Node 객체가 있다는 것은 이미 인접하고 있다는 뜻이므로
	// 인접 여부는 확인하지 않아도 된다.
	private static void dfs(int current, boolean[] visited) {
		
		// 현재 정점 방문처리
		visited[current] = true;
		
		// 방문한 정점에서 해야할 일 작성
		// ASCII 코드를 이용해서 알파벳 출력하는걸로 예시.
		System.out.print((char) (current + 65) + " ");
		
		//자신과 인접한 정점 방문
		for (Node temp = adjList[current]; temp != null; temp = temp.link ) {
			if (!visited[temp.vertex]) {
				dfs(temp.vertex, visited); // 정점 i 방문
			}
		}
	}

}
