package com.ssafy.live05;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueAPITest {
	
	public static void main(String[] args) {
		
//		Queue<String> queue = new LinkedList<>();
		Queue<String> queue = new ArrayDeque<>(); // 고성능
		System.out.println("크기: " + queue.size() + " / " + "비어있는가? " + queue.isEmpty());
		
		// offer = 입, poll = 출
		queue.offer("홍길동");
		queue.offer("임꺽정");
		queue.offer("이몽룡");
		queue.offer("신사임당");
		
		System.out.println("크기: " + queue.size() + " / " + "비어있는가? " + queue.isEmpty());
		
		String name = queue.poll();
		System.out.println(name);
		
		queue.poll();
		name = queue.peek();
		System.out.println(name);
		queue.poll();
		name = queue.poll();
		System.out.println(name);
		
		if (!queue.isEmpty()) {
			System.out.println(queue.poll());  // 비어있다면 null 값 리턴,스택은 Exception 발생함.
		}
		
		if (!queue.isEmpty()) {
			queue.remove();  // 큐가 비어있을 경우 NoSuchElementException 발생, 여기서는 if구문으로 사전방지
		} 
		
		// 교재에 없는 내용 (offer 사용하자! Vector메서드라서 add는 비추천)		
		queue.add("심청이");
		queue.add("이황");
		queue.add("세종대왕");
		
		System.out.println("크기: " + queue.size() + " / " + "비어있는가? " + queue.isEmpty());
		
	}

}




























