import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] board;
    static int[][] jihun;
    static int[][] fire;
    static Queue<Pair4> q;
    static int[] d_r = {-1,0,1,0};
    static int[] d_c = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // R은 행, C는 열
        String[] R_C = br.readLine().split(" ");
        int R = Integer.parseInt(R_C[0]);
        int C = Integer.parseInt(R_C[1]);
        jihun = new int[R][C];
        fire = new int[R][C];
        //jihun과 fire 초기화
        for(int i=0;i<R;i++){
            Arrays.fill(jihun[i],-1);
            Arrays.fill(fire[i],-1);
        }


        board = new char[R][C];
        for(int i=0;i<R;i++){
            String tmp = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = tmp.charAt(j);
            }
        }
        //불 bfs돌려서 distance 구하기
        //불 시작점 추가
        q = new LinkedList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j] == 'F'){
                    fire[i][j] = 0;
                    q.add(new Pair4(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Pair4 cur = q.poll();
            int cur_r = cur.r;
            int cur_c = cur.c;
            for(int d=0;d<4;d++){
                int n_r = cur_r + d_r[d];
                int n_c = cur_c + d_c[d];
                if(n_r<0 || n_r>=R || n_c<0 || n_c>=C) continue;
                if(fire[n_r][n_c] != -1 || board[n_r][n_c] == '#') continue;
                fire[n_r][n_c] = fire[cur_r][cur_c]+1;
                q.add(new Pair4(n_r,n_c));
            }
        }

        //지훈 bfs돌려서 가능한 시간으로 distance 구하기
        q = new LinkedList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j] == 'J'){
                    jihun[i][j] = 0;
                    q.add(new Pair4(i,j));
                    break;
                }
            }
        }
        while(!q.isEmpty()){
            Pair4 cur = q.poll();
            int cur_r = cur.r;
            int cur_c = cur.c;
            for(int d=0;d<4;d++){
                int n_r = cur_r + d_r[d];
                int n_c = cur_c + d_c[d];
                if(n_r<0 || n_r>=R || n_c<0 || n_c>=C) continue;
                if(jihun[n_r][n_c] != -1 || board[n_r][n_c] == '#' || board[n_r][n_c] =='F') continue;
                if(jihun[cur_r][cur_c]+1 >= fire[n_r][n_c] && fire[n_r][n_c] != -1) continue;
                jihun[n_r][n_c] = jihun[cur_r][cur_c]+1;
                q.add(new Pair4(n_r,n_c));
            }
        }
        boolean isEscaped = false;
        int ans = R*C+1;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++){
                if(i==0 || j==0 || i==R-1 || j==C-1){
                    //한번이라도 -1이 아닌값이 나오면 탈출했다는 것임
                    if(jihun[i][j] != -1){
                        isEscaped = true;
                        ans = Math.min(ans,jihun[i][j]);
                    }
                }
//                System.out.println(jihun[i][j]);
            }
        }
        if(!isEscaped){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(ans+1);
        }
    }


}

class Pair4{
    int r;
    int c;
    Pair4(int r, int c){
        this.r = r;
        this.c = c;
    }
}

