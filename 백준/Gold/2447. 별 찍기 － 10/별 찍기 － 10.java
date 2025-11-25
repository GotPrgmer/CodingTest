import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        star(0,0, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            for(int j=0;j<N;j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    private static void star(int x, int y, int N){
        if(N==1){
            board[x][y] = '*';
            return;
        }
        else{
            int size = N/3;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(i!=1 || j!=1){
                        star(x+size*i,y+size*j,size);
                    }
                    else{
                        blank(x+size*i,y+size*j,size);
                    }
                }
            }
        }
    }
    private static void blank(int x,int y, int size){
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                board[i][j] = ' ';
            }
        }
    }
}
