import java.util.*;
class Solution {
    static Set<Integer> visited;
    public int solution(int x, int y, int n) {
        return bfs(x,0,n,y);
    }
    private int bfs(int x, int cnt,int n,int y){
        visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,0));
        visited.add(x);
        while(q.size()!=0){
            Pair p = q.poll();
            x = p.x;
            cnt = p.cnt;
            if(x == y){
                return cnt;
            }
            else{
                if(x+n <= y && !visited.contains(x+n)){
                    q.add(new Pair(x+n,cnt+1));
                    visited.add(x+n);
                }
                if(x*2 <= y && !visited.contains(x*2)){
                    q.add(new Pair(x*2,cnt+1));
                     visited.add(x*2);
                }
                if(x*3 <= y && !visited.contains(x*3)){
                    q.add(new Pair(x*3,cnt+1));
                     visited.add(x*3);
                }
            }
        }
        return -1;
        
    }
    public class Pair{
    int x;
    int cnt;
    public Pair(int x, int cnt){
        this.x = x;
        this.cnt = cnt;
        }
    }
}
