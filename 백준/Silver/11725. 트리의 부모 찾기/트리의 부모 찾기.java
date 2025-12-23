import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i < N + 1; i++) adj[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        int[] parent = new int[N+1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : adj[cur]) {
                if(nxt != parent[cur]){
                    parent[nxt] = cur;
                    q.add(nxt);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<N+1;i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}
