import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		// 힙 생성
		// 기본동작은 오름차순 정렬 (최소 힙)
		// Comparator를 이용해서 내림차순 정렬(최대 힙)
//		Queue<Integer> queue = new PriorityQueue<>();
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; // 내림차순 정렬
			}
		});
		
		queue.offer(100);
		queue.offer(120);
		queue.offer(90);
		queue.offer(200);
		
		Integer result = queue.poll();
		System.out.println(result);
		
		result = queue.poll();
		System.out.println(result);
		
		result = queue.poll();
		System.out.println(result);
		
		result = queue.poll();
		System.out.println(result);
		
		// 전체 시간 복잡도?
		// 자료 삽입 : O(logN) * N
		// 자료 정렬 : O(1) * N
		// 전체 시간 복잡도 : NlogN + N
		
		Queue<Student> queue2 = new PriorityQueue<>();
		// Student class에 들어가보면 Comparable을 통해서 정렬 해놓음.
		queue2.offer(new Student(1, 90));
		queue2.offer(new Student(2, 80));
		queue2.offer(new Student(3, 100));
		
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		
	}
}
