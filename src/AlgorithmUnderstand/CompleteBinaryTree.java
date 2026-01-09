import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<T> {
	
	private Object[] nodes; // 트리에 저장되는 노드 (정점)
	private final int SIZE; // 노드(정점)의 개수
	private int lastIndex; // 정점 배열의 마지막 인덱스 번호 (현재 정점 개수)
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new Object[size + 1]; // 0번 인덱스 사용 안함
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	// element : 정점
	public void add(T element) {
		if (isFull()) {
			System.out.println("포화 상태 입니다.");
			return;
		}
		
		nodes[++lastIndex] = element;
	}
	
	public void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(1); // 트리는 항상 출발점이 1번정점으로 고정되어있음
		// 방문처리는 안해도 됨 : 시작점이 고정이고, 상하관계로 방문하기 때문에
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			// 방문 후 해야할 일 처리
			System.out.print(nodes[current] + " ");
		
			// 현재 노드의 자식 노드들의 인덱스를 다음 순서가 되었을 때 탐색하도록 큐에 넣기
			// 왼쪽 자식 노드
			if (current * 2 <= lastIndex) {
				queue.offer(current *2);
			}
			
			// 오른쪽 자식 노드
			if (current * 2 + 1 <= lastIndex) {
				queue.offer(current * 2 + 1);
			}
		
		}
		
		System.out.println();
	}
	
	public void bfsWithLevel() {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(1); // 트리는 항상 출발점이 1번정점으로 고정되어있음
		// 방문처리는 안해도 됨 : 시작점이 고정이고, 상하관계로 방문하기 때문에
		
		int level = 0;
		while(!queue.isEmpty()) {
			System.out.print("level : " + level + " : ");
			int size = queue.size();
			while (--size >=0) {
			
			
				int current = queue.poll();
				
				// 방문 후 해야할 일 처리
				System.out.print(nodes[current] + " ");
			
				// 현재 노드의 자식 노드들의 인덱스를 다음 순서가 되었을 때 탐색하도록 큐에 넣기
				// 왼쪽 자식 노드
				if (current * 2 <= lastIndex) {
					queue.offer(current *2);
				}
				
				// 오른쪽 자식 노드
				if (current * 2 + 1 <= lastIndex) {
					queue.offer(current * 2 + 1);
				}
			}
		
			System.out.println();
			++level;
		}
	}
	
	// 전위 순회
	public void dfsByPreOrder() {
		System.out.print("PreOrder : ");
		dfsByPreOrder(1); // 트리라서 1번정점부터.
		System.out.println();
		
	}

	// current : 정점번호
	private void dfsByPreOrder(int current) {
		
		// 부모가 해야 할일 처리
		System.out.print(nodes[current] + " ");
		
		// 좌측 자식 노드 처리
		if (current * 2 <= lastIndex) {
			dfsByPreOrder(current * 2);
		}
		
		// 우측 자식 노드 처리
		if (current * 2 + 1 <= lastIndex) {
			dfsByPreOrder(current * 2 + 1);
		}
		
	}
	
	// 중위 순회
	public void dfsByInOrder() {
		System.out.print("InOrder : ");
		dfsByInOrder(1); // 트리라서 1번정점부터.
		System.out.println();
		
	}

	// current : 정점번호
	private void dfsByInOrder(int current) {
		
		// 좌측 자식 노드 처리
		if (current * 2 <= lastIndex) {
			dfsByInOrder(current * 2);
		}
		
		// 부모가 해야 할일 처리
		System.out.print(nodes[current] + " ");
		
		// 우측 자식 노드 처리
		if (current * 2 + 1 <= lastIndex) {
			dfsByInOrder(current * 2 + 1);
		}
		
	}
	
	// 후위 순회
		public void dfsByPostOrder() {
			System.out.print("PostOrder : ");
			dfsByPostOrder(1); // 트리라서 1번정점부터.
			System.out.println();
			
		}

		// current : 정점번호
		private void dfsByPostOrder(int current) {
			
			// 좌측 자식 노드 처리
			if (current * 2 <= lastIndex) {
				dfsByPostOrder(current * 2);
			}

			
			// 우측 자식 노드 처리
			if (current * 2 + 1 <= lastIndex) {
				dfsByPostOrder(current * 2 + 1);
			}
			
			// 부모가 해야 할일 처리
			System.out.print(nodes[current] + " ");
			
		}
	
}
