import java.util.*;
class Solution {
    static int zero = 0; 
    static int one = 0;
    static int[][] prefix;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        //누적합 (1,1~n,n)
        prefix = sumprefix(arr);
        bfs(new int[]{1,1},new int[]{arr.length,arr.length});
        return new int[]{zero, one};
    }
    public void bfs(int[] start, int[] end){
        int s_r = start[0];
        int s_c = start[1];
        int e_r = end[0];
        int e_c = end[1];
        int r_length = e_r-s_r+1;
        int c_length = e_c -s_c+1;
        int r_half =r_length/2;
        int c_half =c_length/2;
        //해당 영역 값
        int v = prefix[e_r][e_c] - prefix[s_r-1][e_c] - prefix[e_r][s_c-1] + prefix[s_r-1][s_c-1];
        
        //하나의 포인트
        if(s_r==e_r && s_c==e_c){
            if(v==0){
                zero += 1;
                return;
            }
            else{
                one += 1;
                return;
            }
        }
        //하나의 값일때
        else if(v == 0 || v == r_length*c_length){
            if(v == 0){
                zero += 1;
                return;
            }
            else{
                one += 1;
                return;
            }
        }
        else{
            //2사분면
            bfs(new int[]{s_r,s_c},new int[]{s_r+r_half-1,s_c+c_half-1});
            //1사분면
            bfs(new int[]{s_r,s_c+c_half},new int[]{s_r+r_half-1,e_c});
            //3사분면
            bfs(new int[]{s_r+r_half,s_c},new int[]{e_r,s_c+c_half-1});
            //4사분면
            bfs(new int[]{s_r+r_half,s_c+c_half},new int[]{e_r,e_c});
        }
    }
    
    //누적합
    public int[][] sumprefix(int[][] arr){
        int[][] tmp = new int[arr.length+1][arr.length+1];
        //행 연산
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                tmp[i+1][j+1] = tmp[i+1][j] + arr[i][j];
            }
        }
        //열 연산
        for(int j=0;j<arr.length;j++){
            for(int i=0;i<arr.length;i++){
                tmp[i+1][j+1] += tmp[i][j+1];
            }
        }
        
        return tmp;
    }
}