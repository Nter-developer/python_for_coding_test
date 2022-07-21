package chapter12_implements;

public class question10 {
    static int [][] key;
    static int [][] lock;
    public static void main(String[] args) {
        key = new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        lock = new int [][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Solution10 s = new Solution10();
        s.solution(key, lock);
    }
}
class Solution10 {
    static int [][] key;
    static int [][] lock;
    static int [][] key_lock;
    public boolean solution(int[][] key, int[][] lock) {
        this.key = key;
        this.lock = lock;
        key_lock = new int [lock.length+(key.length-1)*2][lock.length+(key.length-1)*2];
        for(int i=key.length-1;i<key.length+lock.length-1;i++) {
            for(int j=key.length-1;j<key.length+lock.length-1;j++) {
                if(lock[i-(key.length-1)][j-(key.length-1)] == 1) {
                    key_lock[i][j] = 1;
                }
            }
        }
        boolean answer = false;
        for(int i=0;i<4;i++) {
            rotation();
            if(open()) {
                answer = true;
                break;
            }
        }
        //System.out.println(answer);
        return answer;
    }
    static void rotation() {
        int [][] rotation_key = new int [key.length][key.length];
        for(int i=0;i<key.length;i++) {
            for(int j=0;j<key.length;j++) {
                if(key[i][j]==1) {
                    rotation_key[j][key.length-1-i] = 1;
                }
            }
        }
        /*
        for(int i=0;i<key.length;i++) {
            for(int j=0;j<key.length;j++) {
                System.out.print(rotation_key[i][j]+" ");
            }
            System.out.println();
        }
         */
        key = rotation_key;
    }
    static boolean open() {
        //resize and attempt to open
        for(int i=0;i<key_lock.length-key.length+1;i++) {
            for(int j=0;j<key_lock.length-key.length+1;j++) {
                int [][] resize_key = resize(i, j);
                if(attempt(resize_key)) {
                    return true;
                }
            }
        }
        return false;
    }
    static int[][] resize(int r, int c) {
        int resize_key [][] = new int [lock.length+(key.length-1)*2][lock.length+(key.length-1)*2];
        for(int i=r;i<key.length+r;i++) {
            for(int j=c;j<key.length+c;j++) {
                if(key[i-r][j-c]==1) {
                    resize_key[i][j] = key[i-r][j-c];
                }
            }
        }
        //System.out.println("resize " + r + ", "+ c);
        return resize_key;
    }
    static boolean attempt(int [][] resize_key) {
        //print resize key and key_lock
        /*
        for(int i=0;i< key_lock.length;i++) {
            for(int j=0;j< key_lock.length;j++) {
                System.out.print(resize_key[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("key_lock");
        for(int i=0;i< key_lock.length;i++) {
            for(int j=0;j< key_lock.length;j++) {
                System.out.print(key_lock[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        */
        for(int i=key.length-1;i<key.length+lock.length-1;i++) {
            for(int j=key.length-1;j<key.length+lock.length-1;j++) {
                //System.out.println(resize_key[i][j]+key_lock[i][j]);
                if(resize_key[i][j]+key_lock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}