import java.util.*;
import java.io.*;

public class Main {
    static int[][] street;
    static int N, M, ans;
    static int[] comb;
    static List<Pair1> chicken = new ArrayList<>();
    static List<Pair1> home = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        street = new int[N][N];

        comb = new int[M];
        ans = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                street[i][j] = num;
                if(num == 1) home.add(new Pair1(i,j));
                else if(num == 2) chicken.add(new Pair1(i,j));
            }
        }

        extractComb(0, 0);
        System.out.println(ans);
    }

    static void extractComb(int idx, int start){
        if(idx == M){
            ans = Math.min(ans, chickenDistance());
            return;
        }
        for(int i=start;i<chicken.size();i++){
            comb[idx] = i;
            extractComb(idx+1, i+1);
        }
    }

    static int chickenDistance(){
        int city_dist = 0;
        for(Pair1 cur_home : home){
            int tmp = Integer.MAX_VALUE;
            for(int j=0;j<M;j++){
                Pair1 cur_chicken = chicken.get(comb[j]);
                tmp = Math.min(tmp, calDistance(cur_home.x, cur_home.y, cur_chicken.x, cur_chicken.y));
            }
            city_dist += tmp;
        }
        return city_dist;
    }

    static int calDistance(int r1, int c1, int r2, int c2){
        return Math.abs(r1-r2)+Math.abs(c1-c2);
    }
}

class Pair1{
    int x, y;
    Pair1(int x, int y){ this.x=x; this.y=y; }
}
