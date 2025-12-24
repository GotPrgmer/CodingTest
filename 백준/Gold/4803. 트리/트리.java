import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 1;
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n==0 && m == 0) break;

            parent = new int[n+1];
//            for(int i=1;i<n+1;i++) parent[i] = i;

            adj = new ArrayList[n+1];
            for(int i=1;i<n+1;i++) adj[i] = new ArrayList<>();


            for(int i=1;i<m+1;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                adj[b].add(a);
            }

            int treeCnt = 0;

            for(int i=1;i<n+1;i++){
                if(parent[i] == 0) {
                    if(findParent(i)){
                        treeCnt++;
                    }
                }
            }

            sb.append("Case ").append(T).append(": ");

            if(treeCnt >1){
                sb.append("A forest of ")
                        .append(treeCnt).append(" trees.");
            }
            else if(treeCnt == 1){
                sb.append("There is one tree.");
            }
            else{
                sb.append("No trees.");
            }
            sb.append("\n");

            T++;
        }
        System.out.println(sb);

    }
    private static boolean findParent(int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        parent[node] = node;

        boolean hasCycle = false;

        while(!q.isEmpty()){
            int cur = q.poll();
            for (int nxt : adj[cur]) {
                if(parent[cur] == nxt) continue;
                if(parent[nxt] != 0){
                    hasCycle = true;
                    continue;
                }
                parent[nxt] = cur;
                q.add(nxt);
            }
        }
        //사이클이 없어야 트리
        return !hasCycle;
    }
}
