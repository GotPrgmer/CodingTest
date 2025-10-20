import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] li = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            li[i] = Integer.parseInt(st.nextToken());
        }
        // 누적합
        for(int i=1;i<n+1;i++){
            li[i] += li[i-1];
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(li[b]-li[a-1]);
        }

    }
}

