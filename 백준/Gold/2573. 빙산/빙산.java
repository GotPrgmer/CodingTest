import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
    static int[][] zero;
    static int N;
    static int M;
    static int[] d_x = {-1, 0, 1, 0};
    static int[] d_y = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        zero = new int[N][M];
        //이차배열 초기화
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;
        while(true){
            year++;
            //빙산 녹이기
            melting();
            int result = cntGracier();
            if(result == 1) continue;
            else if(result == 0){
                System.out.println(0);
                break;
            }
            else if(result == 2){
                System.out.println(year);
                break;
            }
        }


    }
    static void melting(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]>0){
                    for(int d=0;d<4;d++){
                        int n_x = i+d_x[d];
                        int n_y = j+d_y[d];
                        if(check(n_x,n_y) && arr[n_x][n_y] == 0) zero[i][j]++;
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = Math.max(0, arr[i][j] - zero[i][j]);
                zero[i][j] = 0;
            }
        }
    }
    static boolean check(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static int cntGracier(){
        int x=-1;
        int y=-1;
        int cnt1 = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]>0){
                    x = i;
                    y = j;
                    cnt1++;
                }
            }
        }
        if(cnt1==0) return 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y));
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        int cnt2 = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int cur_x = p.x;
            int cur_y = p.y;
            cnt2++;
            for(int d=0;d<4;d++){
                int n_x = cur_x+d_x[d];
                int n_y = cur_y +d_y[d];
                if(!check(n_x,n_y) || arr[n_x][n_y]<=0 || visited[n_x][n_y]) continue;
                visited[n_x][n_y] = true;
                q.add(new Pair(n_x, n_y));
            }
        }
        if(cnt1==cnt2) return 1;
        return 2;
    }
}
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x =x;
        this.y = y;
    }
}
