import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1427 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int len = str.length();
        char[] arr = new char[len];
        for (int i = 0; i < len; i++)
			arr[i] = str.charAt(i);
		
        Arrays.sort(arr);
        
        for (int i = len - 1; i >= 0; i--) 
			sb.append(arr[i]);
		
        System.out.println(sb);
    }
}