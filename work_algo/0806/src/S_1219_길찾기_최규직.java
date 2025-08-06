import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S_1219_길찾기_최규직 {
		
	private static int[] arr;
	private static int[] arr1;
	private static int[] arr2;
	private static int N;
	private static boolean[] visited;
	private static ArrayDeque<Integer> stack;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int test_case = 1; test_case <= 1; test_case++) { // 테케 10회
            sb.append("#" + test_case + " ");
            
            String[] split = in.readLine().split(" ");
            N = Integer.parseInt(split[1]); // N : Edge개수
            
            arr = new int[N];
            String[] split2 = in.readLine().split(" ");
            for (int i = 0; i < N; i++) {
    			arr[i] = Integer.parseInt(split2[i]);
            }
            
            arr1 = new int[100];
            arr2 = new int[100];
            
            for (int i = 0; i < N; i=i+2) {
            	if (arr1[arr[i]] != 0) {
            		arr1[arr[i]] = arr[i+1]; // arr(i,i+1)은 순서쌍이다.
            	}
            	else {
            		arr2[arr[i]] = arr[i+1]; // arr1과 arr2에 모두 저장.
            	}
            }
            


            	
			while (true) {
				
			}

        }
        sb.append("\n");
        System.out.println(sb);
	}



	
}
