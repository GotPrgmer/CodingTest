import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static List<Pair17835>[] graph;
    static int[] interview;
    static long INF = Long.MAX_VALUE / 4;
    static long[] shortest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        interview = new int[K];

        shortest = new long[N+1];
        Arrays.fill(shortest, INF);

        graph = new ArrayList[N + 1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[b].add(new Pair17835(a, w));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            interview[i] = Integer.parseInt(st.nextToken());
        }
        long ansDist = -1;
        int ansNode = -1;

        long[] dist = djkstra();
//        System.out.println(Arrays.toString(dist));

        for(int i=1;i<N+1;i++){
            if(ansDist < dist[i] && dist[i] != 0){
                    ansDist = dist[i];
                    ansNode = i;
            }
        }

//        System.out.println(Arrays.toString(shortest));
        System.out.println(ansNode);
        System.out.println(ansDist);


    }
    private static long[] djkstra(){

        PriorityQueue<Pair17835> pq = new PriorityQueue<>();
        long[] dist = new long[N+1];
        Arrays.fill(dist,INF);
        for(int i=0;i<K;i++){
            pq.add(new Pair17835(interview[i], 0));
            dist[interview[i]] = 0;
        }

        while(!pq.isEmpty()){
            Pair17835 cur = pq.poll();
            int curNode = cur.node;
            long curWeight = cur.weight;
            if(dist[curNode] != curWeight) continue;
            for (Pair17835 nxt : graph[curNode]) {
                int nxtNode = nxt.node;
                long nxtWeight = nxt.weight;
                if(dist[nxtNode] <= dist[curNode] + nxtWeight) continue;
                dist[nxtNode] = dist[curNode] + nxtWeight;
                pq.add(new Pair17835(nxtNode, dist[nxtNode]));
            }
        }

        return dist;
    }
    static class Pair17835 implements Comparable<Pair17835>{
        int node;
        long weight;
        Pair17835(int node, long weight){
            this.node = node;
            this.weight = weight;
        }
        @Override
        public int compareTo(Pair17835 p){
            return Long.compare(this.weight, p.weight);
        }
    }
}
