import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] d_x = {-1, 0, 1, 0};
    static int[] d_y = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[500][500];

        List<Coop> list = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                list.add(new Coop(i, j));
            }
        }
        list.sort((c1, c2) -> board[c1.x][c1.y] - board[c2.x][c2.y]);

        int[][] dp = new int[500][500];
        dp[M-1][N-1] = 1;
        for(int i=0;i<list.size();i++){
            Coop cur = list.get(i);
            //상하좌우해서 해당 값보다 크면 현재값을 다음값에 누적해주기.
            for(int d=0;d<4;d++){
                int n_x = cur.x+d_x[d];
                int n_y = cur.y+d_y[d];
                if(n_x<0 || n_x>=M) continue;
                if(n_y<0 || n_y>=N) continue;
                if (board[n_x][n_y] > board[cur.x][cur.y]) {
                    dp[n_x][n_y] += dp[cur.x][cur.y];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
    static class Coop{
        int x;
        int y;

        Coop(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
