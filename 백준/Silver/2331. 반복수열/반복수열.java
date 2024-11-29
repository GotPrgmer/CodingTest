
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> list;
    static Set<Integer> set;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int A, P;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        list = new ArrayList<>();
        sb.append(solve(A));
        System.out.println(sb);



    }
    static int solve(int x){
        list.add(x);
        set.add(x);
        int cur = x;
        while(true){
//            System.out.println(list);
            cur = multiply(cur);
            if(set.contains(cur)){
                return list.indexOf(cur);
            }
            else{
                set.add(cur);
                list.add(cur);
            }
        }
    }
    static int multiply(int x){
        //10의 N-1 제곱부터 시작
        int tmp = 0;
        while(x!=0){
            tmp += (int) Math.pow(x%10,P);
            x /= 10;
        }

        return tmp;

    }
}
