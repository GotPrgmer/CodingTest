import java.util.*;
class Solution {
    static boolean[][] visited;
    static int max_r;
    static int max_c;
    static int[] d_r = {-1,0,1,0};
    static int[] d_c = {0,1,0,-1};
    public int[] solution(String[] maps) {
        max_r = maps.length;
        max_c = maps[0].length();
        visited = new boolean[max_r][max_c];
        List<Integer> ansList = new ArrayList<>();
        for(int i=0;i<max_r;i++){
            for(int j=0;j<max_c;j++){
                if(maps[i].charAt(j)!='X' && !visited[i][j]){
                    ansList.add(bfs(i,j,maps));
                    
                }
            }
        }
        if(ansList.size()>0){
            Collections.sort(ansList);
        }
        else{
            ansList.add(-1);
        }
        
        int[] ans = new int[ansList.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }
    public int bfs(int r, int c,String[] maps){
        int tmp = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        // System.out.println("111111111"+tmp);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];
            if(visited[cur_r][cur_c]){
                continue;
            }
            visited[cur_r][cur_c]= true;
            // System.out.println(tmp);
            tmp += Integer.parseInt(String.valueOf(maps[cur_r].charAt(cur_c)));
            // System.out.println(tmp);
            // 순회해서 X가 아닌 숫자들로만 가기
            for(int d=0;d<4;d++){
                int n_r = cur_r + d_r[d];
                int n_c = cur_c + d_c[d];
                if(n_r>=0 && n_r<max_r && n_c>=0 && n_c<max_c && maps[n_r].charAt(n_c) != 'X'){
                    q.offer(new int[]{n_r,n_c});
                }
            }
        }
        return tmp;
    }
}