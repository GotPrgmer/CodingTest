import java.util.*;
class Solution {
    static Set<String> visited;
    static String[] board_static;
    static int[] d_r = {-1,0,1,0};
    static int[] d_c = {0,1,0,-1};
    public int solution(String[] board) {
        visited = new HashSet<>();
        int start_r = -1;
        int start_c = -1;
        board_static = board;
        OuterLoop:
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j)=='R'){
                    start_r = i;
                    start_c = j;
                    break OuterLoop;
                }
            }
        }
        
        return bfs(start_r,start_c);
    }
    public int bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];
            int cur_cnt = cur[2];
            
            if(board_static[cur_r].charAt(cur_c) == 'G'){
                return cur_cnt;
            }
            if(visited.contains(cur_r+" "+cur_c)){
                continue;
            }
            visited.add(cur_r+" "+cur_c);
            //미끄러지기
            for(int d=0;d<4;d++){
                int n_r = cur_r;
                int n_c = cur_c;
                while(true){
                    int tmp_r = n_r+d_r[d];
                    int tmp_c = n_c+d_c[d];
                    if(0<=tmp_r && tmp_r<board_static.length &&
                      0<=tmp_c && tmp_c<board_static[0].length()&&
                      board_static[tmp_r].charAt(tmp_c)!='D'){
                        n_r = tmp_r;
                        n_c = tmp_c;
                    }
                    else{
                        break;
                    }
                }
                if(!visited.contains(n_r+" "+n_c)){
                    q.add(new int[]{n_r,n_c,cur_cnt+1});
                }
            }
        }
        return -1;
    }
}