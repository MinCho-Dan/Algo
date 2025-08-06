package com.ssafy.live03;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAPITest {
	
	public static void main(String[] args) {
		
//		Stack<String> stack = new Stack<>();
		Deque<String> stack = new ArrayDeque<>(); // 스택보다 고성능
		// 큐의 일종. 입구 둘 중 한쪽을 막으면 스택처럼 사용 가능.
		System.out.println("크기: " + stack.size() + " / " + "비어있는가? " + stack.isEmpty());
		
		stack.push("홍길동");
		stack.push("임꺽정");
		stack.push("이몽룡");
		stack.push("신사임당");
		
		System.out.println("크기: " + stack.size() + " / " + "비어있는가? " + stack.isEmpty());
		
		String name = stack.pop();
		System.out.println(name);
		
		stack.pop();
		name = stack.peek();
		System.out.println("peek " + name);
		stack.pop();
		name = stack.pop();
		System.out.println(name);
		
		if (!stack.isEmpty()) { // 예외처리.try-catch로 처리 해도 됨.
			stack.pop();  // EmptyStackException -> UnCheckedException
		} // exception을 쓰는거보다 if문으로 방지하는게 더 좋음
		
		// 교재에 없는 내용 (Push 사용하자! add는 Vector의 메서드 이므로)
		// Thread를 사용하는거라 속도가 느림.
		stack.add("심청이");
		stack.add("이황");
		stack.add("세종대왕");
		
		System.out.println("크기: " + stack.size() + " / " + "비어있는가? " + stack.isEmpty());
		
	}

}