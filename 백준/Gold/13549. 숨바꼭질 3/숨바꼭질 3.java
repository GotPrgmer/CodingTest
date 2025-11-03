import java.util.*;
import java.io.*;
public class Main {
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N,K));
    }
    public static int bfs(int N, int K){
        Queue<Pair13539> q = new ArrayDeque<>();
        q.add(new Pair13539(0,N));
        int[] visited = new int[100_001];
        Arrays.fill(visited,max);
//        visited[N] = 0;
        while(!q.isEmpty()){
            Pair13539 cur = q.poll();
            int curT = cur.t;
            int curNum = cur.num;
//            System.out.println(curT + " " + curNum);
            if(visited[curNum]>curT){
                visited[curNum] = curT;
                if(curNum != K){
                    //0초후 텔레포트
                    if(curNum*2<=100000) {
                        q.add(new Pair13539(curT, 2 * curNum));
                    }
                    //1초후 -1
                    if(curNum-1>=0){
                        q.add(new Pair13539(curT+1,curNum-1));
                    }
                    //1초후 +1
                    if(curNum+1<=100000){
                        q.add(new Pair13539(curT+1,curNum+1));
                    }
                }
            }
        }
        return visited[K];
    }
}
class Pair13539{
    int t;
    int num;
    Pair13539(int t, int num){
        this.t = t;
        this.num = num;
    }
}