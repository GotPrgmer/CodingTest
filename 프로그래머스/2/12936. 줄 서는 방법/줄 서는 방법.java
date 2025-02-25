class Solution {
    public int[] solution(int n, long k) {
        long divide = 1;
        int[] answer = new int[n];
        boolean[] visited = new boolean[n+1];
        for(int i=2;i<n;i++){
            divide *= i;
        }
        //1을 빼고
        k -= 1;
        int idx = 0;
        long turn = n-1;
        long share=1;
        while(idx<n){
            // System.out.println(share+" "+k+" "+divide+" "+idx+" "+n+" "+turn);
            if(divide>0){
                share = (long)(k/divide)+1L;
                k = k%divide;
            }
            int cnt = 0;
            
           if (turn > 0) {
                divide = divide / turn;
               turn-=1;
            }
            // devide = devide/turn;
            
            // break;
            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    cnt += 1;
                }
                if(cnt==share){
                    answer[idx] = i;
                    idx += 1;
                    visited[i] = true;
                    break;
                }
            }
            // devide = (long)devide/turn;
            // turn -= 1;
            
        }
        return answer;
    }
}