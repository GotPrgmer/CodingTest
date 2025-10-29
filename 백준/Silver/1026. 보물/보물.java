import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        b = Arrays.stream(b).
                boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        int ans = 0;
        for(int i=0;i<N;i++){
            ans += a[i]*b[i];
        }
        System.out.println(ans);

    }
}
