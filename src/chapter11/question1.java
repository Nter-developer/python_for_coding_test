package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class question1 {
    static int N, G = 0;
    static int [] argonaut;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        argonaut = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            argonaut[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(argonaut);
        int grouped = 0;
        for(int i=0;i<N;i++) {
            if(i-grouped>=argonaut[i]) {
                grouped = i;
                G++;
            }
        }
        System.out.println(G);
        br.close();
    }
}
