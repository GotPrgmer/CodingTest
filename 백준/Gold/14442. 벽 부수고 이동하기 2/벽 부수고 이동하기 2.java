import java.util.*;
import java.io.*;
public class Main {
    static int[][][] visited;
    static int[][] board;
    static int[] dX = {-1, 0, 1, 0,};
    static int[] dY = {0, 1, 0, -1};
    static int N;
    static int M;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[N][M][K+1];
        board = new int[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            char[] c = s.toCharArray();
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(String.valueOf(c[j]));
            }
        }
        bfs();
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k <= K; k++) {
            if (visited[N - 1][M - 1][k] != 0)
                ans = Math.min(ans, visited[N - 1][M - 1][k]);
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    public static void bfs(){
        Queue<Pair14442> q = new ArrayDeque<>();
        q.add(new Pair14442(0, 0, K));
        visited[0][0][K] = 1;
        while(!q.isEmpty()){
            Pair14442 cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curK = cur.k;
            for(int d=0;d<4;d++){
                int nX = curX + dX[d];
                int nY = curY + dY[d];
                if(nX<0 || nX>=N || nY<0 || nY>=M) continue;
                if(board[nX][nY] == 0 && visited[nX][nY][curK] == 0){
                    visited[nX][nY][curK] = visited[curX][curY][curK]+1;
                    q.add(new Pair14442(nX, nY, curK));
                }
                else if(board[nX][nY] == 1){
                    if(curK>0 && visited[nX][nY][curK-1] == 0){
                        visited[nX][nY][curK-1] = visited[curX][curY][curK]+1;
                        q.add(new Pair14442(nX, nY, curK-1));
                    }
                }
            }
        }
    }
    static class Pair14442{
        int x;
        int y;
        int k;
        Pair14442(int x, int y, int k){
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}

