import java.util.*;
import java.io.*;
public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int comNum = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        graph = new ArrayList[comNum+1];
        visited = new boolean[comNum+1];
        for(int i=0;i<comNum+1;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<pair;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first].add(second);
            graph[second].add(first);
        }
        System.out.println(bfs());
    }
    public static int bfs(){
            Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{1, 0});
    visited[1] = true;
    int ans = 0;

    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int node = cur[0];
        int depth = cur[1];

        // 깊이가 2 이상이면 더 확장하지 않음
        if (depth == 2) continue;

        for (int nxt : graph[node]) {
            if (visited[nxt]) continue;
            visited[nxt] = true;
            ans++;
            q.add(new int[]{nxt, depth + 1});
        }
    }
    return ans;

    }
}
