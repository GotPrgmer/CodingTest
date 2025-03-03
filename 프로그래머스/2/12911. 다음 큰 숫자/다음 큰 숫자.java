class Solution {
    public int solution(int n) {
        int answer = 0;
        int bitCnt = Integer.bitCount(n);
        while(true){
            n += 1;
            if(bitCnt==Integer.bitCount(n)){
                return n;
            }
        }
    }
    
}