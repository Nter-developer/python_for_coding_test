package chapter11;

import java.io.IOException;

public class question6 {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        int [] ft = {16, 10, 18, 10, 10, 16, 6};
        System.out.println(s.solution(ft,6));
    }
}
class Solution {
    public int solution(int[] food_times, long k) {
        int dishes = food_times.length;
        int answer = -1;
        while(true) {
            if(dishes==0) {
                return answer;
            }
            if(k<dishes) {
                //System.out.println("rotating done");
                break;
            }
            else {
                long min_rotation = k/dishes;
                for(int i=0;i<food_times.length;i++) {
                    if(food_times[i]>min_rotation) {
                        k -= min_rotation;
                        food_times[i] -= min_rotation;
                    }
                    else if(food_times[i]==0) {

                    }
                    else {
                        k -= food_times[i];
                        food_times[i] = 0;
                        dishes--;
                    }
                    /*
                    for(int j=0;j<food_times.length;j++) {
                        System.out.print(food_times[j] +" ");
                    }
                    System.out.println("left dishes "+dishes+" k: "+k);
                    */
                }
            }
        }
        for(int i=0;i< food_times.length;i++) {
            if(food_times[i]>0) {
                if(k>0) {
                    k--;
                }
                else {
                    answer = i+1;
                    break;
                }
            }
        }
        return answer;
    }
}