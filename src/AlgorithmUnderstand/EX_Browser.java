import java.util.Scanner;
import java.util.Stack;

/*
V http://www.google.com
V http://www.naver.com
B
V http://edu.ssafy.com
F
B
F
B
B
B
Q
 */
public class EX_Browser {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String current = "blank";  // 현재 페이지
		
		Stack<String> backward = new Stack<>();
		Stack<String> forward = new Stack<>();
		
		while (true) {
			String[] cmd = sc.nextLine().split(" ");
			
			switch (cmd[0]) {
			case "V":  // 방문
				forward.clear();
				backward.push(current);
				current = cmd[1];
				System.out.println(current);
				break;
				
			case "B":  // 뒤로가기 버튼
				if (backward.isEmpty()) {
					System.out.println("비활성 상태");
				}
				else {
					forward.push(current);
					current = backward.pop();
					System.out.println(current);
				}
				break;
				
			case "F":  // 앞으로가기 버튼
				if (forward.isEmpty()) {
					System.out.println("비활성 상태");
				}
				else {
					backward.push(current);
					current = forward.pop();
					System.out.println(current);
				}
				break;
				
			case "Q":  // 종료
				System.exit(0);
				break;
			}
		}
	}
}