import java.util.*;
import java.io.*;
public class Main {
    static char[][] board;
    static int[] keys = new int[26];
    static int h;
    static int w;
    static ArrayList<Pair9328>[] doorList;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            //맵 입력
            board = new char[h][w];
            for(int i=0;i<h;i++){
                char[] c = br.readLine().toCharArray();
                for(int j=0;j<w;j++){
                    board[i][j] = c[j];
                }
            }
            Arrays.fill(keys, 0);
            char[] initKey = br.readLine().toCharArray();
            if(initKey[0] != '0'){
                for(int i=0;i<initKey.length;i++){
                    keys[initKey[i]-97] = 1;
                }
            }
            System.out.println(bfs());
//            System.out.println(Arrays.toString(keys));
        }

    }
    public static int bfs(){
        visited = new boolean[h][w];
        doorList = new ArrayList[26];
        for(int i=0;i<26;i++){
            doorList[i] = new ArrayList<>();
        }
        Queue<Pair9328> q = new ArrayDeque<>();
        int docs = 0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if (i == 0 || j == 0 || i == h - 1 || j == w - 1) {
                    if (board[i][j] != '*') {
                        docs += initRoom(i, j, q);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            Pair9328 cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
//            System.out.println(curX + " " + curY);

            for(int d = 0;d<4;d++){
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                if(nx < 0 || ny <0 || nx>=h || ny>=w) continue;
                if(visited[nx][ny] || board[nx][ny] == '*') continue;
                docs += initRoom(nx, ny, q);
            }
        }
    return docs;
    }

    public static int initRoom(int x, int y, Queue<Pair9328> q) {
        char c = board[x][y];
        int collected = 0;

        if (c == '$') {
            collected++;
            board[x][y] = '.';
            // 열쇠면 해당 열쇠로 열 수 있는 모든 문을 q에 넣기
        } else if ('a' <= c && c <= 'z') {
            int idx = c - 'a';
            if (keys[idx] == 0) {
                keys[idx] = 1;
                for (Pair9328 p : doorList[idx]) {
                    if (!visited[p.x][p.y]) {
                        q.add(p);
                        visited[p.x][p.y] = true;
                    }
                }
            }
            board[x][y] = '.';
        } else if ('A' <= c && c <= 'Z') {
            int idx = c - 'A';
            if (keys[idx] == 0) {
                doorList[idx].add(new Pair9328(x, y));
                return 0;
            }
        }

        visited[x][y] = true;
        q.add(new Pair9328(x, y));
        return collected;
    }

    static class Pair9328{
        int x;
        int y;
        Pair9328(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
