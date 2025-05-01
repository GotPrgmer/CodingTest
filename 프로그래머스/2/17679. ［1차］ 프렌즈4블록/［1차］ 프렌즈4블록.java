import java.util.*;
class Solution {
    static Set<String> visited;
    static int[] d_r = {0,1,1};
    static int[] d_c = {1,1,0}; 
    static char[][] board_char;
    public int solution(int m, int n, String[] board) {
        board_char = new char[board.length][board[0].length()];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                board_char[i][j] = board[i].charAt(j);
            }
        }
        int ans = 0;
        while(true){
            int cnt = exploreAndRemove(m,n);
            ans += cnt;
            down(m,n);
            if(cnt==0){
                break;
            }
        }
        
        // for(int i=0;i<m;i++){
        //     System.out.println(Arrays.toString(board_char[i]));
        // }
        return ans;
    }
    
    public void down(int m, int n){
        //각 열에서 리스트를 만들어서 맨 아래부터 다시 채워넣기 나머지는 !로 통일
        List<Character> list;
        char[][] new_char = new char[m][n];
        for(int c=0;c<n;c++){
            for(int r=m-1;r>-1;r--){
                new_char[r][c] = '!';
            }
                // if(m-1-r<list.size()){
                //     board_char[r][c] = list.get(m-1-r);
                // }
            // list = new ArrayList<>();
            int tmp_r =m-1;
            for(int r=m-1;r>-1;r--){
                if(board_char[r][c] != '!'){
                    new_char[tmp_r--][c] = board_char[r][c];
                }
            }
            //list사이즈 만큼 board_char에 넣기 나머지는 느낌표로 채우기
            
        }
        board_char = new_char;
    }
    
    public int exploreAndRemove(int r_m, int c_n){
        visited = new HashSet<>();
        int cnt = 0;
        for(int i=0;i<r_m;i++){
            for(int j=0;j<c_n;j++){
                if(!visited.contains(i+" "+j) && board_char[i][j]!='!'){
                    cnt += erase(i,j);
                }
            }
        }
        return cnt;
        
    }
    
    public int erase(int r, int c){
        int r_m = board_char.length;
        int c_n = board_char[0].length;
        int cnt = 0;
        Set<String> erase_set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited.add(r+" "+c);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];
            //아래 오른쪽 대각선 아래 전부 일치하면 erase큐에 넣어주고
            
            if(threeCheck(cur_r,cur_c)){
                erase_set.add(cur_r +" "+cur_c);
                for(int d=0;d<3;d++){
                int n_r = cur_r+d_r[d];
                int n_c = cur_c+d_c[d];
                
                if(!visited.contains(n_r +" "+ n_c)){
                    //q에 넣기
                    erase_set.add(n_r+" "+n_c);
                    visited.add(n_r +" "+ n_c);
                    q.add(new int[]{n_r,n_c});
                }
                }
            }
            
            
        }
        // System.out.println(erase_set.size());

        for(String i:erase_set){
            String[] cur_e = i.split(" ");
            int e_r = Integer.parseInt(cur_e[0]);
            int e_c = Integer.parseInt(cur_e[1]);
            cnt += 1;
            board_char[e_r][e_c] = '!';
        }
        // System.out.println(r+" "+c+" "+cnt);
        return cnt;
        
    }
    
    public boolean check(int r, int c,int r_m, int c_n){
        if(r>=0 && r<r_m && c>=0 && c<c_n){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean threeCheck(int r, int c){
        int right_r =r;
        int right_c =c+1;
        int down_r =r+1;
        int down_c =c;
        int di_r= r+1;
        int di_c= c+1;
        if(check(right_r,right_c,board_char.length,board_char[0].length) &&
           check(down_r,down_c,board_char.length,board_char[0].length) 
           && check(di_r, di_c,board_char.length,board_char[0].length )){
            if(board_char[right_r][right_c] == board_char[r][c] &&
              board_char[down_r][down_c] == board_char[r][c] &&
              board_char[di_r][di_c] == board_char[r][c] ){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
        
    }
}