
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int idx=0;idx<testCase;idx++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push_back")){
                int x = Integer.parseInt(st.nextToken());
                push_back(x);
            }
            else if(command.equals("push_front")){
                int x = Integer.parseInt(st.nextToken());
                push_front(x);
            } else if (command.equals("pop_front")) {
                sb.append(pop_front()).append("\n");
            } else if (command.equals("pop_back")) {
                sb.append(pop_back()).append("\n");

            } else if (command.equals("size")) {
                sb.append(size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(empty()).append("\n");
            } else if (command.equals("front")) {
                sb.append(front()).append("\n");
            } else if (command.equals("back")) {
                sb.append(back()).append("\n");
            }
        }
        System.out.println(sb);


    }
    static void push_front(int x){
        deque.addFirst(x);
    }
    static void push_back(int x){
        deque.addLast(x);

    }
    static int pop_front(){
        if(empty() == 1){
            return -1;
        }
        else{
            return deque.removeFirst();
        }
    }

    static int pop_back(){
        if(empty() == 1){
            return -1;
        }
        return deque.removeLast();
    }

    static int size(){
        return deque.size();
    }
    static int empty(){
        return deque.isEmpty() ? 1 : 0;
    }
    static int front(){
        if(empty() == 1){
            return -1;
        }
        return deque.peekFirst();
    }
    static int back(){
        if(empty()==1){
            return -1;
        }
        return deque.peekLast();
    }



}
