package com.safy.live07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kruskal {
	
	// 1. 간선 리스트 준비
	private static class Edge implements Comparable<Edge> {
		
		public int from; // 시작 정점 번호
		public int to; // 도착 정점 번호
		public int weight; // 가중치
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;	
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight = o.weight; // 가중치 오름차순 정렬
		}	
	}
	
	private static Edge[] edgeList;
	
	// 2. 서로소 집합 준비
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
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 파일 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		
		// 간선 저장
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);			
		}
		
		// 2. 가중치 오름차순 정렬
		Arrays.sort(edgeList);
		
		// 3. 크루스칼 알고리즘 적용
		makeSet();
		
		int result = 0; // MST 비용
		int count = 0; // 연결 간선 수
		for (Edge edge : edgeList) {
			if (unionSet(edge.from, edge.to)) {
				result += edge.weight;
				
				if (++count == N - 1) {
					break;
				}
			}
		}
		
		System.out.println(result);
	}
	
	

}
