package chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class question9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution9 s = new Solution9();
        System.out.println(s.solution("aabbaccc"));
        br.close();
    }
}
class Solution9 {
    static String str;
    static int min_length;
    public int solution(String s) {
        this.str = s;
        min_length = str.length();
        for(int i=1;i<=str.length()/2;i++) {
            compression(i);
        }
        return min_length;
    }
    static void compression(int length) {
        String [] comp_block = new String[str.length()/length+1];
        int range = 0;
        int index = 0;
        while(true) {
            comp_block[index] = str.substring(range, range+length>str.length()?str.length():range+length);
            if(index!=0&&comp_block[index].equals(comp_block[index-1])) {
                if(index>1&&comp_block[index-2].chars().allMatch(Character::isDigit)) {
                    comp_block[index-1] = String.valueOf(Integer.parseInt(comp_block[index-2])+1);
                    comp_block[index-2] = "";
                }
                else {
                    comp_block[index-1] = "2";
                }
            }
            index++;
            range+=length;
            if(range>str.length()) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<comp_block.length;i++) {
            sb.append(comp_block[i]);
        }
        min_length = Math.min(sb.length(), min_length);
    }
}
