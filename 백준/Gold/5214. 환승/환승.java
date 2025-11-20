import java.io.*;
import java.util.*;

public class Main {
    static int N, K, M;
    static List<Integer>[] tube;
    static List<Integer>[] stationToTube;
    static int[] dist;
    static boolean[] visitedTube;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        tube = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            tube[i] = new ArrayList<>();
        }

        stationToTube = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            stationToTube[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int station = Integer.parseInt(st.nextToken());
                tube[i].add(station);
                stationToTube[station].add(i);
            }
        }

        dist = new int[N + 1];
        visitedTube = new boolean[M];

        bfs(1);

        if (dist[N] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dist[N]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int t : stationToTube[cur]) {
                if (visitedTube[t]) continue;
                visitedTube[t] = true;

                for (int next : tube[t]) {
                    if (dist[next] == 0) {
                        dist[next] = dist[cur] + 1;
                        q.add(next);
                    }
                }
            }
        }
    }
}
