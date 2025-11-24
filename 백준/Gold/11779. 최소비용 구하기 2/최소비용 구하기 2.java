import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int m;
    static List<Pair11779>[] graph;
    static int[] dist;
    static int[] path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        path = new int[n + 1];
        graph = new ArrayList[n + 1];
        for(int i=0;i<n+1;i++) graph[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Pair11779(v, w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        djkstra(start, end);
        // 1. 최소 비용 출력
        System.out.println(dist[end]);

        // 2. 경로 복원: end에서 start까지 prev 따라 올라가기
        List<Integer> route = new ArrayList<>();
        int cur = end;
        while (cur != 0) {          // path[start]는 0 그대로이므로 여기서 종료
            route.add(cur);
            cur = path[cur];
        }
        Collections.reverse(route);

        // 3. 경로 길이 출력
        System.out.println(route.size());

        // 4. 실제 경로 출력
        StringBuilder sb = new StringBuilder();
        for (int city : route) {
            sb.append(city).append(' ');
        }
        System.out.println(sb);
    }
    private static void djkstra(int start, int end){
        PriorityQueue<Pair11779> pq = new PriorityQueue<>(new Comparator<Pair11779>(){
            @Override
            public int compare(Pair11779 p1, Pair11779 p2){
                return p1.w - p2.w;
            }
        });
        pq.add(new Pair11779(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Pair11779 cur = pq.poll();
            int curTo = cur.to;
            int curW = cur.w;
            if(dist[curTo] != curW) continue;
            for (Pair11779 nxt : graph[curTo]) {
                int nxtNode = nxt.to;
                int nxtW = nxt.w;
                if(dist[nxtNode] <= nxtW+dist[curTo]) continue;
                dist[nxtNode] = nxtW+dist[curTo];
                pq.add(new Pair11779(nxtNode, dist[nxtNode]));
                path[nxtNode] = curTo;
            }
        }
//        System.out.println(Arrays.toString(path));
    }
    private static class Pair11779{
        int to;
        int w;
        Pair11779(int to, int w){
            this.to = to;
            this.w = w;
        }

    }
}