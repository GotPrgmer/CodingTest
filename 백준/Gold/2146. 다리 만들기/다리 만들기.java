import java.io.*;
import java.util.*;
public class Main {
    static int[][] island;
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,1,0,-1};
    static int N;
    static int[][] arr;
    static boolean[][] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 섬 구분하기
        island = new int[N][N];
        int cnt = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(island[i][j]==0 && arr[i][j] == 1){
                    bfsSeperate(i,j,cnt);
                    cnt++;
                }
            }
        }
//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(island[i]));
//        }
        check = new boolean[N][N];
        int minVal = Integer.MAX_VALUE;
        // bfs돌리기
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(island[i][j] > 0){
                    check = new boolean[N][N];
                    int res = bfs(i,j);
                    if(res == -1) continue;
                    if(minVal <= res) continue;
//                    System.out.println(res);
                    minVal = res;
                }
            }
        }
        System.out.println(minVal);

    }
    public static void bfsSeperate(int i, int j, int cnt){
        Queue<Pair2573> q = new ArrayDeque<>();
        q.add(new Pair2573(i,j,0));
        island[i][j] = cnt;
        while(!q.isEmpty()){
            Pair2573 p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int d=0;d<4;d++){
                int n_x = x + d_x[d];
                int n_y = y + d_y[d];
                if(!check(n_x,n_y,N)) continue;
                if(island[n_x][n_y] != 0) continue;
                if(arr[n_x][n_y] == 0) continue;
                island[n_x][n_y] = cnt;
                q.add(new Pair2573(n_x,n_y,0));
            }
        }
    }

    public static boolean check(int x, int y, int n){
        return x>=0 && x<n && y>=0 && y<n;
    }

    public static int bfs(int i, int j){
        Queue<Pair2573> q = new ArrayDeque<>();
        q.add(new Pair2573(i,j,0));
        int num = island[i][j];
        check[i][j] = true;
        while(!q.isEmpty()){
            Pair2573 p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;
            if(island[x][y] != num && island[x][y] != 0){
                return cnt-1;
            }
            for(int d=0;d<4;d++){
                int n_x = x + d_x[d];
                int n_y = y + d_y[d];
                if(!check(n_x,n_y,N)) continue;
                if(check[n_x][n_y] || island[n_x][n_y] == num) continue;
                check[n_x][n_y] = true;
                q.add(new Pair2573(n_x,n_y,cnt+1));
            }
        }
        return -1;
    }

}
class Pair2573{
    int x;
    int y;
    int cnt;
    Pair2573(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
