import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[][] visited;
    static Queue<Pair5> q;
    static int[] d_r = {-1,0,1,0};
    static int[] d_c = {0,1,0,-1};
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        ans = new int[t];
        int cnt = 0;
        StringTokenizer st;
        while(cnt<t){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            visited = new int[N][M];
            q = new LinkedList<>();
            //board 채우기
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
//                System.out.println(x+" "+y);
                board[x][y] = 1;
            }
            int tmp = 0;
            //순회하면서 bfs호출하기
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(board[i][j] == 1 && visited[i][j] != 1){
                        tmp += 1;
                        visited[i][j] = 1;
                        q.add(new Pair5(i,j));
                        while(!q.isEmpty()){
                            Pair5 cur = q.poll();
                            int cur_x = cur.x;
                            int cur_y = cur.y;
                            for(int d=0;d<4;d++){
                                int n_x = cur_x+d_r[d];
                                int n_y = cur_y + d_c[d];
                                if(n_x<0 || n_x>=N || n_y<0 || n_y>=M) continue;
                                if(visited[n_x][n_y] == 1 || board[n_x][n_y] == 0) continue;
                                visited[n_x][n_y] = 1;
                                q.add(new Pair5(n_x,n_y));
                            }
                        }
                    }
                }
            }
            ans[cnt] = tmp;
            cnt += 1;
        }
        for(int i=0;i<t;i++){
            System.out.println(ans[i]);
        }
    }
    static void bfs(){

    }
}
class Pair5{
    int x;
    int y;
    Pair5(int x, int y){
        this.x = x;
        this.y = y;
    }
}
