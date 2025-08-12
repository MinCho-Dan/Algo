package com.safy.live06;

import java.util.ArrayDeque;
import java.util.Queue;

public class prac<T> {
	
	private final int SIZE;
	private Object nodes[];
	private int lastIndex;
	
	public prac (int size) {
		SIZE = size;
		nodes = new Object[SIZE+1];
	};
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}

	public void add(T element) {
		if (isFull()) {
			System.out.println("가득 찼습니다.");
			return;
		}
		nodes[++lastIndex] = element;
	}
	
	public void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(1);
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			System.out.print(nodes[current] + " ");
			
			if (current * 2 <= lastIndex) {
				queue.offer(current * 2);
			}
			
			if (current * 2 + 1 <= lastIndex) {
				queue.offer(current * 2 + 1);
			}
			
		}
		System.out.println();
	}
	
	public void bfsWithLevel() {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(1);
		
		int level = 0;
		while (!queue.isEmpty()) {
			System.out.print("level " + level + " : ");
			int size = queue.size();
			while (--size>=0) {
				
				int current = queue.poll();

				System.out.print(nodes[current] + " ");
				
				if (current * 2 <= lastIndex) {
					queue.offer(current * 2);
				}
				
				if (current * 2 + 1 <= lastIndex) {
					queue.offer(current * 2 + 1);
				}
			}
			System.out.println();
			++level;
		}
	}
	
	// 전위
	public void pre() {
		System.out.print("preOrder : ");
		pre(1);
		System.out.println();
	}
	private void pre(int current) {
		System.out.print(nodes[current] + " ");
		if (current * 2 <= lastIndex) {
			pre(current * 2);
		}
		if (current * 2 + 1 <= lastIndex) {
			pre(current * 2 + 1);
		}
		
	}
	
	// 중위
		public void in() {
			System.out.print("inOrder : ");
			in(1);
			System.out.println();
		}
		private void in(int current) {
			if (current * 2 <= lastIndex) {
				in(current * 2);
			}
			System.out.print(nodes[current] + " ");
			if (current * 2 + 1 <= lastIndex) {
				in(current * 2 + 1);
			}
			
		}
		
	// 후위
	public void post() {
		System.out.print("postOrder : ");
		post(1);
		System.out.println();
	}
	private void post(int current) {
		if (current * 2 <= lastIndex) {
			post(current * 2);
		}
		if (current * 2 + 1 <= lastIndex) {
			post(current * 2 + 1);
		}
		System.out.print(nodes[current] + " ");
	}	
	
}
