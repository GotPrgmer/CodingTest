import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        boolean is_a = false;
        // System.out.println(commonNumber(9,6));
        //arrayA의 최대공약수 구하기
        int a_cm= arrayA[0];
        for(int i=1;i<arrayA.length;i++){
            a_cm = commonNumber(a_cm,arrayA[i]);
        }
        // System.out.println(a_cm);
        //arrayB숫자들을 나눠보기
        for(int i=0;i<arrayB.length;i++){
            if(arrayB[i]%a_cm==0){
                a_cm = 0;
                break;
            }
        }
        
        //arrayB의 최대공약수 구하기
        int b_cm= arrayB[0];
        for(int i=1;i<arrayB.length;i++){
            b_cm = commonNumber(b_cm,arrayB[i]);
        }
        // System.out.println(b_cm);
        //arrayA숫자들을 나눠보기
        for(int i=0;i<arrayA.length;i++){
            if(arrayA[i]%b_cm==0){
                b_cm = 0;
                break;
            }
        }
        return Math.max(a_cm,b_cm);
        
    
    }
    public int commonNumber(int a, int b){
        int big = Math.max(a,b);
        int small = Math.min(a,b);
        while(true){
            if(big%small==0){
                break;
            }
            int remain = big % small;
            big = small;
            small = remain;
        }
        return small;
    }
}