package com.safy.live08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prim_AdjMatrix_PQ {
	
	private static class Vertex implements Comparable<Vertex>{
		
		public int no;
		public int weight;
		
		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight; // 비용기준 오름차순 정렬
		}

		@Override
		public String toString() {
			return "Vertex [no=" + no + ", weight=" + weight + "]";
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		// 1. 입력파일 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 정점 수
		
		int[][] adjMatrix = new int[N][N]; // 인접행렬
		int[] minEdge = new int[N]; // 다른정점에서 자신으로 연결하는 간선비용 중 최소비용
		boolean[] visited = new boolean[N];// 신장트리에 선택된 여부
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < visited.length; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken()); // 인접행렬 값 입력
			}
			minEdge[i] = Integer.MAX_VALUE; // 무한대 값, 충분히 큰 값으로 초기화
		}
		
		// 0단계 : 첫 방문 정점의 최소비용을 0으로 설정
		int vertexCount = 0; // 선택된 정점의 개수
		int result = 0; // MST 비용
		minEdge[0] = 0; // 처음에 0번 정점이 방문되도록 비용 0으로 설정
		
		
		// 우선순위 Que(힙) 이용해보기
		Queue<Vertex> pQueue = new PriorityQueue<>();
		pQueue.offer(new Vertex(0, 0));		
		
		// 모든 정점을 순회하기
		while (!pQueue.isEmpty()) {
			
			// 1단계 : 신장트리의 구성에 포함되지 않은 정점 중 최소비용 정점을 선택
			
			Vertex current = pQueue.poll(); // 최소비용 정점 선택
			if (visited[current.no]) { // MST에 포함된 정점 패스
				continue; // 패스해서 사이클 발생 예방
			}
			
			// 선택된 정점을 방문 (신장트리에 포함)
			visited[current.no] = true;
			
			result += current.weight; // 비용 누적
			
			//(선택사항) 가지치기
			if (++vertexCount == N) { // 최소신장트리가 완성되었다면
				break;
			}

			// 2단계 : 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의
			// 기존 최소비용과 비교해서 갱신
			// 신장트리에 새롭게 추가되는 정점의 모든 인접정점 들여다보며 처리
			for (int i = 0; i < N; i++) {
				
				// 신장트리에 포함되지 않았고, 
				// 선택된 정점과 인접한 정점이며,
				// 선택된 정점과의 비용이 이전까지의 최소비용보다 작다면
				if (!visited[i]&&
					adjMatrix[current.no][i] != 0 &&
					minEdge[i] > adjMatrix[current.no][i]) {
					
					minEdge[i] = adjMatrix[current.no][i]; // 최소비용으로 갱신
					pQueue.offer(new Vertex(i, adjMatrix[current.no][i]));
				}
			}			
		}
		System.out.println(result);
	}

}
