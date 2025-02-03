class Solution {
    private static double plusTime(double time){
        if(time == 0){
            return 360;
        }
        else{
            return time;
        }
    } 
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        double start = h1*3600+m1*60+s1;
        double end = h2*3600 + m2*60+s2;
        //시작할때 겹침
        if(start == 0 || start == 12*3600 ){
            answer += 1;
        }
        while(start<end){
            double curH = start/120%360;
            double curM = start/10%360;
            double curS = 6*start%360;
            
            double nH = plusTime((start+1)/120%360);
            double nM = plusTime((start+1)/10%360);
            double nS = plusTime(6*(start+1)%360);
            
            if(curS<curM && nS>=nM){
                answer += 1;
            }
            if(curS<curH && nS>=nH){
                answer += 1;
            }
            if(nH==nM && nM==nS){
                answer -= 1;
            }
            start += 1;
        }
        return answer;
    }
}