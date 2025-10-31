package Maraton74;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_14928 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine(); 

        long remainder = 0;
        int mod = 20000303;

        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0'; 
            remainder = (remainder * 10 + digit) % mod;
        }

        System.out.println(remainder);
    }
}