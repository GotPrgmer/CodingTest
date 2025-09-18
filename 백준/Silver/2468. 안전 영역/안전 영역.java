import java.util.*;
import java.io.*;
public class Main {
    static int[][] board;
    static int[][] water;
    static int[][] visited;
    static Queue<Pair11> q;
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        water = new int[N][N];
        int ans = 0;
        StringTokenizer st;
        // board 초기화
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //최대 비높이 계산(for)
        int max_rain = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                max_rain = Math.max(board[i][j],max_rain);
            }
        }

        // 비 for
            // 비로 채우기(이중 for)
            // bfs(이준 for)
        for(int rain =0;rain<max_rain+1;rain++){
            water = new int[N][N];
            visited = new int[N][N];
            q = new LinkedList<>();
            int tmp = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(board[i][j]<=rain){
                        water[i][j] = 1;
                    }
                }
            }
            // 안전 영역 개수 구하기
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(water[i][j] == 0 && visited[i][j] == 0){
                        tmp += 1;
                        bfs(i,j,N);
                    }
                }
            }
            ans = Math.max(ans,tmp);

        }
        System.out.println(ans);


    }
    static void bfs(int x, int y, int N){
        visited[x][y] = 1;
        q.add(new Pair11(x,y));
        while(!q.isEmpty()){
            Pair11 cur = q.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            for(int d=0;d<4;d++){
                int n_x = cur_x + d_x[d];
                int n_y = cur_y + d_y[d];
                if(n_x<0 || n_x >= N || n_y<0 || n_y >=N) continue;
                if(visited[n_x][n_y] == 1 || water[n_x][n_y] == 1) continue;
                visited[n_x][n_y] = 1;
                q.add(new Pair11(n_x,n_y));
            }
        }
    }

}
class Pair11{
    int x;
    int y;
    Pair11(int x, int y){
        this.x = x;
        this.y = y;
    }
        }
