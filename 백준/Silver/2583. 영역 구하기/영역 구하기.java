import java.util.*;
import java.io.*;
public class Main {
    static int[][] board;
    static Queue<Pair9> q;
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new int[M][N];
        q = new LinkedList<>();
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            // y1 x1 y2 x2
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            color(x1,y1,x2,y2,M);
        }

        int area_number = 0;
        List<Integer> ans_list = new ArrayList<>();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == 0){
                    area_number += 1;
                    int tmp = 0;
                    board[i][j] = 1;
                    q.add(new Pair9(i,j));
                    while(!q.isEmpty()){
                        Pair9 cur = q.poll();
                        tmp += 1;
                        int cur_x = cur.x;
                        int cur_y = cur.y;
                        for(int d=0;d<4;d++){
                            int n_x = cur_x+d_x[d];
                            int n_y = cur_y+d_y[d];
                            if(n_x<0 || n_x>=M || n_y<0 || n_y>=N) continue;
                            if(board[n_x][n_y] != 0) continue;
                            board[n_x][n_y] = 1;
                            q.add(new Pair9(n_x,n_y));
                        }
                    }
                    ans_list.add(tmp);
                }
            }
        }
        System.out.println(area_number);
        Collections.sort(ans_list);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ans_list.size();i++){
            sb.append(ans_list.get(i)).append(" ");
        }
        System.out.println(sb);


    }
    static void color(int x1, int y1,int x2, int y2, int M){
        for(int i=M-x2;i<M-x1;i++){
            for(int j=y1;j<y2;j++){
                board[i][j] = -1;
            }
        }
    }
}
class Pair9{
    int x;
    int y;
    Pair9(int x, int y){
        this.x = x;
        this.y = y;
    }
}
