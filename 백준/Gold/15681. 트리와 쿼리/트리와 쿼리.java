import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] subTreeSize;

    static int countSubtreeNode(int cur) {
        visited[cur] = true;

        for (int nxt : adj[cur]) {
            if (visited[nxt]) continue;
            subTreeSize[cur] += countSubtreeNode(nxt);
        }

        subTreeSize[cur]++; // 자기 자신 포함
        return subTreeSize[cur];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        visited = new boolean[N + 1];
        subTreeSize = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        countSubtreeNode(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(subTreeSize[q]).append('\n');
        }

        System.out.print(sb);


    }
}
