package chapter11_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class question3 {
    static int z = 0, o = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if(str.charAt(0)=='0') z++;
        else o++;

        for(int i=1;i<str.length();i++) {
            if(str.charAt(i)!=str.charAt(i-1)) {
                if(str.charAt(i)=='0') {
                    z++;
                }
                else {
                    o++;
                }
            }
        }
        System.out.println(z>o?o:z);
        br.close();
    }
}
