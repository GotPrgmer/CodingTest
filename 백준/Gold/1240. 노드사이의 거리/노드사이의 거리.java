import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node>[] adj;
    static boolean[] visited;
    static int target;
    static boolean found;
    static int ans;
    

    private static void dfs(int cur, int parent, int dist){
        if(cur == target){
            ans = dist;
            found = true;
            return;
        }
        for (Node nxt : adj[cur]) {
            if(nxt.to == parent) continue;
            if (found) return;
            dfs(nxt.to, cur, dist + nxt.len);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        adj = new ArrayList[N+1];
        for (int i = 1; i < N + 1; i++) adj[i] = new ArrayList<>();

        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, l));
            adj[b].add(new Node(a, l));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            target = b;
            found = false;
            ans = 0;
            dfs(a, 0, 0);
            sb.append(ans).append('\n');

        }
        System.out.println(sb);

    }
    private static class Node{
        int to;
        int len;
        Node(int to, int len){
            this.to = to;
            this.len = len;
        }
    }
}
