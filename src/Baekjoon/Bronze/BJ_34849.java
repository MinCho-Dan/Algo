import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_34849 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        int n = Integer.parseInt(br.readLine());
	    
        if (n > 10000)
        	System.out.println("Time limit exceeded");
        else
        	System.out.println("Accepted");
    }
}