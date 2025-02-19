class Solution {
    public long solution(int[] weights) {
        int[] weightCnt = new int[1001];
        int[] mulWeight = new int[4001];
        long answer = 0;
        for(int i=0;i<weights.length;i++){
            long curCnt = weightCnt[weights[i]];
            int m2 = weights[i]*2;
            int m3 = weights[i]*3;
            int m4 = weights[i]*4;
            //1개이상있었다면
            if(curCnt>0){
                answer += curCnt;
                answer += mulWeight[m2]-curCnt;
                answer += mulWeight[m3]-curCnt;
                answer += mulWeight[m4]-curCnt;
            }
            else{
                answer += mulWeight[m2];
                answer += mulWeight[m3];
                answer += mulWeight[m4];
            }
            
            weightCnt[weights[i]] += 1;
            mulWeight[m2] += 1;
            mulWeight[m3] += 1;
            mulWeight[m4] += 1;
                
            }
        return answer;
        }
        
    }
