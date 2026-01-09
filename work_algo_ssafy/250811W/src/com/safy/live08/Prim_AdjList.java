package com.safy.live08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prim_AdjList {
	
	private static class Vertex {
		public int vertex;
		public int weight;
		public Vertex link;
		
		public Vertex(int vertex, int weight, Vertex link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
	}
	
	// 테케는 kruskal_input.txt사용, prin_input.txt처럼 행렬로주면 받기가 좀 복잡해서.
	public static void main(String[] args) throws Exception{
		// 1. 입력파일 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 정점 수
		int E = Integer.parseInt(st.nextToken()); // 간선개수
		
		Vertex[] adjList = new Vertex[N]; // 인접리스트
		int[] minEdge = new int[N]; // 다른정점에서 자신으로 연결하는 간선비용 중 최소비용
		boolean[] visited = new boolean[N];// 신장트리에 선택된 여부
		Arrays.fill(minEdge, Integer.MAX_VALUE); // 무한대 값, 충분히 큰 값으로 초기화
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Vertex(to, weight, adjList[from]);
			adjList[to] = new Vertex(from, weight, adjList[to]);
		}
	
		
		// 0단계 : 첫 방문 정점의 최소비용을 0으로 설정
		int vertexCount = 0; // 선택된 정점의 개수
		int result = 0; // MST 비용
		minEdge[0] = 0; // 처음에 0번 정점이 방문되도록 비용 0으로 설정
		
		// 모든 정점을 순회하기
		for (int cnt = 0; cnt < N; cnt++) {
			
			
			// 우선순위 큐로 가능
			// 1단계 : 신장트리의 구성에 포함되지 않은 정점 중 최소비용 정점을 선택
			int min = Integer.MAX_VALUE;
			int current = 0;
			
			for (int i=0; i < N; i++) { // i : 정점번호
				if (!visited[i] && min > minEdge[i]) { // 방문하지 않았고, 최소값이라면
					min = minEdge[i]; // 최소값 갱신
					current = i; // 최소값 정점번호를 선택
				}
			}
			
			
			
			// 선택된 정점을 방문 (신장트리에 포함)
			visited[current] = true;
			
			result += min; // 비용 누적
			
			//(선택사항) 가지치기
			if (++vertexCount == N) { // 최소신장트리가 완성되었다면
				break;
			}

			// 2단계 : 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의
			// 기존 최소비용과 비교해서 갱신
			// 신장트리에 새롭게 추가되는 정점의 모든 인접정점 들여다보며 처리
			for (Vertex temp = adjList[current]; temp != null; temp = temp.link) {
				
				// 신장트리에 포함되지 않았고, 
				// 선택된 정점과 인접한 정점이며,
				// 선택된 정점과의 비용이 이전까지의 최소비용보다 작다면
				if (!visited[temp.vertex]&&
					minEdge[temp.vertex] > temp.weight) {
					
					minEdge[temp.vertex] = temp.weight; // 최소비용으로 갱신
				}
			}			
		}
		System.out.println(result);
	}

}
