import java.util.*;
import java.io.*;

public class Main {
    static char[][][] board;
    static int[][][] visited;
    static int[] d_x = {0,0,-1,0,1,0};
    static int[] d_y = {0,0,0,1,0,-1};
    static int[] d_z = {1,-1,0,0,0,0};
    static Queue<Pair12> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            // L 층 수, R은 행 수, C는 열 수
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(L!=0 || R!=0 || C!=0){
                board = new char[L][R][C];
                visited = new int[L][R][C];
                q = new LinkedList<>();

                // board 초기화
                for(int k=0;k<L;k++){
                    for(int i=0;i<R;i++){
                        char[] c = br.readLine().toCharArray();
                        for(int j=0;j<C;j++){
                            board[k][i][j] = c[j];
                        }
                    }
                    br.readLine();
                }
                int start_x = -1;
                int start_y = -1;
                int start_z = -1;

                int end_x = -1;
                int end_y = -1;
                int end_z = -1;

                // S에서 시작해서 E로 끝나기
                for(int k=0;k<L;k++){
                    for(int i=0;i<R;i++){
                        for(int j=0;j<C;j++){
                            if(board[k][i][j] == 'S'){
                                start_x = i;
                                start_y = j;
                                start_z = k;
                            }
                            else if(board[k][i][j] == 'E'){
                                end_x = i;
                                end_y = j;
                                end_z = k;
                            }
                        }
                    }
                }

                for(int k=0;k<L;k++){
                    for(int i=0;i<R;i++){
                        Arrays.fill(visited[k][i],-1);
                    }
                }


                //visited체크하면서 bfs 돌기
                visited[start_z][start_x][start_y] = 0;
                q.add(new Pair12(start_x,start_y ,start_z));
                while(!q.isEmpty()){
                    Pair12 cur = q.poll();
                    int cur_z = cur.z;
                    int cur_x = cur.x;
                    int cur_y = cur.y;
                    for(int d=0;d<6;d++){
                        int n_z = cur_z+d_z[d];
                        int n_x = cur_x +d_x[d];
                        int n_y = cur_y+d_y[d];
                        if(n_x<0 || n_x>=R || n_y<0 || n_y>=C || n_z<0 || n_z>=L) continue;
                        if(visited[n_z][n_x][n_y] != -1 || board[n_z][n_x][n_y] == '#') continue;
                        visited[n_z][n_x][n_y] = visited[cur_z][cur_x][cur_y]+1;
                        q.add(new Pair12(n_x,n_y,n_z));
                    }
                }

                StringBuilder sb = new StringBuilder();
                if(visited[end_z][end_x][end_y] == -1){
                    sb.append("Trapped!");
                    System.out.println(sb);
                }
                else{
                    sb.append("Escaped in ").append(visited[end_z][end_x][end_y])
                            .append(" minute(s).");
                    System.out.println(sb);
                }

            }
            else{
                break;
            }


        }


    }
}

class Pair12{
    int x;
    int y;
    int z;
    Pair12(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}