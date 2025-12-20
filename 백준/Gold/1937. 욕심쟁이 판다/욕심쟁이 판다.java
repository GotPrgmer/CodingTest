import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] d_r = {-1, 0, 1, 0};
    static int[] d_c = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[501][501];
        StringTokenizer st;
        List<Cell> list = new ArrayList<>();
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                list.add(new Cell(i, j, board[i][j]));
            }
        }
        list.sort((i,j) -> {
            return i.v - j.v;
        });
        int[][] dp = new int[501][501];
        int ans = 0;
        for (int i = 0; i < list.size(); i++){
            Cell c = list.get(i);
            int cur_r = c.r;
            int cur_c = c.c;
            int cur_v = c.v;
            int tmp = 0;
            //현재를 중심으로 작은게 있을 경우 누적시킨다.
            for(int d=0;d<4;d++){
                int n_r = cur_r+d_r[d];
                int n_c = cur_c+d_c[d];
                if(1>n_r || n_r>n) continue;
                if(1>n_c || n_c>n) continue;
                if(board[n_r][n_c] >= cur_v) continue;
                tmp = Math.max(dp[n_r][n_c],tmp);
            }
            tmp+= 1;
            ans = Math.max(ans,tmp);

            dp[cur_r][cur_c] = tmp;
        }
        System.out.println(ans);
    }
    public static class Cell{
        int r;
        int c;
        int v;
        Cell(int r, int c, int v){
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
}
