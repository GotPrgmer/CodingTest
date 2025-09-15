import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] visited;
    static int[][] board;
    static int max_area = 0;
    static Queue<Pair> queue;
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        String[] mAndN = br.readLine().split(" ");
        int n = Integer.parseInt(mAndN[0]);
        int m = Integer.parseInt(mAndN[1]);
        int num_drawing = 0;
        StringTokenizer st;
        board = new int[n][m];
        visited = new int[n][m];
        queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // board[i][j]가 1이면서 visited가 방문하지 않았다면 bfs시작
                if(board[i][j] == 1 && visited[i][j] != 1){
                    num_drawing += 1;
                    bfs(i,j,n,m);
                }
            }
        }
        System.out.println(num_drawing);
        System.out.println(max_area);


    }
    static void bfs(int i, int j, int n, int m){
        int turn_out = 0;
        // 방문처리하고 큐에 넣기
        visited[i][j] = 1;
        queue.add(new Pair(i,j));
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            turn_out += 1;
            int cur_x = cur.x;
            int cur_y = cur.y;
            for(int d=0;d<4;d++){
                int n_x = cur_x+d_x[d];
                int n_y = cur_y+d_y[d];
                if(n_x<0 || n_x>=n || n_y<0 || n_y>=m){
                    continue;
                }
                if(visited[n_x][n_y] == 1 || board[n_x][n_y] == 0){
                    continue;
                }
                visited[n_x][n_y] = 1;
                queue.add(new Pair(n_x,n_y));
            }

        }
        max_area = Math.max(max_area,turn_out);
    }
}
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
