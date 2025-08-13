import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


public class S_1767_프로세서연결하기_최규직 {

	private static int N, connectedCoreCnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine()); // TC 개수
        
        // T개의 TC 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");

            String[] tmp = in.readLine().split(" ");
            N = Integer.parseInt(in.readLine());
    		
    		int[][] core= new int[N][N];
    		
    		for (int i = 0; i < N; i++) {
    			String[] temp = in.readLine().split(" ");
            	for (int j = 0; j < temp.length; j++) {
					core[i][j] = Integer.parseInt(temp[j]);
					}
				}
    		}
    		
    		coreConnect();
    	
            sb.append(result + "\n");
        }
        System.out.println(sb);
	}

	private static void coreConnect() {
		
		
		
		
		
		
		
		
		
	}

}



/* 
 * "최대한" 많이 core에 전원을 연결.
 * -> 4방향이 core에 막혀있다면 전선 연결할 수 없다고 판단하면 됨.
 * 모서리에 인접한 core는 전선 연결이 필요 없음. -> 신경쓰지말것
 * DFS나 BFS로 전선 연결해보면서 전선의 최소값 찾기.
 * max 코어연결수 中 전선의 최소값을 찾아야 함.
 * 
 * 
 */