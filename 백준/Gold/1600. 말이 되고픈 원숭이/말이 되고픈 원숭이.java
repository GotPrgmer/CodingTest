import java.util.*;
import java.io.*;
// 내 힘으로 못품
// GPT로 힌트 얻어서 품
// visited에 숫자를 넣어서 구분한다고 생각했는데
// K에 따라 탐색 범위가 달라지므로 차원을 하나 높여서 풀어야 했다.
public class Main {
    static int[][] board;
    static boolean[][][] visited;
    static int[] dR = {-1, 0, 1, 0};
    static int[] dC = {0, 1, 0, -1};
    static int[] dxR = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dxC = {1, 2, 2, 1, -1, -2, -2, -1};
    static int H;
    static int W;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][W];
        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());

    }
    public static int bfs(){
        visited = new boolean[H][W][K+1];
        Queue<Pair1600> q = new ArrayDeque<>();
        visited[0][0][0] = true;
        q.add(new Pair1600(0, 0, 0,0));
        while(!q.isEmpty()){
            Pair1600 cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curK = cur.k;
            int curT = cur.t;
            //curK가 K미만인지 확인 후 미만이면 말방향으로 4방향 가기
            if(curX == H-1 && curY == W-1){
                return curT;
            }

            if(curK < K ){
                for(int d=0;d<8;d++){
                    int nR = curX+dxR[d];
                    int nC = curY+dxC[d];
                    if(!check(nR,nC)) continue;
                    if (visited[nR][nC][curK+1]) continue;
                    if(board[nR][nC]==1) continue;
                    visited[nR][nC][curK+1] = true;
                    q.add(new Pair1600(nR, nC, curK + 1, curT + 1));
                }
            }
            for(int d=0;d<4;d++){
                int nR = curX+dR[d];
                int nC = curY+dC[d];
                if(!check(nR,nC)) continue;
                if (visited[nR][nC][curK]) continue;
                if(board[nR][nC]==1) continue;
                visited[nR][nC][curK] = true;
                q.add(new Pair1600(nR, nC, curK, curT + 1));
            }
        }
        return -1;

    }
    public static boolean check(int x, int y){
        return x >= 0 && x < H && y >= 0 && y < W;
    }
    public static class Pair1600{
        int x;
        int y;
        int k;
        int t;
        public Pair1600(int x, int y, int k, int t){
            this.x = x;
            this.y = y;
            this.k = k;
            this.t = t;
        }
    }
}
