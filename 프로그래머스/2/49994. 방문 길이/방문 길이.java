import java.util.*;
class Solution {
    public int solution(String dirs) {
        int cur_r = 0;
        int cur_c = 0;
        int[] d_r = {1,0,-1,0};
        int[] d_c = {0,1,0,-1};
        Set<String> visited = new HashSet<>();
        int ans = 0;
        for(char c : dirs.toCharArray()){
            System.out.println(cur_r+" "+cur_c);
            int d=-1;
            if(c=='U'){
                d=0;
            }
            else if(c=='R'){
                d=1;
            }
            else if(c=='D'){
                d=2;
            }
            else{
                d=3;
            }
            
            if(isArea(cur_r+d_r[d],cur_c+d_c[d])){
                int n_r = cur_r + d_r[d];
                int n_c = cur_c + d_c[d];
                if(!visited.contains(cur_r+" "+cur_c+" "+n_r+" "+n_c)){
                    visited.add(cur_r+" "+cur_c+" "+n_r+" "+n_c);
                    visited.add(n_r+" "+n_c+" "+cur_r+" "+cur_c);
                    ans += 1;
                }
                cur_r = n_r;
                cur_c = n_c;
            }
        }
        return ans;
    }
    
    public boolean isArea(int n_r, int n_c){
            if(n_r>-6 && n_r<6 && n_c >-6 && n_c<6){
                return true;
            }
        else{
            return false;
        }
    }
}