package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class question4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] coins = new int [N];
        for(int i=0;i<N;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);
        int amount = 1;
        while(true) {

            if(true) {
                break;
            }
            amount++;
        }
        System.out.println();
        br.close();
    }
}
