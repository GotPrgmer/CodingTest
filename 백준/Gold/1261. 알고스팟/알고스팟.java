import java.util.*;
import java.io.*;
public class Main {
    static int[][] board;
    static int N;
    static int M;
    static int INF = Integer.MAX_VALUE;
    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i=0;i<N;i++){
            char[] input = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(String.valueOf(input[j]));
            }
        }
        System.out.println(djkstra());
    }
    private static int djkstra(){
        PriorityQueue<Pair1261> pq = new PriorityQueue<>();
        pq.add(new Pair1261(0,0,0));
        int[][] dist = new int[N][M];
        for(int i=0;i<N;i++) Arrays.fill(dist[i],INF);
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            Pair1261 cur = pq.poll();
            int curX = cur.curX;
            int curY = cur.curY;
            int curW = cur.w;
            if(dist[curX][curY] != curW) continue;
//            System.out.println(dist[curX][curY]);
            for(int d=0;d<4;d++){
                //다음 좌표
                int nX = curX + dX[d];
                int nY = curY + dY[d];
                if(nX<0 || nX>=N || nY<0 || nY>=M) continue;
//                System.out.println(nX + " " + nY);
                if(dist[nX][nY] <= dist[curX][curY] + board[nX][nY]) continue;
                dist[nX][nY] = dist[curX][curY] + board[nX][nY];
                pq.add(new Pair1261(nX, nY, dist[nX][nY]));
            }
        }
        return dist[N-1][M-1];
    }
    private static class Pair1261 implements Comparable<Pair1261>{
        int curX;
        int curY;
        int w;
        Pair1261(int curX, int curY, int w){
            this.curX = curX;
            this.curY = curY;
            this.w = w;
        }
        @Override
        public int compareTo(Pair1261 p){
            return Integer.compare(this.w, p.w);
        }
    }
}