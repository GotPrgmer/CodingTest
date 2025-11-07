import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][][] visited;
    static int[][] board;
    static int[] dX = {-1, 0, 1, 0,0};
    static int[] dY = {0, 1, 0, -1,0};
    static int N;
    static int M;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[N][M][K+1][2];
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
            for(int day = 0;day<2;day++){
                if (visited[N - 1][M - 1][k][day] != 0)
                    ans = Math.min(ans, visited[N - 1][M - 1][k][day]);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    public static void bfs(){
        Queue<Pair16933> q = new ArrayDeque<>();
        q.add(new Pair16933(0, 0, K,0));
        // 0은 낮 1은 밤
        visited[0][0][K][0] = 1;
        while(!q.isEmpty()){
            Pair16933 cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curK = cur.k;
            int curDay = cur.day;
            for(int d=0;d<dX.length;d++){
                int nX = curX + dX[d];
                int nY = curY + dY[d];
                if(nX==curX && nY==curY && visited[nX][nY][curK][(curDay+1)%2] == 0 && curDay == 1){
                    visited[nX][nY][curK][(curDay+1)%2] = visited[nX][nY][curK][curDay]+1;
                    q.add(new Pair16933(nX, nY, curK, 0));
                }

                if(nX<0 || nX>=N || nY<0 || nY>=M) continue;
                if(board[nX][nY] == 0 && visited[nX][nY][curK][(curDay+1)%2] == 0){
                    visited[nX][nY][curK][(curDay+1)%2] = visited[curX][curY][curK][curDay]+1;
                    q.add(new Pair16933(nX, nY, curK, (curDay + 1) % 2));                
                }
                else if(board[nX][nY] == 1 && curDay == 0){
                    if(curK>0 && visited[nX][nY][curK-1][(curDay+1)%2] == 0){
                        visited[nX][nY][curK-1][(curDay+1)%2] = visited[curX][curY][curK][curDay]+1;
                        q.add(new Pair16933(nX, nY, curK-1, (curDay + 1) % 2));                    }
                }
            }
        }
    }
    static class Pair16933{
        int x;
        int y;
        int k;
        int day;
        Pair16933(int x, int y, int k, int day){
            this.x = x;
            this.y = y;
            this.k = k;
            this.day = day;
        }
    }
}
