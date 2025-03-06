import java.util.*;
class Solution {
    static int[] parents;
    public int solution(int n, int[][] computers) {
        parents = new int[n+1];
        for(int i=1;i<n+1;i++){
            parents[i] = i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j] == 1){
                    union(i+1,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(parents));
        Set<Integer> result = new HashSet<>();
        for(int i=1;i<parents.length;i++){
            result.add(find(i));
        }
        return result.size();
    }
    public int find(int x){
        if(parents[x]==x) return x;
        else{
            return parents[x] = find(parents[x]);
        }
        
    }
    public void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX==parentY) return;
          if(parentX<=parentY){
            parents[parentY] = parentX;
        }
        else{
            parents[parentX] = parentY;
        }  

    }
}