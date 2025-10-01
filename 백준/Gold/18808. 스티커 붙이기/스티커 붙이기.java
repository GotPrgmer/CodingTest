import java.util.*;
import java.io.*;;
public class Main {
    static int[][] sticker;
    static int[][] copy;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new int[N][M];


        for(int t=0;t<K;t++){
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            sticker = new int[R][C];
            copy = new int[R][C];
            //모눈종이에 숫자 넣기
            for(int i=0;i<R;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<C;j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = sticker[i][j];
                }
            }
            int cur_R = R;
            int cur_C = C;
            boolean isFit = false;
            for(int d=0;d<4;d++){
                if(d==1){
                    cur_R = C;
                    cur_C = R;
                }
                else if(d==2){
                    cur_R = R;
                    cur_C = C;
                }
                else if(d==3){
                    cur_R = C;
                    cur_C = R;
                }
                copy = new int[cur_R][cur_C];
                //rotate
                rotate(cur_R,cur_C,d);

                //해당 스티커가 들어갈 수 있는 지 체크하기
                for(int start_x=0;start_x<N-cur_R+1;start_x++){
                    for(int start_y=0;start_y<M-cur_C+1;start_y++){
                        if(check(cur_R,cur_C,start_x,start_y)){
                            isFit = true;
                            //스티커 붙이기
                            fillSticker(cur_R,cur_C,start_x,start_y);
                            break;
                        }
                    }
                    if(isFit){
                        break;
                    }
                }
                //스티커
                if(isFit){
                    break;
                }

            }



        }
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j] == 1){
                    ans ++;
                }
            }
        }
        System.out.println(ans);

    }
    static public boolean check(int N, int M, int start_x, int start_y){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy[i][j] == 1 && board[start_x+i][start_y+j] == copy[i][j]) return false;
            }
        }
        return true;
    }
    static public void fillSticker(int N, int M, int start_x, int start_y){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy[i][j] == 1){
                    board[start_x+i][start_y+j] = copy[i][j];
                }
            }
        }
    }
    static public void rotate(int cur_R, int cur_C, int d){
        int R = sticker.length;
        int C = sticker[0].length;
        if(d==0){
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    copy[i][j] = sticker[i][j];

                }
            }
        }
        else{
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    if(d==1){
                        copy[j][cur_C-1-i] = sticker[i][j];
                    }
                    else if(d==2){
                        // 5 2
                        copy[cur_R-1-i][cur_C-1-j] = sticker[i][j];
                    }
                    else if(d==3){
                        copy[cur_R-1-j][i] = sticker[i][j];
                    }

                }
            }
        }

    }
}
