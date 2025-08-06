import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static final int MX = 1000005;
    private static char[] dat = new char[MX];
    private static int[] pre = new int[MX];
    private static int[] nxt = new int[MX];
    private static int unused = 1;

    // 리스트 초기화
    private static void init() {
        for (int i = 0; i < MX; i++) {
            pre[i] = -1;
            nxt[i] = -1;
        }
    }

    // 새 노드 추가 (노드 주소, 데이터)
    private static void insert(int addr, char c) {
        dat[unused] = c;
        pre[unused] = addr;
        nxt[unused] = nxt[addr];

        if (nxt[addr] != -1) {
            pre[nxt[addr]] = unused;
        }
        nxt[addr] = unused;
        unused++;
    }

    // 노드 삭제
    private static void erase(int addr) {
        nxt[pre[addr]] = nxt[addr];
        if (nxt[addr] != -1) {
            pre[nxt[addr]] = pre[addr];
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String initialStr = br.readLine();

        int cursor = 0; // 초기 커서는 'head' 노드를 가리킴
        for (char c : initialStr.toCharArray()) {
            insert(cursor, c);
            cursor = nxt[cursor];
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String op = br.readLine();
            char command = op.charAt(0);

            switch (command) {
                case 'P':
                    char addChar = op.charAt(2);
                    insert(cursor, addChar);
                    cursor = nxt[cursor];
                    break;

                case 'L':
                    if (pre[cursor] != -1) {
                        cursor = pre[cursor];
                    }
                    break;

                case 'D':
                    if (nxt[cursor] != -1) {
                        cursor = nxt[cursor];
                    }
                    break;

                case 'B':
                    if (pre[cursor] != -1) {
                        int preNode = pre[cursor];
                        erase(cursor);
                        cursor = preNode;
                    }
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int current = nxt[0];
        while (current != -1) {
            sb.append(dat[current]);
            current = nxt[current];
        }
        System.out.println(sb.toString());
    }
}