import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] adj;

    static int miniBomb(int cur, int parent, int cost){
//        System.out.println(cur);
        int val = 0;
        if(cur == 1){
            for (Node nxt : adj[cur]) {
                if(nxt.to != parent){
                    val += miniBomb(nxt.to,cur,nxt.w);
                }
            }
            return val;
        }
        for (Node nxt : adj[cur]) {
            if(nxt.to != parent){
                val += miniBomb(nxt.to,cur,nxt.w);
            }
        }
        if(val == 0){
            return cost;
        }
        return Math.min(val,cost);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            adj = new ArrayList[N+1];
            for (int i = 1; i < N + 1; i++) adj[i] = new ArrayList<>();

            for(int i=1;i<M+1;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                adj[a].add(new Node(b, w));
                adj[b].add(new Node(a, w));
            }
            System.out.println(miniBomb(1, 0, 0));
        }
    }
    private static class Node{
        int to;
        int w;
        Node(int to, int w){
            this.to = to;
            this.w = w;
        }
    }
}
