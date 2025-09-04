
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class S_1245_균형점_최규직 {
	
	static int N;
	static xy company, home;
	static xy[] customers;
    static boolean[] visited;
    static int min;
	
    static class xy {
        int x, y;
        
        xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine());

        for (int q = 1; q <= T; q++) { 
        	sb.append("#" + q + " "); 
        	
        	N = Integer.parseInt(in.readLine());
  
	}

}