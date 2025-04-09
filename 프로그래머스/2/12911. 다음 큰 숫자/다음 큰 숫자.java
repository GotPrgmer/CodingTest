class Solution {
    public int solution(int n) {
        int answer = 0;
        int obj = process(n);
        int num = n+1;
        while(true){
            if(obj == process(num)){
                answer = num;
                break;
            }
            num += 1;
                
        }
        return answer;
    }
    
    public int process(int num){
        String b = Integer.toString(num,2);
        int cnt = 0;
        for(int i=0;i<b.length();i++){
            if(b.charAt(i)=='1'){
                cnt += 1;
            }
        }
        return cnt;
    }
}