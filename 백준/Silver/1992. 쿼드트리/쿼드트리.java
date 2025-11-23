import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //board 초기화
        board = new int[N][N];
        for(int i=0;i<N;i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(String.valueOf(line[j]));
            }
        }
        System.out.println(compress(0, 0, N));
    }
    private static String compress(int curR, int curC,int size){
        if(size == 0){
            return "";
        }
        if (check(curR, curC, size)) {
            return String.valueOf(board[curR][curC]);
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    sb.append(compress(curR + i * size / 2, curC + j * size / 2, size / 2));
                }
            }
            sb.append(")");
            return sb.toString();
        }
    }
    private static boolean check(int curR, int curC, int size){
        for(int i=curR;i<curR+size;i++){
            for(int j=curC;j<curC+size;j++){
                if (board[curR][curC] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
