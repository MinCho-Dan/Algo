import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class pq {
	
	public static void main(String[] args) {
		
		
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; // 내림차순
			}
		});
		
		
		
		Queue<Person> queue2 = new PriorityQueue<>();
		
		queue2.offer(new Person(10, 1));
		queue2.offer(new Person(15, 2));
		queue2.offer(new Person(12, 3));
		
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		
	}

}
