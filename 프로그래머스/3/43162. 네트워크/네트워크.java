import java.util.*;
class Solution {
    static int[] parents;
    public int solution(int n, int[][] computers) {
        parents = new int[n+1];
        for(int i=1;i<n+1;i++){
            parents[i] = i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(computers[i][j] == 1){
                    union(i+1,j+1);
                }
            }
        }
        for(int i=1;i<n+1;i++){
            find(i);
        }
        Set<Integer> points = new HashSet<>();
        for(int i=1;i<n+1;i++){
                points.add(parents[i]);
        }
        System.out.println(Arrays.toString(parents));
        int answer = 0;
        return points.size();
    }
    
    public int find(int x){
        if(x != parents[x]){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    public void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);
        if(x_parent<y_parent){
            parents[y_parent] = x_parent;
        }
        else{
            parents[x_parent] = y_parent;
        }
    }
}