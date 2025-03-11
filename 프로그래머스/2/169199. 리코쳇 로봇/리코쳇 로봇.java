import java.util.*;

class Solution {
    static int[] d_r = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] d_c = {0, 1, 0, -1};
    static String[] board_static; 

    public int solution(String[] board) {
        board_static = board;
        int start_r = -1, start_c = -1;

        // R(로봇) 위치 찾기
        outerLoop:
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length(); c++) {
                if (board[r].charAt(c) == 'R') {
                    start_r = r;
                    start_c = c;
                    break outerLoop; // R을 찾으면 즉시 탈출
                }
            }
        }

        return bfs(start_r, start_c);
    }

    public int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(new int[]{r, c, 0}); // 시작 위치와 이동 횟수(0)
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int start_r = cur[0];
            int start_c = cur[1];
            int cnt = cur[2];

            // 목표 도착 시 이동 횟수 반환
            if (board_static[start_r].charAt(start_c) == 'G') {
                return cnt;
            }

            // 이미 방문한 위치라면 continue
            String key = start_r + "," + start_c;
            if (visited.contains(key)) {
                continue;
            }
            visited.add(key);

            // 4방향 탐색 (미끄러지기)
            for (int d = 0; d < 4; d++) {
                int nr = start_r, nc = start_c;
                
                // 장애물(D) 또는 범위 밖을 만나기 전까지 이동
                while (true) {
                    int next_r = nr + d_r[d];
                    int next_c = nc + d_c[d];

                    if (next_r >= 0 && next_r < board_static.length &&
                        next_c >= 0 && next_c < board_static[0].length() &&
                        board_static[next_r].charAt(next_c) != 'D') {
                        nr = next_r;
                        nc = next_c;
                    } else {
                        break; // 장애물 or 경계를 만나면 종료
                    }
                }

                // 새로운 위치를 큐에 추가 (방문 확인 후)
                String nextKey = nr + "," + nc;
                if (!visited.contains(nextKey)) {
                    q.offer(new int[]{nr, nc, cnt + 1});
                }
            }
        }
        return -1; // 도달 불가능한 경우
    }
}
