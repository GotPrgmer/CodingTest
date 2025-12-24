import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[1025][1025];

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //누적합 구하기
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                board[i][j] = board[i][j] + board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
            }
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(calArea(x1, y1, x2, y2));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int calArea(int x1, int y1, int x2, int y2){
        return board[x2][y2] - board[x1 - 1][y2] - board[x2][y1 - 1] + board[x1 - 1][y1 - 1];
    }
}