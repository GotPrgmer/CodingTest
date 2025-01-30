import java.util.*;
class Solution {
    public int solution(String dirs) {
        int[] d_r = {1,0,-1,0};
        int[] d_c = {0,1,0,-1};
        int d = -1;
        int cur_r = 0;
        int cur_c = 0;
        int n_r = 0;
        int n_c = 0;
        int ans = 0;
        Set<String> visited = new HashSet<>();
        for(int i=0;i<dirs.length();i++){
            System.out.println(cur_r + " " + cur_c);
            
            if(dirs.charAt(i) == 'U'){
                System.out.println(dirs.charAt(i));
                d = 0;
            }
            else if(dirs.charAt(i) == 'R'){
                System.out.println(dirs.charAt(i));

                d = 1;
            }
            else if(dirs.charAt(i) == 'D'){
                System.out.println(dirs.charAt(i));
                d = 2;
            }
            else{
                System.out.println(dirs.charAt(i));
                d = 3;
            }
            n_r = cur_r + d_r[d];
            n_c = cur_c + d_c[d];
            
            if(-5<=n_r && n_r<=5 && -5<=n_c && n_c<=5){
                if(!visited.contains(cur_r+"."+cur_c+"."+n_r+"."+n_c)){
                    visited.add(cur_r+"."+cur_c+"."+n_r+"."+n_c);
                    visited.add(n_r+"."+n_c+"."+cur_r+"."+cur_c);
                    ans += 1;
                }
                cur_r = n_r;
                cur_c = n_c;
            }
            
        }
        return ans;
    }
}