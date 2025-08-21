import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] a = new int[l];
        for(int i=0;i<l;i++){
            a[i] =  Integer.parseInt(stringTokenizer.nextToken());
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<l;i++){
            while(!st.isEmpty() && a[i]>a[st.peek()]){
                a[st.pop()] = a[i];
            }
            st.add(i);
        }
        while(!st.isEmpty()){
            a[st.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<a.length;i++){
            sb.append(a[i]).append(' ');
        }
        System.out.println(sb);
    }
}