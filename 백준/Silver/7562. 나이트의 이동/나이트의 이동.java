import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] d_x = new int[]{-2,-1,1,2,2,1,-1,-2};
    static int[] d_y = new int[]{1,2,2,1,-1,-2,-2,-1};
    static int[][] visited;
    static Queue<Pair7> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<t;i++){
            q = new LinkedList<>();
            int len = Integer.parseInt(br.readLine());
            visited = new int[len][len];

            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int goal_x = Integer.parseInt(st.nextToken());
            int goal_y = Integer.parseInt(st.nextToken());

            //시작점을 방문처리하고 큐에 넣기
            visited[start_x][start_y] = 1;
            q.add(new Pair7(start_x,start_y));
            //bfs 돌리기
            while(!q.isEmpty()){
                Pair7 cur = q.poll();
                int cur_x = cur.x;
                int cur_y = cur.y;
                for(int d=0;d<8;d++){
                    int n_x = cur_x+d_x[d];
                    int n_y = cur_y+d_y[d];
                    if(n_x<0 || n_x>=len || n_y<0 || n_y>=len) continue;
                    if(visited[n_x][n_y] != 0) continue;
                    visited[n_x][n_y] = visited[cur_x][cur_y]+1;
                    q.add(new Pair7(n_x,n_y));
                }
            }
            System.out.println(visited[goal_x][goal_y]-1);

        }
    }
}
class Pair7{
    int x;
    int y;
    Pair7(int x, int y){
        this.x = x;
        this.y = y;

    }
}