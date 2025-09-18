import java.util.*;
import java.io.*;
public class Main {
    static int[][] board;
    static int[][][] visited;
    static Queue<Pair13> q;
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new int[N][M][2];
        // [x][y][1] -> 벽 뚫어서 도달한 거리
        // [x][y][0] -> 벽 뚫지 않고 도달한 거리
        q = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j][0]=-1;
                visited[i][j][1] = -1;
            }
        }

        for(int i=0;i<N;i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                board[i][j] = c[j]-'0';
            }
        }
        // bfs를 돌리는데 가로막힌 벽을 뚫었는지에 대한 boolean값을 줘서
        // 앞으로 나올 벽에 대해서 뚫을 수 있는지 없는지를 확인해보자.
        System.out.println(bfs(N,M));



    }
    static int bfs(int N, int M){
        visited[0][0][0] = 1;
        visited[0][0][1] = 1;
        q.add(new Pair13(0,0,0));
        while(!q.isEmpty()){
            Pair13 cur = q.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int cur_hit_wall = cur.hit_wall;
//            System.out.println(cur_x+" "+cur_y+" "+visited[cur_x][cur_y][cur_hit_wall]);
            if(cur_x == N-1 && cur_y == M-1) return visited[cur_x][cur_y][cur_hit_wall];

            for(int d=0;d<4;d++){
                int n_x = cur_x + d_x[d];
                int n_y = cur_y + d_y[d];
                if(n_x<0 || n_x>=N || n_y<0 || n_y>=M) continue;
                // 만약 cur_hit_wall이 false이면 그냥 추가하고
                // 뚫려있음
                if(board[n_x][n_y] == 0 && visited[n_x][n_y][cur_hit_wall] == -1){
                    visited[n_x][n_y][cur_hit_wall] = visited[cur_x][cur_y][cur_hit_wall]+1;
                    q.add(new Pair13(n_x,n_y,cur_hit_wall));
                }
                // 벽 뚫지 않았으면서 벽인 곳
                if(cur_hit_wall == 0 && board[n_x][n_y] == 1 && visited[n_x][n_y][1] == -1){
//                    System.out.println("벽 뚫음");
                    visited[n_x][n_y][1] = visited[cur_x][cur_y][cur_hit_wall]+1;
                    q.add(new Pair13(n_x,n_y,1));
                }
            }
        }
        return -1;
    }
}
class Pair13{
    int x;
    int y;
    int hit_wall;
    Pair13(int x, int y, int hitWall){
        this.x = x;
        this.y = y;
        this.hit_wall = hitWall;
    }
}