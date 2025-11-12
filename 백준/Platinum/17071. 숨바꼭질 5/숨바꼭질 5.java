import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited = new boolean[500000+1][2];
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        visited[N][0] = true;
        int t = 0;
        while(true){
            int bro = K + t*(t+1)/2;
            if (bro > 500_000) return -1;
            if (visited[bro][t % 2]) return t;
            int size = q.size();
            for(int i=0;i<size;i++){
                int cur = q.poll();
                for (int nxt : new int[]{cur + 1, cur - 1, cur * 2}) {
                    if(nxt<0 || nxt>=500_001) continue;
                    if(visited[nxt][(t+1)%2]) continue;
                    visited[nxt][(t+1)%2] =  true;
                    q.add(nxt);
                }
            }
            t++;
        }
    }
}
