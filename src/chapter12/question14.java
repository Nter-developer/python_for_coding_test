package chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
        M개의 치킨집 중에서 N개를 남긴다고 가정하면
        (M-N)개의 치킨집을 제거하는 것과 같다

        M개의 치킨집 중 M-N개를 선택해서 제가한 뒤 결과값을 확인해보자자
        */

public class question14 {
    static int N, M;
    static int [][] town;
    static boolean [] visit;
    static List<int []> chicken_list;
    static List<int []> save_list;
    static List<int []> house_list;
    //boolean for print code
    static boolean print = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken_list = new ArrayList<>();
        save_list = new ArrayList<>();
        house_list = new ArrayList<>();
        town = new int [N+1][N+1];
        for(int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++) {
                town[i][j] = Integer.parseInt(st.nextToken());
                if(town[i][j]==2) {
                    chicken_list.add(new int []{j,i});
                }
                else if(town[i][j]==1) {
                    house_list.add(new int []{j,i});
                }
            }
        }
        /*
        if(print) {
            for(int i = 0; i<chicken_list.size(); i++) {
                int [] temp = chicken_list.get(i);
                System.out.println(temp[0] + ", " + temp[1]);
            }
        }
        */
        visit = new boolean [chicken_list.size()];
        solution();
        /*
        if(print) {
            for(int[] k: save_list) {
                System.out.println(k[0]+","+k[1]);
            }
        }
        */
        System.out.println(get_distance());
        br.close();
    }
    static int solution() {
        draw(0, M, visit);
        return 0;
    }
    static void draw(int index, int s, boolean [] v) {
        if(s==0) {
            //System.out.println("case: d==0");
            int [] temp = new int [3];
            int j = 0;
            for(int i=0;i<visit.length;i++) {
                if(v[i]) {
                    temp[j++] = i;
                    if(j==3) {
                        break;
                    }
                }
            }
            /*
            for(int i=0;i<v.length;i++) {
                System.out.print(v[i]+" ");
            }
            System.out.println();
             */
            save_list.add(temp);
            return;
        }
        else if(index >= chicken_list.size()) {
            //System.out.println("case: index == chicken_list.size()");
            return;
        }
        else {
            //System.out.println("case: else");
            v[index] = true;
            draw(index+1, s-1, v);
            v[index] = false;
            draw(index+1, s, v);
        }
    }
    static int get_distance() {
        int sum_min = 2*N*house_list.size();
        int sum = 0;
        int min = 0;

        for(int i=0;i<save_list.size();i++) {
            sum = 0;
            for(int j=0;j<house_list.size();j++) {
                min = 2*N;
                for(int k=0;k<M;k++) {
                    /*System.out.println("calc :"+house_list.get(j)[0]+" - " +chicken_list.get(save_list.get(i)[k])[0] +", "+
                            house_list.get(j)[1] +" - " + chicken_list.get(save_list.get(i)[k])[1]); */
                    int distance =
                            (int)Math.abs(house_list.get(j)[0] - chicken_list.get(save_list.get(i)[k])[0]) +
                            (int)Math.abs(house_list.get(j)[1] - chicken_list.get(save_list.get(i)[k])[1]);
                    if(min>distance) {
                        min = distance;
                    }
                }
                sum+=min;
                //System.out.println("sum += "+min+" "+": "+sum);
            }
            if(sum_min>sum) {
                //System.out.println(sum+">"+min+"?");
                sum_min = sum;
            }
        }
        return sum_min;
    }
}
