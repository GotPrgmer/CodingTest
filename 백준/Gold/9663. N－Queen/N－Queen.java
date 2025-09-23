import java.util.*;
import java.io.*;
public class Main {
    static boolean[] issue1; // 열
    static boolean[] issue2; // 우하향
    static boolean[] issue3; // 좌하향
    static int N;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        issue1 = new boolean[N];
        issue2 = new boolean[2*N-1];
        issue3 = new boolean[2*N-1];
        ans = 0;
        backtrack(0);
        System.out.println(ans);
    }
    // 현재 x, y 행 열
    // issue1, issue2, issue3
    static void backtrack(int x){
        if(x==N){
            ans += 1;
        }
        else{
            for(int i=0;i<N;i++){
                if(!issue1[i] && !issue2[x+i] & !issue3[x-i+N-1]){
                    issue1[i] = true;
                    issue2[x+i] = true;
                    issue3[x-i+N-1] = true;
                    backtrack(x+1);
                    issue1[i] = false;
                    issue2[x+i] = false;
                    issue3[x-i+N-1] = false;
                }
            }
        }
    }
}