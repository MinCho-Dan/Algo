import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// 못풀었음... 풀어보는 중....

public class S_1248_공통조상_최규직 {
	
	private static int V;
	private static int E;
	private static int start;
	private static int end;
	private static int[][] xy; // 인접행렬
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine()); // TC 개수
        
        // T개의 TC 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");
             
            String[] tmp = in.readLine().split(" ");
            V = Integer.parseInt(tmp[0]);
            E = Integer.parseInt(tmp[1]);
            start = Integer.parseInt(tmp[2]);
            end = Integer.parseInt(tmp[3]);
            xy = new int[V + 1][V + 1];
            
            String[] temp = in.readLine().split(" ");
            for (int i = 0; i < temp.length; i=i+2) {	 
            	int x = Integer.parseInt(temp[i]);
            	int y = Integer.parseInt(temp[i+1]);
            	xy[x][y] = 1;
			}
            
            Queue<Integer> startQ = new PriorityQueue<>();
            ArrayList<Integer> startTemp = new ArrayList<>();
            for (int i = start; i >= 1 ; i--) {
				if (xy[start][i] == 1) {
					startQ.offer(i);
				}
			}
            System.out.println(startQ);
            
            ArrayList<Integer> endTemp = new ArrayList<>();
            for (int i = end; i >= 1 ; i--) {
				if (xy[end][i] == 1) {
					endTemp.add(i);
				}
			}
            Collections.sort(endTemp);
//            System.out.println(endTemp);
            
            int parent = 0;
            for (int i = 0; i < Integer.min(startTemp.size(), endTemp.size()); i++) {
//            	System.out.println(startTemp.get(i) + " 비교 " + endTemp.get(i));
				if (startTemp.get(i) != endTemp.get(i)) {
//					System.out.println(startTemp.get(i) + " 흐음 " + endTemp.get(i));
					parent = i-1;
				}
			}
            
            sb.append(parent);
            
        }
        System.out.println(sb);
	}

}
