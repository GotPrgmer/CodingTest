import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        say(N, "");
        System.out.println(sb);
    }
    static void say(int rep,String underScore){
        sb.append(underScore).append("\"재귀함수가 뭔가요?\"\n");
        if(rep == 0){
            sb.append(underScore).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            sb.append(underScore).append("라고 답변하였지.\n");
            return;
        }
        sb.append(underScore).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        sb.append(underScore).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        sb.append(underScore).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        // 4. 더 깊이 들어가는 재귀 호출 (rep를 줄이고, 밑줄은 늘림)
        say(rep - 1, underScore + "____");

        // 5. 재귀에서 다 돌아온 뒤, 마무리 멘트를 출력
        sb.append(underScore).append("라고 답변하였지.\n");
    }
}
