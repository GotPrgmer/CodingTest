import java.util.*;
import java.io.*;
public class Main {
    static int[][] visited;
    static int[] limit;
    static Queue<Pair14> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int maxJump = (int)Math.sqrt(2*N) + 2;
        visited = new int[N+1][maxJump+1];
        limit = new int[N+1];
        for(int i=0;i<M;i++){
            int no_rock = Integer.parseInt(br.readLine());
            limit[no_rock] = 1;
        }
        // 1부터 N까지
        q = new LinkedList<>();
        q.add(new Pair14(1,0,0));
        visited[1][0] = 1;
        System.out.println(bfs(N));
    }
    static int bfs(int N){
        while(!q.isEmpty()){
            Pair14 cur = q.poll();
            int rock = cur.rock;
            int jump = cur.jump;
            int jump_num = cur.jump_num;
//            System.out.println(rock+" "+jump);
            if(rock == N){
                return jump_num;
            }
            for(int d=0;d<3;d++){
                int n_num = -1;
                if(d==2){
                    n_num = jump-1;
                }
                else if(d==1){
                    n_num = jump;
                }
                else {
                    n_num = jump+1;
                }
                if(n_num<1) continue;
                if(rock+n_num>N) continue;
                if(limit[rock+n_num] == 1) continue;
                if(visited[rock+n_num][n_num] != 0) continue;
                visited[rock+n_num][n_num] = 1;
                q.add(new Pair14(rock+n_num,n_num,jump_num+1));

            }

        }
        return -1;
    }
}
class Pair14{
    int rock;
    int jump;
    int jump_num;
    Pair14(int rock, int jump, int jumpNum){
        this.rock = rock;
        this.jump =jump;
        this.jump_num = jumpNum;
    }
}


