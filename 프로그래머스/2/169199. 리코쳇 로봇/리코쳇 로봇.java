import java.util.*;
class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int[] d_r = {-1,0,1,0};
    static int[] d_c = {0,1,0,-1};
    public int solution(String[] board) {
        map = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        // System.out.println(board[0]);
        for(int i=0;i<map.length;i++){
            map[i] = board[i].toCharArray();
            System.out.println(Arrays.toString(map[i]));
        }
        //R찾기
        int s_r = -1;
        int s_c = -1;
        for(int r=0;r<map.length;r++){
            for(int c=0;c<map[0].length;c++){
                if(map[r][c] == 'R'){
                    s_r = r;
                    s_c = c;
                    break;
                }
            }
            if(s_r != -1 && s_c != -1){
                break;
            }
        }
        
        
        return bfs(s_r,s_c);
    }
    public int bfs(int r, int c){
        //R을 집어넣기
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 0});
        visited[r][c] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];
            int cur_cnt = cur[2];
            if(map[cur_r][cur_c]=='G'){
                return cur_cnt;
            }
            //for문을 돌려서 과정을 완료한 지점이 visited처리가 됐는지 확인
            for(int d=0;d<4;d++){
                int[] next = straight(cur_r, cur_c, d);
                if((next[0] != cur_r || next[1] != cur_c) && !visited[next[0]][next[1]]){
                    //visited 처리하고 q에 다음 값 집어넣음.
                    visited[next[0]][next[1]] = true;
                    q.add(new int[]{next[0],next[1],cur_cnt+1});
                }
            }
        }
        return -1;
    }
    public int[] straight(int r, int c, int d){
        //r과 c를 출발로 d방향으로 map에서 벗어나거나 D에 마주치면 정지
        int cur_r = r;
        int cur_c = c;
        while(true){
            int n_r = cur_r + d_r[d];
            int n_c = cur_c + d_c[d];
            if(isRange(n_r,n_c,map.length,map[0].length) && map[n_r][n_c]!='D'){
                cur_r = n_r;
                cur_c = n_c;
            }
            else{
                break;
            }
        }
        return new int[]{cur_r,cur_c};
    }
    public boolean isRange(int r, int c, int max_r, int max_c){
        if(0<=r && r<max_r && 0<=c && c<max_c){
            return true;
        }
        else{
            return false;
        }
    }
}