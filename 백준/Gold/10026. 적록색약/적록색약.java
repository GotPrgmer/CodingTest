import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] board;
    static int[][] visited;
    static Queue<Pair6> q;
    static int[] d_r = {-1,0,1,0};
    static int[] d_c = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        //board 초기화
        for(int i=0;i<N;i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<N;j++){
                board[i][j] = c[j];
            }
        }
        //적록색약 아닌 사람
        int canRedGreen =0;
        int noRedGreen =0;
        visited = new int[N][N];
        q = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] == 0){
                    canRedGreen+=1;
                    bfs(i,j,N,board[i][j]);
                }
            }
        }

        //적록색약인 사람
        q = new LinkedList<>();
        visited = new int[N][N];
        //RED -> GREEN으로 바꾸기
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]=='G'){
                    board[i][j] = 'R';
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] == 0){
                    noRedGreen+=1;
                    bfs(i,j,N,board[i][j]);
                }
            }
        }
        System.out.println(canRedGreen+" "+noRedGreen);
    }
    static void bfs(int x, int y, int N, char c){
        visited[x][y] = 1;
        q.add(new Pair6(x, y));
        while(!q.isEmpty()){
            Pair6 cur = q.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            for(int d=0;d<4;d++){
                int n_x = cur_x + d_r[d];
                int n_y = cur_y + d_c[d];
                if(n_x<0 || n_x>=N || n_y<0 || n_y>=N) continue;
                if(visited[n_x][n_y] == 1 || board[n_x][n_y] != c) continue;
                visited[n_x][n_y] = 1;
                q.add(new Pair6(n_x,n_y));
            }
        }
    }

}
class Pair6{
    int x;
    int y;
    Pair6(int x, int y){
        this.x = x;
        this.y = y;
    }
}