package com.safy.live06;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		int size = 5;
		
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);
		
		for (int i = 0; i < size; i++) {
			tree.add((char) (65 + i));
		}
		
		tree.bfs();
		tree.bfsWithLevel();
		tree.dfsByPreOrder();
		tree.dfsByInOrder();
		tree.dfsByPostOrder();
		
		System.out.println("--------------------");
		int size2 = 5;
		
		prac<Character> tree2 = new prac<>(size2);
		
		for (int i = 0; i < size2; i++) {
			tree2.add((char) (65 + i));
		}
		
		tree2.bfs();
		tree2.bfsWithLevel();
		tree2.pre();
		tree2.in();
		tree2.post();
		
	}
	
}
