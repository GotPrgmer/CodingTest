import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int K;
    static boolean[] visited = new boolean[200001];
    static int[] path = new int[200001];
    static int LIMIT = 100_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int val = bfs();
        if(val != -1){
            System.out.println(val);
            int cur = K;
            StringBuilder sb = new StringBuilder();
            while(cur!=N){
                sb.insert(0," ").insert(0,cur);
                cur = path[cur];
            }
            sb.insert(0," ").insert(0,cur);

            System.out.println(sb);
        }
    }
    public static int bfs(){
        Queue<Pair13913> q = new ArrayDeque<>();
        q.add(new Pair13913(N,0));
        visited[N] = true;
        while(!q.isEmpty()){
            Pair13913 cur = q.poll();
            int num = cur.num;
            int t = cur.t;
            if(num ==K){
                return t;
            }
            else {
                if(num != 0 && num*2<LIMIT && !visited[2*num]){
                    path[2*num] = num;
                    visited[2*num] = true;
                    q.add(new Pair13913(num*2,t+1));
                }
                if(num+1<=K && !visited[num+1]){
                    path[num+1] =  num;
                    visited[num+1] = true;
                    q.add(new Pair13913(num + 1, t + 1));
                }
                if(num-1>=0 && !visited[num-1]){
                    path[num-1] =  num;
                    visited[num-1] = true;
                    q.add(new Pair13913(num - 1, t + 1));
                }
            }
        }
        return -1;
    }
    static class Pair13913{
        int num;
        int t;
        Pair13913(int num, int t){
            this.num = num;
            this.t = t;
        }
    }
}
