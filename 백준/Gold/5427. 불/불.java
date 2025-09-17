import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int[][] fire;
    static int[][] sang;
    static Queue<Pair8> q;
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            // w는 열 h는 행
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            fire = new int[h][w];
            sang = new int[h][w];
            board = new char[h][w];

            //board, fire, sang 초기화
            for(int i = 0;i<h;i++){
                Arrays.fill(fire[i],-1);
                Arrays.fill(sang[i],-1);
                char[] tmp = br.readLine().toCharArray();
                for(int j=0;j<w;j++){
                    board[i][j] = tmp[j];
                }
//                System.out.println(Arrays.toString(board[i]));
            }
            // 큐 초기화
            q = new LinkedList<>();

            //불이 있는 곳을 시작점으로 불 방문처리
            for(int i = 0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(board[i][j] == '*'){
                        fire[i][j] = 0;
                        q.add(new Pair8(i,j));
                    }
                }
            }
            while(!q.isEmpty()){
                Pair8 cur =q.poll();
                int cur_x = cur.x;
                int cur_y = cur.y;
                for(int d=0;d<4;d++){
                    int n_x = cur_x + d_x[d];
                    int n_y = cur_y + d_y[d];
                    if(n_x<0 || n_x>=h || n_y<0 || n_y>=w) continue;
                    if(fire[n_x][n_y] != -1 || board[n_x][n_y] == '#') continue;
                    fire[n_x][n_y] = fire[cur_x][cur_y]+1;
                    q.add(new Pair8(n_x,n_y));
                }
            }
            //상근이가 있는 곳을 시작점으로 상근이 방문처리
            for(int i = 0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(board[i][j] == '@'){
//                        System.out.println(i+" "+j);
                        sang[i][j] = 0;
                        q.add(new Pair8(i,j));
                    }
                }
            }
            boolean isEscape = false;
            while(!q.isEmpty()){
                Pair8 cur =q.poll();
                int cur_x = cur.x;
                int cur_y = cur.y;
//                System.out.println(cur_x+" "+cur_y);

                for(int d=0;d<4;d++){
                    int n_x = cur_x + d_x[d];
                    int n_y = cur_y + d_y[d];
                    if(n_x<0 || n_x>=h || n_y<0 || n_y>=w){
                        System.out.println(sang[cur_x][cur_y]+1);
                        isEscape = true;
                        break;
                    }
                    if(sang[n_x][n_y] != -1 || board[n_x][n_y] == '#') continue;
                    if(sang[cur_x][cur_y]+1 >= fire[n_x][n_y] && fire[n_x][n_y] != -1) continue;
                    sang[n_x][n_y] = sang[cur_x][cur_y]+1;
                    q.add(new Pair8(n_x,n_y));
                }
                if(isEscape){
                    break;
                }
            }
            if(!isEscape){
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
class Pair8{
    int x;
    int y;
    Pair8(int x, int y){
        this.x =x;
        this.y =y;
    }
}
