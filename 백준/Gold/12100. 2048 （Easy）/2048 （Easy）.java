import java.util.*;
import java.io.*;

public class Main {
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,1,0,-1};
    static int N;
    static int[][] copy = new int[20][20];
    static int[][] board = new int[20][20];
    static boolean[][] is_merge;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //board 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //4진법
        for(int i=0;i<1<<10;i++){
//            System.out.println("처음");
            //copy 원복
            for(int copy_x=0;copy_x<N;copy_x++){
                copy[copy_x] = Arrays.copyOf(board[copy_x], N);
            }

            int brute = i;
            for(int m=0;m<5;m++){
                int tmp = brute%4;
                brute /= 4;
                //move
                move(tmp);
            }
            //max num 구하기
            for(int r=0;r<N;r++){
                for(int c=0;c<N;c++){
                    ans = Math.max(ans,copy[r][c]);
                }
            }
        }
        System.out.println(ans);

    }
    static void move(int d){
        is_merge = new boolean[N][N];
        if(d == 0){
//            System.out.println("위");
            for(int j=0;j<N;j++){
                for(int i=0;i<N;i++){
                    if(copy[i][j]!= 0){
                        go(i,j,d);
                    }
                }
            }
//            for(int i=0;i<N;i++){
//                System.out.println(Arrays.toString(copy[i]));
//            }
        }
        else if(d==1){
//            System.out.println("오른쪽");
            for(int i=0;i<N;i++){
                for(int j=N-1;j>-1;j--){
                    if(copy[i][j]!= 0){
                        go(i,j,d);
                    }
                }
            }
//            for(int i=0;i<N;i++){
//                System.out.println(Arrays.toString(copy[i]));
//            }
        }
        else if(d==2){
//            System.out.println("아래");
            for(int j=0;j<N;j++){
                for(int i=N-1;i>-1;i--){
                    if(copy[i][j]!= 0){
                        go(i,j,d);
                    }
                }
            }
//            for(int i=0;i<N;i++){
//                System.out.println(Arrays.toString(copy[i]));
//            }
        }
        else if(d==3){
//            System.out.println("왼쪽");
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(copy[i][j]!= 0){
                        go(i,j,d);
                    }
                }
            }
//            for(int i=0;i<N;i++){
//                System.out.println(Arrays.toString(copy[i]));
//            }
        }
    }
    static void go(int x, int y, int d){
        int cur_x = x;
        int cur_y = y;
        while(true){
            int n_x = cur_x+d_x[d];
            int n_y = cur_y+d_y[d];
            //벽 부딪쳤으면 거기서 끝
            if(n_x < 0 || n_x >=N || n_y<0 || n_y>=N) return;
            // 숫자가 있는데 현재 숫자랑 다르면 || is_merge가 true 거기서 끝
            if(is_merge[n_x][n_y]) return;
            // 0이라면 해당 자리로 이동
            if(copy[n_x][n_y] == 0){
                copy[n_x][n_y] = copy[cur_x][cur_y];
                copy[cur_x][cur_y] = 0;
                cur_x = n_x;
                cur_y = n_y;
            }
            // 현재 숫자랑 같은데 해당 자리의 is_merge가 false이면
            else if(copy[n_x][n_y] == copy[cur_x][cur_y] && !is_merge[n_x][n_y]){
                copy[cur_x][cur_y] = 0;
                is_merge[n_x][n_y] = true;
                copy[n_x][n_y] = 2*copy[n_x][n_y];
                cur_x = n_x;
                cur_y = n_y;
                return;
            }
            else{
                return;
            }
        }
    }
}