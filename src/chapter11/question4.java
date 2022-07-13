package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class question4 {
    static int N;
    static boolean [] used_coin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        used_coin = new boolean[N];
        int [] coins = new int [N];
        for(int i=0;i<N;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);
        int amount = 1;
        while(true) {
            if(!match_amount(amount)) {
                break;
            }
            amount++;
        }
        System.out.println(amount);
        br.close();
    }
    static boolean match_amount(int a) {
        return true;
    }
}
