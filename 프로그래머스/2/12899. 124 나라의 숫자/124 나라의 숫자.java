import java.util.*;
class Solution {
    public String solution(int n) {
        int[] num = new int[3];
        num[0] = 4;
        num[1] = 1;
        num[2] = 2;
        //나누어 떨어지면 +1을 함
        //3으로 나누고 몫 나누기를 하자
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            int r = n%3;
            n = n/3;
            sb.insert(0,num[r]);
            if(r==0){
                n -= 1;
            }
        }

        return sb.toString();
    }
}