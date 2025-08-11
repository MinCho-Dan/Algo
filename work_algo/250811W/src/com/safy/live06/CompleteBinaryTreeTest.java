package com.safy.live06;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		int size = 10;
		
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);
		
		for (int i = 0; i < size; i++) {
			tree.add((char) (65 + i));
		}
		
		tree.bfs();
		tree.bfsWithLevel();
		tree.dfsByPreOrder();
		tree.dfsByInOrder();
		tree.dfsByPostOrder();
		
	}
	
}
