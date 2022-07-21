package chapter12_implements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class question8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str_c = "";
        int sum = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)-'0'>=0&&str.charAt(i)-'0'<=9) {
                sum += str.charAt(i)-'0';
            }
            else {
                str_c += str.charAt(i);
            }
        }
        char [] arr_c = str_c.toCharArray();
        Arrays.sort(arr_c);
        str_c = new String(arr_c);
        System.out.println(str_c+""+sum);
        br.close();
    }
}
