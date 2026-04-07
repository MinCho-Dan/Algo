import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2980 {
	static class Signal {
		int R;
		int G;
		public Signal(int r, int g) {
			super();
			R = r;
			G = g;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int cur = 0;
        int time = 0;
        Signal[] arr = new Signal[L];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int idx = Integer.parseInt(st.nextToken());
			arr[idx] = new Signal(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
        
        while (cur != L) {
        	if (arr[cur] != null) {
        		int a = arr[cur].R + arr[cur].G;
	        	if (a != 0 && arr[cur].R > time % a) {
	        		time++;
	        		continue;
	        	}
        	}
        	cur++;
        	time++;
        }
        
        System.out.println(time);
    }
}
