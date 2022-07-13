package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question2 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;
        for(int i=0;i<str.length();i++) {
            int n = str.charAt(i) - '0';
            sum = sum+n>sum*n?sum+n:sum*n;
        }
        System.out.println(sum);
        br.close();
    }
}
