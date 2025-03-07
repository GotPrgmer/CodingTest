import java.util.*;
class Solution {
    static int[][] map;
    static int[] d_r = {-1,0,1,0};
    static int[] d_c = {0,1,0,-1};
    static int[][] visited;
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        map = maps;
        return bfs(maps.length,maps[0].length);
    }
    public int bfs(int n,int m){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = 1;
        
        while(q.size()!=0){
            int[] s = q.poll();
            int cur_r = s[0];
            int cur_c = s[1];
            if(cur_r==n-1&&cur_c==m-1){
                return visited[cur_r][cur_c];
            }
            if(visited[cur_r][cur_c]==0){
                continue;
            }
            for(int i=0;i<4;i++){
                int n_r = d_r[i]+cur_r;
                int n_c = d_c[i]+cur_c;
                if(0<=n_r && n_r<n && 0<=n_c && n_c<m && map[n_r][n_c] == 1 && visited[n_r][n_c]==0){
                    q.add(new int[]{n_r,n_c});
                    visited[n_r][n_c] = visited[cur_r][cur_c]+1;
                }
            }
            
        }
        return -1;
    }
}