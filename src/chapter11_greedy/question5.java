package chapter11_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question5 {
    static int N, M;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] bowling = new int [M+1];
        for(int i=0;i<N;i++) {
            bowling[Integer.parseInt(st.nextToken())]++;
        }
        for(int i=0;i<M;i++) {
            for(int j=i+1;j<=M;j++) {
                answer += bowling[i]*bowling[j];
            }
        }

        System.out.println(answer);
        br.close();
    }
}
