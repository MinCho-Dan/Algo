package com.ssafy.live03;

import java.util.Stack;

public class PostExpressionTest {

	public static void main(String[] args) {

		String expression = "6528-*2/+";  // 제약조건: 숫자는 한자리만
		System.out.println(expression);

		// 후위표기식 계산하는 방법
		// 1. 피연산자를 만나면 스택에 push
		// 2. 연산자를 만나면 스택에 있는 피연산자 2개를 pop 한다.
		// 3. 2번에서 꺼낸 피연산자를 꺼낸 역순으로 계산
		// 4. 계산한 결과는 다시 스택에 push 한다.
		Stack<Integer> stack = new Stack<>();

		int op = 0;
		int size = expression.length();

		for (int i = 0; i < size; i++) {
			char temp = expression.charAt(i);

			op = temp - '0';  // char형을 int형으로 변환
			if (0 <= op && op <= 9) {  // 피연산자이면
				stack.push(op);  // 스택에 push
			}
			else {  // 연산자일 경우
				// 2. 피연산자 2개를 pop해서 가져옴
				int value2 = stack.pop();
				int value1 = stack.pop();

				// 3. 2번에서 꺼낸 피연산자를 꺼낸 역순으로 계산
				switch (temp) {
				case '+':
					stack.push(value1 + value2);  // 4. 계산결과를 다시 Push
					break;

				case '-':
					stack.push(value1 - value2);  // 4. 계산결과를 다시 Push
					break;

				case '*':
					stack.push(value1 * value2);  // 4. 계산결과를 다시 Push
					break;

				case '/':
					stack.push(value1 / value2);  // 4. 계산결과를 다시 Push
					break;

				}
			}

		}

		if (!stack.isEmpty()) {
			System.out.println(stack.pop());  // 계산 결과 출력
		}
	}
}
