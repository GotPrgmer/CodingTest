import java.util.*;
import java.io.*;
public class Main {
    static int[][] board;
    static int[] ans;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = new int[2];
        cut(0, 0, N);
        StringBuilder sb = new StringBuilder();
        sb.append(ans[0]).append("\n").append(ans[1]);
        System.out.println(sb);
    }
    // curR,curC에서 한변의 크기가 size인 색종이에서 파란색 색종이, 하얀색 색종이를 구하는 재귀함수
    private static void cut(int curR, int curC, int size){
        if(size == 0){
            return;
        }
        //같으면
        if(check(curR,curC,size)){
            ans[board[curR][curC]]++;
        }
        else{
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    cut(curR+size/2*i, curC+size/2*j, size / 2);
                }
            }
        }

    }
    private static boolean check(int curR, int curC, int size){
        int color = board[curR][curC];
        for(int i=curR;i<curR+size;i++){
            for(int j=curC;j<curC+size;j++){
                if (color != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
