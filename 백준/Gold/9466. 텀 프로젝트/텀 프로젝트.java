import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static StringTokenizer st;
    static int ans = 0;
    static boolean[] visit, team;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test=0;test<T;test++){
            st = new StringTokenizer(br.readLine());
            int students = Integer.parseInt(st.nextToken());
            //리스트 초기화
            arr = new int[students + 1];
            visit = new boolean[students + 1];
            team = new boolean[students + 1];
            st = new StringTokenizer(br.readLine());
            ans = 0;
            for(int student=1;student<students+1;student++){
                arr[student] = Integer.parseInt(st.nextToken());
                if(arr[student] == student){
                    team[student] = true;
                    ans ++;
                }
            }
//            System.out.println(arr);
            for(int node=1;node<students+1;node++){
                if(!team[node]){
                    solve(node);
                }
            }
            System.out.println(students - ans);

        }
    }
    static void solve(int x){
        if(team[x]) return;
        if(visit[x]){
            team[x] = true;
            ans ++;
        }
        visit[x] = true;
        solve(arr[x]);
        team[x] = true;
        visit[x] = false;
    }
}
