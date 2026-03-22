import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_27323 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int res = Integer.parseInt(br.readLine());
        res *= Integer.parseInt(br.readLine());
        System.out.println(res);
    }
}