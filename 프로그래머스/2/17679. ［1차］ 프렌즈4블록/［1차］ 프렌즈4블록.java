import java.util.*;
class Solution {
    static Set<Pair> set;
    static char[][] cur;
    public int solution(int m, int n, String[] board) {
        cur = new char[board.length][board[0].length()];
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                cur[i][j] = board[i].charAt(j);
            }
        }
        int answer = 0;
        while(true){
            set = new HashSet<>();
            // 특정 index에서 2x2찾아서 set에 좌표넣는 로직
            for(int i =0;i<board.length;i++){
                for(int j=0;j<board[0].length();j++){
                    if(cur[i][j] != '0' && 'A'<=cur[i][j] && cur[i][j]<='Z'){
                        insert(new Pair(i,j),m,n);
                    }
                }
            }
            //set에 들어가있는걸 제거함
            if(set.size()==0){
                break;
            }
            for(Pair pair:set){
                System.out.println(pair);
                cur[pair.r][pair.c] = '0';
                answer += 1;
            }
            // System.out.println("---------------");

            //떨어지는 로직
            fall(m,n);
            
        }
        
        
        
        return answer;
    }
    // 특정 inde에서 2x2찾아서 Set에 2x2좌표들 다 넣기
    public void insert(Pair p,int m,int n){
        int r = p.r;
        int c = p.c;
        boolean flag = true;
        for(int i=r;i<r+2;i++){
            for(int j=c;j<c+2;j++){
                //영역 안넘는지
                if(0<=i && i<m & 0<=j && j<n){
                    //값이 p와 같은지
                    if(cur[i][j] != cur[p.r][p.c] || 'A'>cur[p.r][p.c] || cur[p.r][p.c]>'Z' ){
                        flag = false;
                        break;
                    }
                }
                else{
                    flag = false;
                    break;
                }
                
            }
        }
            //set에 넣기
            if(flag == true){
                for(int k=r;k<r+2;k++){
                    for(int j=c;j<c+2;j++){
                        set.add(new Pair(k,j));
                    }
                }
            
        }
    }
    // 떨어지는 로직
    public void fall(int m, int n){
        //열을 돌면서 행으로 밑으로 내려가면서 문자가 있으면 while문으로 범위가 허락된 상태에서 연속된 가장 낮은
        // 공간을 찾아서 넣는다.
        for(int i=0;i<n;i++){
            List<Character> list = new ArrayList<>();
            for(int j=0;j<m;j++){
                if(cur[j][i] !='0'){
                    list.add(cur[j][i]);
                }
            }
            //리스트 수만큼 넣어준다.
            for(int j=0;j<list.size();j++){
                cur[j+(m-list.size())][i] = list.get(j);
            }
            for(int j=0;j<m-list.size();j++){
                cur[j][i] = '0';
            }
            
        }
    }
    class Pair{
        int r;
        int c;
        public Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString(){
            return this.r +" "+ this.c;
        }
        @Override
        public boolean equals(Object o){
            if (!(o instanceof Pair))
            return false;
            Pair p = (Pair) o;
            return this.r == p.r && this.c == p.c;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(this.r, this.c);
        }
    }
}

