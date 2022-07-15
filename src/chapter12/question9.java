package chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class question9 {
    static int possible;
    static String [] compression_list;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        compression_list = new String [str.length()/2+1];
        possible = str.length()/2+1;

        for(int i=1;i<str.length()/2+1;i++) {
            String s = str;
            for(int j=0;j<str.length()-(i+j);j+=i) {
                if(s.substring(j,j+i)==s.substring(j+i+1,j+2*i+1)) {

                }
            }
        }

        System.out.println();
        br.close();
    }
}
