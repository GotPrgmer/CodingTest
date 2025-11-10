import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int P;
    static int[] numP;
    static int[][] board;
    static int[][] visited;
    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, 1, 0, -1};
    static int[] ans;
    static PriorityQueue<Pair16920> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        numP = new int[P+1];
        board = new int[N][M];
        ans = new int[P+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<P+1;i++){
            numP[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                if (c[j] == '#') board[i][j] = -1;
                else if (c[j] != '.') board[i][j] = c[j] - '0';
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<P+1;i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);


    }
    static void bfs() {

        Queue<Pair16920>[] q = new ArrayDeque[P + 1];
        for (int i = 1; i <= P; i++) q[i] = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) {
                    int num = board[i][j];
                    q[num].add(new Pair16920(i, j));
                    ans[num]++;
                }
            }
        }
        boolean expanded = true;
        while (expanded) {
            expanded = false;
            for (int i = 1; i < P + 1; i++) {
                int moveLimit = numP[i];
                Queue<Pair16920> tempQ = new ArrayDeque<>();
                while (!q[i].isEmpty()) {
                    for (int s = 0, size = q[i].size(); s < size; s++) {
                        Pair16920 cur = q[i].poll();
                        for (int d = 0; d < 4; d++) {
                            int nX = cur.x + dX[d];
                            int nY = cur.y + dY[d];
                            if (check(nX, nY)) continue;
                            if (board[nX][nY] != 0) continue;
                            board[nX][nY] = i;
                            ans[i]++;
                            tempQ.add(new Pair16920(nX, nY));
                            // 하나라도 확장하면
                            expanded = true;
                        }
                    }
                    moveLimit--;
                    if (moveLimit == 0) break;
                    q[i].addAll(tempQ);
                    tempQ = new ArrayDeque<>();
                }
                q[i] = tempQ;
            }

        }
    }
    static boolean check(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
    static class Pair16920{
        int x;
        int y;
        Pair16920(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
