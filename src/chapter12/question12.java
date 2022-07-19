package chapter12;

import java.util.ArrayList;
import java.util.List;

public class question12 {
    public static void main(String[] args) {
        Solution12 s = new Solution12();
        int [][] result = s.solution(5 , new int [][] {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}});
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i][0] + ", "+ result[i][1]+", "+result[i][2]);
        }
    }
}
class Solution12 {
    static int n;
    static int [][] r, c;
    static int [][] build_frame;
    public int [][] solution(int n, int[][] build_frame) {
        this.n = n;
        this.build_frame = build_frame;
        r = new int [n+1][n+1];
        c = new int [n+1][n+1];
        build();
        int[][] answer = getResult();
        return answer;
    }
    static void build() {
        for(int i=0;i<build_frame.length;i++) {
            frame(build_frame[i]);
        }
    }
    static void frame(int [] bf) {
        int x = bf[0];
        int y = bf[1];
        int t = bf[2];
        int d = bf[3];
        //install
        if(d==1) {
            //columns
            //기둥이 있거나 보가 있거나 바닥이거나
            if(t==0) {
                if(c[x][y] == 0 && ((y>0 && c[x][y-1]==1) || r[x][y]==1 || (x>0&&r[x-1][y]==1) || y==0)) {
                    c[x][y] = 1;
                    //System.out.println("column install "+x+", "+y);
                }
            }
            //beams
            //한쪽 끝부분이 기둥 위에 있거나 양쪽이 보와 맞닿아 있거나
            else {
                if(r[x][y] == 0 && ((x<n && c[x+1][y-1]==1) || (y>0 && c[x][y-1]==1) || ((x>0&&r[x-1][y]==1) && (x<n&&r[x+1][y]==1)))) {
                    r[x][y] = 1;
                    //System.out.println("beam install "+x+", "+y);
                }

            }
        }
        //delete
        else {
            //columns
            if(t==0 && c[x][y] == 1) {
                if(y<n && c[x][y+1]==1 && x>0 && r[x-1][y+1]==0 && r[x][y+1]==0) {}
                else if(y<n && r[x][y+1]==1 && x<n && c[x+1][y] == 0 && r[x+1][y+1]==0) {}
                else if(y<n && x>0 && r[x-1][y+1]==1 && x<n && c[x-1][y] == 0 && r[x+1][y+1]==0) {}
                else {
                    //System.out.println("column delete "+x+", "+y);
                    c[x][y] = 0;
                }
            }
            //beams
            else if(t==1 && r[x][y] == 1){
                //case1: 왼쪽 보가 못 버티는 경우
                if(x>0 && r[x-1][y]==1 && y>0 && c[x-1][y-1]==0 && c[x][y-1]==0) {}
                //case2: 오른쪽 보가 못 버티는 경우
                else if(x<n-1 && r[x+1][y]==1 && y>0 && c[x+1][y-1]==0 && c[x+2][y-1]==0) {}
                //case3: 왼쪽 위 기둥이 못 버티는 경우
                else if(c[x][y]==1 && y>0&& c[x][y-1]==0 && x>0&& r[x-1][y]==0) {}
                //case4: 오른쪽 위 기둥이 못 버티는 경우
                else if(x<n && c[x+1][y]==1 && y>0 && c[x+1][y-1]==0 && r[x+1][y]==0) {}
                else {
                    //System.out.println("beam delete "+x+", "+y);
                    r[x][y] = 0;
                }
            }
        }
    }
    static int [][] getResult() {
        //return 하는 배열은 x좌표 기준으로 오름차순 정렬하며, x좌표가 같을 경우 y좌표 기준으로 오름차순 정렬해주세요.
        //x, y좌표가 모두 같은 경우 기둥이 보보다 앞에 오면 됩니다.
        List<int []> list = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                if(c[i][j]==1) {
                    list.add(new int [] {i, j, 0});
                }
                if(r[i][j]==1) {
                    list.add(new int [] {i, j, 1});
                }
            }
        }
        int [][] result = new int [list.size()][3];
        int index = 0;
        for(int[] k: list) {
            //System.out.println(k[0]+" "+k[1]+" "+k[2]);
            result[index++] = k;
        }
        return result;
    }
}