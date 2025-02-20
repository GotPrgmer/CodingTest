class Solution {
    public int solution(int storey) {
        return process(storey,0);
    }
    public int process(int total, int answer){
        int totalLength = String.valueOf(total).length();
        //해당 자리수를 6~9는 올리고
        // 0~4는 내리고
        // 5면 다음 숫자를 보고 내리거나 올리거나 하자.
        
        //내리는건 0으로 만들고
        //올리는건 다음 숫자에 1을 만드니까 현재 10의 값에서 10곱해서 더하는방식
        int cur = 10;
        while(total != 0 && cur<Math.pow(10,totalLength+2)){
            //현재 숫자
            int tmp = total%cur;
            int curNum;
            if(tmp==0){
                System.out.println("브레이크");
                    curNum = 0;
                }
                else{
                    curNum = tmp/(cur/10);
                }           
            System.out.println(total +"현재 숫자" + cur +" 10의 숫자"+curNum +"자리수");

            if(0<=curNum && curNum <5){
                total -= curNum*(cur/10);
                answer += curNum;
            }
            else if(6<=curNum && curNum <10){
                total -= curNum*(cur/10);
                total += cur;
                answer += 10-curNum;
            }
            else{
                //다음숫자
                int next = cur*10;
                int tmp2 = total%next;
                int curSpecial;

                curSpecial = tmp2/cur;
                
            System.out.println(total +"현재 숫자" + cur +" 10의 숫자"+curSpecial +"자리수");

                //다음 숫자를 한번 보고 다음숫자가 5이상이면 올리고 
                if(0<=curSpecial && curSpecial <5){
                    total -= curNum*(cur/10);
                    answer += 5;
                }
                else if(5<=curSpecial && curSpecial <10){
                    total -= curNum*(cur/10);
                    answer += 5;
                    total += (cur);
                }
                //그렇지 않으면 내린다.
                
                }
            
                cur = cur*10;
        }
        return answer;
        
    }
}