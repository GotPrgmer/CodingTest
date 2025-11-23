import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] board;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //board 초기화
        ans = new int[3];
        board = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paper(N, 0, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(ans[0]).append("\n").append(ans[1]).append("\n").append(ans[2]);
        System.out.println(sb);

    }
    private static void paper(int size,int curR, int curC){
        if(size == 0){
            return;
        }
        boolean isSame = true;
        int color = board[curR][curC];
        //같은지 확인
        for(int i=curR;i<curR+size;i++){
            for(int j=curC;j<curC+size;j++){
                if(color != board[i][j]){
                    isSame = false;
                    break;
                }
            }
            if(!isSame){
                break;
            }
        }
        //같음
        if(isSame){
//            System.out.println(color+" "+size+" "+curR+" "+curC);
            ans[color+1]++;
        }
        else{
            int toSize = size/3;
            paper(toSize,curR,curC);
            paper(toSize,curR+toSize,curC);
            paper(toSize,curR+toSize*2,curC);
            paper(toSize,curR,curC+toSize);
            paper(toSize,curR+toSize,curC+toSize);
            paper(toSize,curR+toSize*2,curC+toSize);
            paper(toSize,curR,curC+toSize*2);
            paper(toSize,curR+toSize,curC+toSize*2);
            paper(toSize,curR+toSize*2,curC+toSize*2);
        }
        //같지않음


    }
}

