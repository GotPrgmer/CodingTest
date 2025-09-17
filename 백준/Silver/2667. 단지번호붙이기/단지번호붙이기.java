import java.util.*;
import java.io.*;
public class Main {
    static int[][] board;
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,1,0,-1};
    static Queue<Pair10> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int area = 0;
        board = new int[N][N];
        q = new LinkedList<>();
        for(int i=0;i<N;i++){
            char[] input = br.readLine().toCharArray();
            for(int j=0;j<N;j++){
                board[i][j] = input[j] - '0';
            }
        }
        List<Integer> num_house = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == 1){
                    area += 1;
                    board[i][j] = 2;
                    q.add(new Pair10(i,j));
                    int tmp = 0;
                    while(!q.isEmpty()){
                        tmp += 1;
                        Pair10 cur = q.poll();
                        int cur_x = cur.x;
                        int cur_y = cur.y;
                        for(int d=0;d<4;d++){
                            int n_x = cur_x+d_x[d];
                            int n_y = cur_y +d_y[d];
                            if(n_x<0 || n_x>=N || n_y<0 || n_y>=N) continue;
                            if(board[n_x][n_y] != 1) continue;
                            board[n_x][n_y] = 2;
                            q.add(new Pair10(n_x,n_y));
                        }
                    }
                    num_house.add(tmp);
                }
            }
        }
        System.out.println(area);
        Collections.sort(num_house);
        for(int i=0;i<area;i++){
            System.out.println(num_house.get(i));
        }
    }
}
class Pair10{
    int x;
    int y;
    Pair10(int x, int y){
        this.x = x;
        this.y = y;
    }
}
