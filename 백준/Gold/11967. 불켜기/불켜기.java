import java.util.*;
import java.io.*;
public class Main {
    static boolean[][] light;
    static boolean[][] visited;
    static List<Pair11967>[][] switches;
    static int N;
    static int M;
    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, 1, 0, -1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        switches = new ArrayList[N][N];
        light = new boolean[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                switches[i][j] = new ArrayList<>();
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            switches[x1 - 1][y1 - 1].add(new Pair11967(x2-1, y2-1));
        }
        System.out.println(bfs());
    }
    static int bfs(){
        light[0][0] = true;
        visited[0][0] = true;
        Queue<Pair11967> q = new ArrayDeque<>();
        q.add(new Pair11967(0, 0));
        int ans = 1;
        while(!q.isEmpty()){
            Pair11967 cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            //해당 방에 달린 모든 스위치 켬
            for (Pair11967 nx : switches[cur.x][cur.y]) {
                int nX = nx.x;
                int nY = nx.y;
                // 불이 꺼져있을 때
                if(!light[nX][nY]){
                    light[nX][nY] = true;
                    ans++;
                    // 새로 켜진 방이 인접하다면 방문 가능
                    for (int d = 0; d < 4; d++) {
                        int na = nX + dX[d];
                        int nb = nY + dY[d];
                        // 내가 지나온 방이 인접하다면
                        if (check(na, nb)) continue;
                        if(!visited[na][nb]) continue;
                        visited[nX][nY] = true;
                        q.add(new Pair11967(nX, nY));
                        break;

                    }
                }
            }

            for(int d=0;d<4;d++){
                int nX = curX + dX[d];
                int nY = curY + dY[d];
                if(check(nX,nY)) continue;
                if(!light[nX][nY] || visited[nX][nY]) continue;
                visited[nX][nY] = true;
                q.add(new Pair11967(nX, nY));
            }
        }
        return ans;
    }
    static boolean check(int x, int y){
        return x<0 || x>= N || y<0 || y>=N;
    }
    static class Pair11967{
        int x;
        int y;
        Pair11967(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}