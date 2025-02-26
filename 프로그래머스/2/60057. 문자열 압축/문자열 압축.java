class Solution {
    public int solution(String s) {
        //문자열 자르는 패턴
        int answer = s.length();
        for(int i=1;i<s.length()/2+1;i++){
            //비교할 문자열
            String cur = s.substring(0,i);
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            String target = "";
            for(int j=i;j<s.length()+1;j+=i){
                //글자수가 아직 안넘어가는 경우
                if(j+i<s.length()){
                    target = s.substring(j,j+i);
                }
                // 글자수가 넘어간다면 그대로 이어붙임
                else{
                    target = s.substring(j,s.length());
                }
                // System.out.println(cur+" "+target+" "+cnt);
                //비교해서 글자가 같다면 cnt올리기
                if(cur.equals(target)){
                    cnt += 1;
                }
                else if(cnt==1){
                    sb.append(cur);
                    cur = target;
                }
                else{
                    sb.append(cnt).append(cur);
                    cur = target;
                    cnt = 1;
                }
            }
            // if(i!=cur.length())sb.append(cur);
            sb.append(cur);
            // System.out.println(sb.toString());
            //만약 마지막에 글자수가 제대로 안잘린게 있으면 
            //turn이 끝나면 answer를 갱신
            answer = Math.min(answer,sb.toString().length());
        }
        return answer;
    }
}