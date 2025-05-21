class Solution {
    public int solution(int storey) {
        int ans = 0;
        while(storey != 0){
            if(storey%10 ==0){
                storey = storey/10;
                continue;
            }
            else{
                //5이하
                if(storey%10<5){
                    ans += storey%10;
                    storey = storey / 10;
                }
                //5초과
                else if(storey%10>5){
                    ans += 10 - storey%10;
                    storey = storey / 10 + 1;
                }
                //끝자리가 5라면 앞 숫자를 보고 5이상은 더하는게 이득이고
                // 앞 숫자가 5미만이면 빼는게 이득
                else{
                    int remain = storey/10;
                    if(remain%10>=5){
                        ans += 10 - storey%10;
                        storey = storey / 10 + 1;
                    }
                    else{
                        ans += storey%10;
                        storey = storey / 10;
                    }
                }
            }
        }
        return ans;
    }
}