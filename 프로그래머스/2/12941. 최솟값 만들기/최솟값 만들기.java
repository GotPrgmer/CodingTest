import java.util.*;
class Solution
{   
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        System.out.println(Arrays.toString(A));
        int[] newB = new int[B.length];
        for(int i=B.length-1;i>-1;i--){
            newB[B.length-1-i] = B[i];
        }
        int sum =0;
        for(int i=0;i<A.length;i++){
            sum += A[i]*newB[i];
        }


        return sum;
    }
}