import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static Set<Integer> truePeople;
    static List<Integer>[] party;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        truePeople = new HashSet<>();
        String[] trueth = br.readLine().split(" ");
        int numTrue = Integer.parseInt(trueth[0]);
        party = new ArrayList[M];
        for(int i=0;i<M;i++) party[i] = new ArrayList<>();

        for(int i=1;i<numTrue+1;i++){
            truePeople.add(Integer.parseInt(trueth[i]));
        }
//        System.out.println(truePeople);
        //파티 초기화
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<num;j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
//        for (int i = 0; i < M; i++) System.out.println(party[i]);

        boolean find = true;
        while(find){
            find = false;

            boolean  tmp= findTrueth();
            if(tmp){
                find = true;
            }
        }
        int ans = 0;
//        System.out.println(truePeople);
        for(int i=0;i<M;i++){
            for(int p:party[i]){
                if(truePeople.contains(p)){
                    ans++;
                    break;
                }
            }
        }
        System.out.println(M-ans);
    }
    private static boolean findTrueth(){
        boolean find = false;

        for (int i = 0; i < M; i++) {
            boolean hasTrue = false;
            for (int p : party[i]) {
                if (truePeople.contains(p)) {
                    hasTrue = true;
                    break;
                }
            }
            if (!hasTrue) continue;

            for (int nxt : party[i]) {
                if (truePeople.add(nxt)) {
                    find = true;
                }
            }
        }
        return find;
    }
}
