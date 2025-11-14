import java.util.*;
import java.io.*;
public class Main {
    static int[] attackPw;
    static Queue<Pair20304> q;
    static boolean[] visited;
    static int MAX_BIT;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        q = new ArrayDeque<>();
        MAX_BIT = Integer.toBinaryString(N).length();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            q.add(new Pair20304(num,0));
            visited[num] = true;
        }
        System.out.println(solve());
    }
    // 전체 bit 수를 세서, 1비트씩 다르게 해서 q에 넣어서 bfs돌리기
    static int solve(){
        int maxSafety = 0;
        while(!q.isEmpty()){
            Pair20304 cur = q.poll();
            int curNum = cur.num;
            int curSafety = cur.safety;
            maxSafety = Math.max(maxSafety, curSafety);
            for(int i=0;i<MAX_BIT;i++){
                int nxt = curNum^(1<<i);
                if(nxt<0 || nxt>N) continue;
                if(visited[nxt]) continue;
                visited[nxt] = true;
                q.add(new Pair20304(nxt, curSafety+1));
            }

        }
        return maxSafety;
    }
    static class Pair20304{
        int num;
        int safety;
        Pair20304(int num, int safety){
            this.num = num;
            this.safety = safety;
        }
    }
}
