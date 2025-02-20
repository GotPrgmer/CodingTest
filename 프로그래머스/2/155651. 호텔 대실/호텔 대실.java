class Solution {
    public int solution(String[][] book_time) {
        //끝나는 시간으로 정렬하고
        //시작하는 시간이 끝나는 시간보다 앞서있다면 방이 하나더 필요하다.
        int[] time = new int[23*60+70];
        for(int i =0;i<book_time.length;i++){
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            time[calTime(start)] += 1;
            time[calTime(end)+10] -= 1;
        }
        int ans = -1;
        for(int i=1;i<time.length;i++){
            time[i] += time[i-1];
            ans = Math.max(ans,time[i]);
        }
        
        return ans;
    }
    public int calTime(String[] t){
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h*60+m;
    }
}