package chapter12;


/*
    친구 a가 처리할 수 있는 weak[]들의 집합의 배열을 만든다
    a는 걸을 수 있는 거리 d안에 한번에 들어갈 수 있는 weak[]들의 집합(1 to 2, 3to 4 ...)을 a라는 친구의 배열에 넣고
    back tracking을 통해 모든 weak를 수리할 수 있는 최소의 조합을 찾는다??
 */


import java.util.ArrayList;
import java.util.List;

public class question14 {
    public static void main(String[] args) {
        Solution14 s = new Solution14();
        System.out.println(s.solution(12, new int [] {1, 3, 4, 9, 10}, new int [] {3, 5, 7}));

    }
}
class Solution14 {
    static final int cipher = 16;
    static int n;
    static int min_friends;
    static int [] week, dist;
    static int [][] cover_range;
    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.week = weak;
        this.dist = dist;
        boolean [] cover_friends = new boolean [dist.length];
        boolean [] cover_weaks = new boolean [weak.length];
        min_friends = dist.length;
        cover_range = new int [dist.length][weak.length];
        set_cover_range();
        cover_weak_recursion(0, cover_friends, cover_weaks);
        return min_friends;
    }
    static void set_cover_range() {
        for(int i=0;i<dist.length;i++) {
            for(int j=0;j<week.length;j++) {
                int cover_weak;
                if(dist[i]+week[j]<n) {
                    cover_weak = j;
                    for(int k=j;k<week.length;k++) {
                        if(week[k]<=dist[i]+week[j]) {
                            cover_weak = k;
                        }
                        else {
                            break;
                        }
                    }
                }
                else {
                    //System.out.println("range over");
                    cover_weak = week.length-1;
                    for(int k=0;k<j;k++) {
                        if(week[k]<=dist[i]+week[j]-n) {
                            cover_weak = k;
                        }
                        else {
                            break;
                        }
                    }
                }
                cover_range[i][j] = j*cipher + cover_weak;
                //System.out.println("friend "+i+" can cover "+j+" to "+cover_weak);
            }
        }
    }

    static int cover_weak_recursion(int s, boolean [] cover_friends, boolean [] cover_weaks) {
        if(s == dist.length) {
            System.out.println("s == dist.length");
            return -1;
        }
        else if(cover_clear(cover_weaks)) {
            int mf = 0;
            System.out.println("cover_clear(cover_weaks)");
            for(int i=0;i<cover_friends.length;i++) {
                if(cover_friends[i]) {
                    mf++;
                    System.out.print(i+", ");
                }
            }
            System.out.println();
            if(min_friends>mf) {
                min_friends = mf;
            }
            return min_friends;
        }
        else {
            //System.out.println("else");

            /*
            for(int i=0;i<s;i++) {
                if(!cover_friends[i]) {

                }
            }
            */


            cover_weak_recursion(s+1, cover_friends, cover_weaks);
            cover_friends[s] = true;
            for(int i=0;i<dist.length;i++) {
                int range [] = cipher(cover_range[s][i]);
                int to = range[0];
                int from = range[1];
                if(from<to) {
                    for(int j=to;j<week.length;j++) {
                        cover_weaks[j] = true;
                    }
                    for(int j=0;j<to;j++) {
                        if(from>week[j]) {
                            cover_weaks[j] = true;
                        }
                    }
                }
                else {
                    //System.out.println(to+" "+from);
                    for(int j=to;j<=from;j++) {
                        cover_weaks[j] = true;
                    }
                }
                //System.out.println("friend "+s+" to "+from);
                cover_weak_recursion(s+1, cover_friends, cover_weaks);
            }
            return -1;
        }
    }

    static int [] cipher(int n) {
        int [] temp = new int [] {n/16, n%16};
        return temp;
    }

    static boolean cover_clear(boolean [] cover_weaks) {
        for(int i = 0;i<cover_weaks.length;i++) {
            if(!cover_weaks[i]) {
                return false;
            }
        }
        return true;
    }
}