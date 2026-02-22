import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11034 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
     
        String input = br.readLine();
	    while (input != null) {
	    	StringTokenizer st = new StringTokenizer(input);
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        
	        int aa = b - a - 1;
	        int bb = c - b - 1;
	        sb.append(Math.max(aa, bb) + "\n");
	        input = br.readLine();
		}
        
        System.out.println(sb);
    }
}