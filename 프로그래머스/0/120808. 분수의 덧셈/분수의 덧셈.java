class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int up = numer1*denom2+numer2*denom1;
        int down = denom1*denom2;
        int cmgcd = gcd(up,down);
        System.out.println(gcd(up,down));
        answer[0] = up/cmgcd;
        answer[1] = down/cmgcd;
        return answer;
    }
    public int gcd(int x, int y){
        if(y==0) return x;
        return gcd(y,x%y);
        
    }
}