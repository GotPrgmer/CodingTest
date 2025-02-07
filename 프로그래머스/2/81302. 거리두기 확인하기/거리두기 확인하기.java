import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int m=0;m<5;m++){
            List<Pair> list = new ArrayList<>();
            //p대입
            for(int r=0;r<5;r++){
                for(int c=0;c<5;c++){
                    if(places[m][r].charAt(c)=='P'){
                    Pair p = new Pair(r,c);
                    list.add(p);
                }
                }
            }
            if(list.size() <2){
                answer[m] = 1;
            }
            else{
                // 거리계산해서 1일때는 바로 0넣고 2때는 bfs로 판단해서 true면 0넣음
            boolean flag = false;
            System.out.println("맵 " +(m+1)+"번째");
            for(Pair p1:list){
                for(Pair p2:list){
                    int dist = Math.abs(p1.r-p2.r) + Math.abs(p1.c-p2.c);

                    // System.out.println(p1.r+" "+p1.c +" " +p2.r+" "+p2.c);
                    // System.out.println("거리" + dist);
                    //맨해튼 거리 계산
                    if(dist == 2){
                        //P로 갈 수 있으면 true로 바꿈
                        if(check(places[m],p1,p2)){
                            // System.out.println("갈 수 있음");
                            flag = true;
                            break;
                        }
                        else{
                            continue;
                        }
                    }
                    else if(dist == 1){
                        flag = true;
                        break;
                    }
                }
                if(flag == true){
                    answer[m] = 0;
                    break;
                }
                else{
                    answer[m] = 1;
                }
            }
            }
            
        }
        
        //p들끼리 비교하면서 2인 경우 
        return answer;
    }
    
    public boolean check(String[] place,Pair p1,Pair p2){
        int[] d_r = new int[]{-1,0,1,0};
        int[] d_c = new int[]{0,1,0,-1};
        //bfs
        Queue<Pair_dist> q = new LinkedList<>();
        q.offer(new Pair_dist(p1,0));
        int n_r;
        int n_c;
        Pair cur_p;
        int cur_r;
        int cur_c;
        int cur_dist;
        boolean[][] visited = new boolean[5][5];
        while(q.size() != 0){
            System.out.println(q.toString());
            Pair_dist cur = q.poll();
            cur_p = cur.p;
            cur_r = cur_p.r;
            cur_c = cur_p.c;
            cur_dist = cur.dist;
            System.out.println(cur_r+" "+cur_c+" "+cur_dist);

            if(cur_r==p2.r && cur_c==p2.c && cur_dist == 2){
                return true;
            }
            else if(cur_dist > 2){
                continue;
            }
            
            visited[cur_r][cur_c] = true;
            //다음 노드들 검사
            for(int d=0;d<4;d++){
                n_r = cur_r + d_r[d];
                n_c = cur_c + d_c[d];
                //범위 검사
                if(0<=n_r && n_r<5 && 0<=n_c && n_c<5){
                    //O이면 넘어감
                    if((place[n_r].charAt(n_c) =='P' || place[n_r].charAt(n_c) == 'O') && !visited[n_r][n_c]){
                        Pair n_p = new Pair(n_r,n_c);
                        q.offer(new Pair_dist(n_p,cur_dist+1));
                    }
                }
            }
            
        }
        return false;
    }
}
class Pair{
    int r;
    int c;
    public Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
    @Override
    public String toString(){
        return String.valueOf(r) +" " + String.valueOf(c);
    }
}
class Pair_dist{
    Pair p;
    int dist;
    public Pair_dist(Pair p,int dist){
        this.p = p;
        this.dist = dist;
    }
    @Override
    public String toString(){
        return this.p +" " + String.valueOf(dist);
    }
}