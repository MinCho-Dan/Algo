import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S_1224_계산기3_최규직 {
	
	private static int N;
 
	public static void main(String[] args) throws Exception {
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int test_case = 1; test_case <= 1; test_case++) {
            sb.append("#" + test_case + " ");
            Deque<String> stack = new ArrayDeque<>();
            		
            N = Integer.parseInt(in.readLine());
            
            String[] tmp = in.readLine().split("");
            StringBuilder temp = new StringBuilder();
            
            // 후위계산식으로 변경하기
            for (int i = 0; i < N; i++) {
            	if (tmp[i].equals("(")||
        			tmp[i].equals("*")||
        			tmp[i].equals("/")) { // 무조건 push하는 애들
            		stack.push(tmp[i]);
            	}
            	else if (tmp[i].equals("+")|| // 덧셈, 뺄셈일때
                	tmp[i].equals("-")) {
	            		if (!stack.isEmpty()) {
	            			while (!stack.isEmpty() &&
	            					(stack.peek().equals("/") || // 곱,나눔이면 빼고
	        	        			stack.peek().equals("*")||
	        	        			stack.peek().equals("+")||
	        	        			stack.peek().equals("-"))) {
	            				temp.append(stack.pop());
	            			}
	            			stack.push(tmp[i]);
	            		}
	            		else {
	            			stack.push(tmp[i]);
	            		}
            	}
            	else if (tmp[i].equals(")")) { // 닫는 괄호일 때
                	while (!stack.peek().equals("(")) { // 여는 괄호 만날때까지 뺀다
                		temp.append(stack.pop());
                	}
                	stack.pop();
            	}
            	else {
            		temp.append(tmp[i]);
            	}
            }
            while (!stack.isEmpty()){temp.append(stack.pop());}
            
            // 후위계산식을 계산하기
//            String[] tmp2 = temp.toString().split("");
//            StringBuilder temp2 = new StringBuilder();
//            for (int i = 0; i < N; i++) {
//            	if (tmp2[i].equals("/")|| // 연산자를 만나면
//        			tmp2[i].equals("*")||
//        			tmp2[i].equals("+")||
//        			tmp2[i].equals("-")) {
//            		int a = Integer.parseInt(stack.pop());
//            		int b = Integer.parseInt(stack.pop());
//            	}
//            }
            
            
            
            System.out.println("후위식은 : " + temp);
           
            
//            sb.append(res);
        }
//        System.out.println(sb);
    }
}



/*
 * 스택을 활용해서 중위표기식을 후위표기식으로 바꾸고 
 * 계산하는 프로그램을 만들기.
 * 
 * 
 * 
 * 
*/
