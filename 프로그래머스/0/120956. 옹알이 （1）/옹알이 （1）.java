class Solution {
    public int solution(String[] babbling) {
        int ans = 0;
        for(String b:babbling){
            b = b.replace("aya"," ");
            b = b.replace("ye"," ");
            b = b.replace("woo"," ");
            b = b.replace("ma"," ");
            // System.out.println(b);
            if(b.trim().equals("")){
                System.out.println(b);
                ans +=1;
            }
        }
        return ans;
    }
    
}