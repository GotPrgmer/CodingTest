import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder preOutput;
    static StringBuilder inOutput;
    static StringBuilder postOutput;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        preOutput = new StringBuilder();
        inOutput = new StringBuilder();
        postOutput = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] lc = new int[N+1];
        int[] rc = new int[N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            if(l != '.') lc[p-'A'+1] = (l-'A')+1;
            if(r != '.') rc[p-'A'+1] = (r-'A')+1;
        }
        pre(1, lc, rc);
        in(1, lc, rc);
        post(1, lc, rc);
        System.out.println(preOutput);
        System.out.println(inOutput);
        System.out.println(postOutput);

    }

    private static void pre(int p, int[] lc, int[] rc){
        preOutput.append((char)(p+'A'-1));
        if(lc[p] != 0) pre(lc[p], lc, rc);
        if(rc[p] != 0) pre(rc[p], lc, rc);
    }
    private static void in(int p, int[] lc, int[] rc){
        if(lc[p] != 0) in(lc[p], lc, rc);
        inOutput.append((char)(p+'A'-1));
        if(rc[p] != 0) in(rc[p], lc, rc);
    }
    private static void post(int p, int[] lc, int[] rc){
        if(lc[p] != 0) post(lc[p], lc, rc);
        if(rc[p] != 0) post(rc[p], lc, rc);
        postOutput.append((char)(p+'A'-1));
    }
}
