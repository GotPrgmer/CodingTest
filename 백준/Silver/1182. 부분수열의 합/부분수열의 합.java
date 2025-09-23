import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int S;
    static int ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        func(0,0);
        if(S==0){
            ans -= 1;
        }
        System.out.println(ans);
    }
    static void func(int cur, int tot){
        // 현재 N번째다/
        if(cur == N){
            if(tot == S){
                ans++;
            }
        }
        else{
            func(cur+1, tot);
            func(cur+1, tot+arr[cur]);
        }

    }

}