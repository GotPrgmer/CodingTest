import java.util.*;
import java.io.*;
public class Main {
    static boolean[] issue;
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        issue = new boolean[N+1];
        backtrack(0);
    }
    static void backtrack(int k){
        if(k == M){
            for(int i=0;i<M;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        else if(k < M){
            for(int i=1;i<N+1;i++){
                if(!issue[i]){
                    issue[i] = true;
                    arr[k] = i;
                    backtrack(k+1);
                    issue[i] = false;
                }
            }
        }
    }
}
