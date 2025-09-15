import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] board;
    static int[][][] dist;
    static Queue<Pair3> q;
    static int[] d_x = {0,0,-1,0,1,0};
    static int[] d_y = {0,0,0,1,0,-1};
    static int[] d_h = {-1,1,0,0,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // m이 열의 수, n이 행의 수, h는 높이
        String[] m_n_h = br.readLine().split(" ");
        int m = Integer.parseInt(m_n_h[0]);
        int n = Integer.parseInt(m_n_h[1]);
        int h= Integer.parseInt(m_n_h[2]);
        board = new int[h][n][m];
        dist = new int[h][n][m];
        q = new LinkedList<>();
        StringTokenizer st;
        //board 채우기
        for(int k=0;k<h;k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    board[k][i][j] = tmp;
                }
            }
        }

        // dist 초기화
        for(int k=0;k<h;k++){
            for(int i=0;i<n;i++){
                Arrays.fill(dist[k][i],-1);
//                System.out.println(k+" "+i);
//                System.out.println(Arrays.toString(dist[k][i]));
            }
        }
        // 1인 것들 방문처리하고 큐에 넣기

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<h;k++) {
                    if(board[k][i][j] == 1){
                        dist[k][i][j] = 0;
                        q.add(new Pair3(i,j,k));
                    }
                }
            }
        }

        //bfs돌리기
        while(!q.isEmpty()){
            Pair3 cur = q.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int cur_h = cur.h;
//            System.out.println(cur_x +" "+cur_y +" "+cur_h);
            for(int d=0;d<6;d++){
                int n_x = cur_x +d_x[d];
                int n_y = cur_y + d_y[d];
                int n_h = cur_h + d_h[d];
                if(n_x<0 || n_x>=n || n_y<0 || n_y>=m || n_h<0 || n_h>=h) continue;
                if(dist[n_h][n_x][n_y] != -1 || board[n_h][n_x][n_y] == -1) continue;
                dist[n_h][n_x][n_y] = dist[cur_h][cur_x][cur_y]+1;
                q.add(new Pair3(n_x,n_y,n_h));
            }
        }
        boolean isFull = true;
        int ans = -1;
        for(int k=0;k<h;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(dist[k][i][j] == -1 && board[k][i][j] != -1){
                        isFull = false;
                        ans = -1;
                        break;
                    }
                    ans = Math.max(ans,dist[k][i][j]);
                }
                if(!isFull){
                    break;
                }
            }
            if(!isFull){
                break;
            }
        }
        System.out.println(ans);



    }
}
class Pair3{
    int x;
    int y;
    int h;
    Pair3(int x, int y, int h){
        this.x = x;
        this.y = y;
        this.h = h;
    }
}
