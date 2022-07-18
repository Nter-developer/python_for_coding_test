package chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class question11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board b = new board(N);
        //set apple info
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board.setApple(y,x);
        }
        //set drift info
        int L = Integer.parseInt(br.readLine());
        int [] driftTime = new int[L];
        char [] driftDL = new char [L];
        for(int i=0;i<L;i++) {
            st = new StringTokenizer(br.readLine());
            driftTime[i] = Integer.parseInt(st.nextToken());
            driftDL[i] = st.nextToken().charAt(0);
        }
        //create snake
        snake baam = new snake(driftTime, driftDL);

        //board.printApple();
        while(baam.isAlive()) {}

        System.out.println(baam.getTime());
        br.close();
    }
}
class board {
    static private boolean [][] apple;
    board(int N) {
        //if snake touch board(0 or N+1) it die
        apple = new boolean[N+2][N+2];
    }
    static void setApple(int x, int y) {
        apple[x][y] = true;
    }
    static boolean eatApple(int x, int y) {
        if(apple[x][y]) {
            apple[x][y] = false;
            return true;
        }
        else {
            return false;
        }
    }
    static int getLength() {
        return apple.length;
    }
    static void printApple() {
        System.out.println("print initial apple");;
        for(int i=0;i<apple.length;i++) {
            for(int j=0;j<apple.length;j++) {
                if(apple[i][j]) {
                    System.out.println("apple: "+i+", "+j);
                }
            }
        }
    }
}
class snake {
    private int time;
    private List<int[]> sXY;
    private char direction;
    private int [] driftTime;
    private char [] driftDL;
    private int driftIndex;

    snake(int [] driftTime, char [] driftDL) {
        time = 0;
        sXY = new LinkedList<>();
        sXY.add(new int[] {1,1});
        direction = 'R';
        this.driftTime = driftTime;
        this.driftDL = driftDL;
        driftIndex = 0;
    }

    boolean isAlive() {

        //go
        int headX = sXY.get(sXY.size()-1)[0];
        int headY = sXY.get(sXY.size()-1)[1];
        switch (direction) {
            case 'R':
                headX++;
                sXY.add(new int[] { headX, headY });
                break;
            case 'L':
                headX--;
                sXY.add(new int[] { headX, headY });
                break;
            case 'U':
                headY--;
                sXY.add(new int[] { headX, headY });
                break;
            case 'D':
                headY++;
                sXY.add(new int[] { headX, headY });
                break;
        }
        time++;

        //printSXY();


        //if I survive?
        //boarder touch
        if(headX==0||headY==0||headX==board.getLength()-1||headY==board.getLength()-1) {
            //System.out.println("boarder touch");
            return false;
        }

        //body touch
        for(int i=0;i<sXY.size()-1;i++) {
            if(headX==sXY.get(i)[0]&&headY==sXY.get(i)[1]) {
                //System.out.println("body touch die");

                return false;
            }
        }

        // is it fruit?
        if (!board.eatApple(headX, headY)) {
            // remove tail
            sXY.remove(0);
        }
        else {
            //System.out.println(headX+", "+headY+" eat");
        }

        //set direction
        if(driftTime[driftIndex] == time) {
            switch(driftDL[driftIndex]) {
                case 'D' :
                    if(direction=='R') {
                        direction = 'D';
                    }
                    else if(direction=='L') {
                        direction = 'U';
                    }
                    else if(direction=='U') {
                        direction = 'R';
                    }
                    else if(direction=='D') {
                        direction = 'L';
                    }
                    break;
                case 'L' :
                    if(direction=='R') {
                        direction = 'U';
                    }
                    else if(direction=='L') {
                        direction = 'D';
                    }
                    else if(direction=='U') {
                        direction = 'L';
                    }
                    else if(direction=='D') {
                        direction = 'R';
                    }
                    break;
            }
            if(driftIndex<driftDL.length-1) {
                driftIndex++;
            }
            //System.out.println(direction);
        }

        //snake alive!
        return true;
    }


    //getter
    int getTime() {
        return time;
    }

    //print
    void printSXY() {
        System.out.println("snake XY at Time: "+time);
        for(int i=0;i<sXY.size();i++) {
            System.out.println(sXY.get(i)[0]+", "+sXY.get(i)[1]);
        }
    }
}
