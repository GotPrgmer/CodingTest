import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] dist;
    static int[][] board;
    static Queue<Pair1> queue;
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_m = br.readLine().split(" ");
        int n = Integer.parseInt(n_m[0]);
        int m = Integer.parseInt(n_m[1]);
        board = new int[n][m];
        queue = new LinkedList<>();
        dist = new int[n][m];
        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }
        //dist 초기화
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = -1;
            }
        }
        dist[0][0] = 1;
        queue.add(new Pair1(0,0));
        while(!queue.isEmpty()){
            Pair1 cur = queue.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            for(int d=0;d<4;d++){
                int n_x = cur_x + d_x[d];
                int n_y = cur_y + d_y[d];
                if(n_x < 0 || n_x>=n || n_y<0 || n_y>=m){
                    continue;
                }
                if(dist[n_x][n_y] != -1 || board[n_x][n_y] == 0){
                    continue;
                }
                dist[n_x][n_y] = dist[cur_x][cur_y]+1;
                queue.add(new Pair1(n_x,n_y));
            }
        }
        System.out.println(dist[n-1][m-1]);
    }

}
class Pair1{
    int x;
    int y;
    Pair1(int x,int y){
        this.x = x;
        this.y = y;
    }
}
