package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class question1 {
    static int N;
    static int [] argonaut;
    static int G = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        argonaut = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            argonaut[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++) {
            for(int j=0;j<N;j++) {
                if(argonaut[j]==i) {
                    //System.out.println("searching partner with "+j+"th arg, fears "+argonaut[j]);
                    recruit(argonaut[j]);
                }
            }
        }
        System.out.println(G);
        br.close();
    }
    static void recruit(int f) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            if(argonaut[i]<=f) {
                //System.out.println("find partner "+i);
                list.add(i);
            }
            if(list.size()==f) {
                //System.out.println("find complete");
                for(int k: list) {
                    //System.out.println(k+" got in party");
                    argonaut[k] = N+1;
                }
                G++;
                break;
            }
        }
    }
}
