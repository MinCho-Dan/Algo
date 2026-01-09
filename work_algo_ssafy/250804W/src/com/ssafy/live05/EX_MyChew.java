package com.ssafy.live05;

import java.util.ArrayDeque;
import java.util.Queue;

// 마지막 마이쮸를 가져간 사람: 2번
class Person {
	public int number;  // 번호
	public int requestNo;  // 마이쮸 요청개수
	
	public Person(int number, int requestNo) {
		this.number = number;
		this.requestNo = requestNo;
	}
}

public class EX_MyChew {

	public static void main(String[] args) {
		
		int N = 20;  // 마이쮸의 총 개수
		int pNumber = 1;  // 부여받을 사람 번호 (1번부터 부여)
		Person one = new Person(pNumber, 1);  // 1번 사람이 마이쮸 1개 요청
		
		Queue<Person> queue = new ArrayDeque<>();
		queue.offer(one);
		int availableCnt = 0; // 받을 수 있는 마이쮸 개수
		
		while (N > 0) {
			if (!queue.isEmpty()) {
				Person p = queue.poll();
				availableCnt = (N >= p.requestNo) ? p.requestNo : N;  // 요청개수를 줄 정도로 여유가 있다면 요청개수만큼 지급
				N -= availableCnt;  // 마이쮸 지급
				
				if (N == 0) {
					System.out.print("마지막 마이쮸를 가져간 사람: " + p.number + "번 / ");
					System.out.println("가져간 개수: " + availableCnt);
				}
				else {
					System.out.println(p.number + "번이 " + availableCnt + "개 가져갑니다. 남은 수 : " + N);
					p.requestNo++;  // 받을 마이쮸 개수 하나 증가
					queue.offer(p);  // 다시 줄 서기
					queue.offer(new Person(++pNumber, 1));  // 다음 번호를 새로운 사람에게 부여하고 줄 서기 (++pNumber 주의, pNumber++하면 안된다.)
				}
			}
		}
	}
}
