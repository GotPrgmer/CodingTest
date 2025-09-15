import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static Queue<Pair2> q;
    static int[][] dist;
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] m_n = br.readLine().split(" ");
        // m은 열 n은 행
        int m = Integer.parseInt(m_n[0]);
        int n = Integer.parseInt(m_n[1]);
        board = new int[n][m];
        q = new LinkedList<>();
        dist = new int[n][m];
        StringTokenizer st;
        for(int i=0;i<n;i++){
           st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(board[i]));
        }
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],-1);
        }
        // 1인 값들 방문처리하고 큐에 넣기
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 1){
                    dist[i][j] = 0;
                    q.add(new Pair2(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Pair2 cur = q.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
//            System.out.println(cur_x+" "+cur_y);
            for(int d=0;d<4;d++){
                int n_x = cur_x+d_x[d];
                int n_y = cur_y+d_y[d];
                if(n_x<0 || n_x>=n || n_y<0 || n_y>=m) continue;
                if(dist[n_x][n_y] != -1 || board[n_x][n_y] == -1) continue;
                dist[n_x][n_y] = dist[cur_x][cur_y] + 1;
                q.add(new Pair2(n_x,n_y));
            }
        }
        // 방문안한게 있으면 -1이고 그렇지않으면 가장 큰 숫자를 찾자
        boolean is_all_visit = true;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dist[i][j] == -1 && board[i][j] != -1){
                    is_all_visit = false;
                    break;
                }
                ans = Math.max(ans,dist[i][j]);
            }
//            System.out.println(Arrays.toString(dist[i]));
            if(!is_all_visit){
                ans = -1;
                break;
            }
        }
        System.out.println(ans);

    }
}
class Pair2{
    int x;
    int y;
    Pair2(int x, int y){
        this.x = x;
        this.y = y;
    }
}
