import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] adj;

    static int miniBomb(int cur, int parent, int cost){
        int sum = 0;
        boolean hasChild = false;

        for (Node nxt : adj[cur]) {
            if (nxt.to == parent) continue;
            hasChild = true;
            sum += miniBomb(nxt.to, cur, nxt.w);
        }

        // 리프면 자식 쪽에서 막을 방법이 없으니, 들어오는 간선을 끊는 비용(cost) 그대로
        if (!hasChild) return cost;

        // 내부 노드: 아래에서 막는 비용(sum) vs 여기서 끊는 비용(cost)
        return Math.min(sum, cost);
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
            if (miniBomb(1, 0, Integer.MAX_VALUE) == Integer.MAX_VALUE) {
                System.out.println(0);
            }
            else{
                System.out.println(miniBomb(1, 0, Integer.MAX_VALUE));
            }
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
