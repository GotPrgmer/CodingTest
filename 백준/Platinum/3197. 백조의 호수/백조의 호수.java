import java.util.*;
import java.io.*;
public class Main {
    static int R, C;
    static char[][] board;
    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, 1, 0, -1};
    static Queue<Pair3197> waterQ = new ArrayDeque<>();
    static Queue<Pair3197> nextWaterQ = new ArrayDeque<>();
    static Queue<Pair3197> swanQ = new ArrayDeque<>();
    static Queue<Pair3197> nextSwanQ = new ArrayDeque<>();
    static boolean[][] swanVisited;
    static Pair3197 swan1, swan2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        List<Pair3197> swans = new ArrayList<>();
        board = new char[R][C];
        // board 초기화
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] != 'X') waterQ.add(new Pair3197(i, j));
                if (board[i][j] == 'L') swans.add(new Pair3197(i, j));
            }
        }

        swan1 = swans.get(0);
        swan2 = swans.get(1);
        swanVisited = new boolean[R][C];
        swanVisited[swan1.x][swan1.y] = true;
        swanQ.add(swan1);


        int day = 0;
        while (true) {
            if (moveSwan()) break;
            meltIce();
            swanQ = nextSwanQ;
            waterQ = nextWaterQ;
            nextSwanQ = new ArrayDeque<>();
            nextWaterQ = new ArrayDeque<>();
            day++;
        }
        System.out.println(day);
    }
    static boolean moveSwan() {
        while (!swanQ.isEmpty()) {
            Pair3197 cur = swanQ.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dX[d];
                int ny = cur.y + dY[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (swanVisited[nx][ny]) continue;
                swanVisited[nx][ny] = true;
                if (board[nx][ny] == 'L') return true; // 만나면 종료
                if (board[nx][ny] == 'X') nextSwanQ.add(new Pair3197(nx, ny));
                else swanQ.add(new Pair3197(nx, ny));
            }
        }
        return false;
    }

    static void meltIce() {
        while (!waterQ.isEmpty()) {
            Pair3197 cur = waterQ.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dX[d];
                int ny = cur.y + dY[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (board[nx][ny] == 'X') {
                    board[nx][ny] = '.';
                    nextWaterQ.add(new Pair3197(nx, ny));
                }
            }
        }
    }


    static class Pair3197{
        int x;
        int y;
        Pair3197(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
