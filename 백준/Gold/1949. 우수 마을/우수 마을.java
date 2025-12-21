import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] d1 = new int[10001];
    static int[] d2 = new int[10001];
    static int[] a = new int[10001];
    static List<Integer>[] adj = new ArrayList[10001];

    public static void dfs(int cur, int par){
        d1[cur] = a[cur];
        d2[cur] = 0;
        for(int nxt:adj[cur]){
            if(nxt==par) continue;
            dfs(nxt,cur);
            d1[cur] += d2[nxt];
            d2[cur] += Math.max(d2[nxt], d1[nxt]);
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<N+1;i++) adj[i] = new ArrayList<>();

        for(int i=1;i<N+1;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(1,0);
        System.out.println(Math.max(d1[1],d2[1]));
    }
}
