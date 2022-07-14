package chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int pre = 0, pro = 0;
        for(int i=0;i<str.length()/2;i++) {
            pre += str.charAt(i) - '0';
        }
        for(int i=str.length()/2;i<str.length();i++) {
            pro += str.charAt(i) - '0';
        }
        if(pre==pro) {
            System.out.println("LUCKY");
        }
        else
            System.out.println("READY");
        br.close();
    }
}
