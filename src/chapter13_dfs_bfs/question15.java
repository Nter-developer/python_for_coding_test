package chapter13_dfs_bfs;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    백준 특정 거리의 도시 찾기 문제
    https://www.acmicpc.net/problem/18352

 */

public class question15 {
    static int N, M, K, X;
    static int [][] road;
    static int [] shortest_distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        shortest_distance = new int [N+1];
        boolean [] visit = new boolean[N+1];
        road = new int [M][2];
        int v = 0;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            road[i][0] = Integer.parseInt(st.nextToken());
            road[i][1] = Integer.parseInt(st.nextToken());
        }

        //dfs(X, visit, v);
        for(int i=1;i<=N;i++) {
            if(shortest_distance[i]==K) {
                System.out.println(i);
            }
        }
        br.close();
    }
    static void dfs(int city, boolean [] visit, int visited_city) {
        for(int i=0;i<M;i++) {
            if(road[i][0]==city&&!visit[road[i][1]]) {
                visited_city++;
                visit[road[i][1]] = true;
                //System.out.println(city +" to "+road[i][1] +" distance "+visited_city);
                dfs(road[i][1], visit, visited_city);
                visited_city--;
                visit[road[i][1]] = false;
            }
        }
        if(shortest_distance[city]==0) {
            shortest_distance[city] = visited_city;
        }
        else {
            shortest_distance[city] = shortest_distance[city]>visited_city?visited_city:shortest_distance[city];
        }
    }
    static void bfs(int city, boolean [] visit, int visited_city) {
        List<Integer> dist_list = new ArrayList<>();
        for(int i=0;i<M;i++) {
            if()
        }
    }
}


/*
    예제 입력 1
    4 4 2 1
    1 2
    1 3
    2 3
    2 4
    예제 출력 1
    4
    예제 입력 2
    4 3 2 1
    1 2
    1 3
    1 4
    예제 출력 2
    -1
    예제 입력 3
    4 4 1 1
    1 2
    1 3
    2 3
    2 4
    예제 출력 3
    2
    3
 */