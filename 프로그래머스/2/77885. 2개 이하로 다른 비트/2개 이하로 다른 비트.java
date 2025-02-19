class Solution {
    //최하위 0을 찾아서 반전시키고
    // 그 바로 아래 1을 발견하면 0으로 반전 시킨다.
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        // System.out.println(Long.toString(3,2));
        for(int i=0;i<numbers.length;i++){
            long bit = toggle(numbers[i]);
            answer[i] = bit;
        }

        return answer;
    }
    public long toggle(long bit){
        //최하위 0을 찾는다.
        long zeroIdx = 1;
        while(true){
            if((bit&(1L<<(zeroIdx-1)))==0){
                break;
            }
            else{
                zeroIdx += 1;
            }
        }
        //zeroIdx를 1로 만듦
        bit = bit|(1L<<(zeroIdx-1));
        //zeroIdx보다 작은 애들중 1인것 찾자
        long oneIdx = zeroIdx-1;
        // System.out.println(bit);
        while(oneIdx>0){
            // System.out.println(oneIdx);
            if((bit&(1L<<(oneIdx-1)))!=0){
                bit = bit&(~(1L<<(oneIdx-1)));
                break;
            }
            else{
                oneIdx -= 1;
            }
        }
        // System.out.println(zeroIdx+" "+oneIdx);
        return bit;
        
    }
}