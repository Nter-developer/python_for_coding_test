package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class question4 {
    static int N, possible;
    static int [] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        coins = new int [N];
        for(int i=0;i<N;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);
        if(coins[0]!=1) {
            System.out.println("1");
            return;
        }
        possible = coins[0];
        for(int i=1;i<N;i++) {
            if(coins[i]>possible+1) {
                break;
            }
            possible += coins[i];
        }
        System.out.println((possible+1));
        br.close();
    }
}
