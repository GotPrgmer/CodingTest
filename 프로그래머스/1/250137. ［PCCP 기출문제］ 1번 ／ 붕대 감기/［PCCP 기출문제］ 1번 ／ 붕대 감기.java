class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 힐링 타임 t
        int t = 0;
        int cur_health = health;
        int s = 0;
        
        int fullHealingT = bandage[0];
        int perHeal = bandage[1];
        int plusHeal = bandage[2];
        
        for(int i=0;i<attacks.length;i++){
            int attackT = attacks[i][0];
            int attackP = attacks[i][1];
            System.out.println(attackT);
            // 회복 코드
            while(true){
                System.out.println(cur_health + " " + s+" "+t);
                // 체력이 풀이 아닐경우
                
                // 스킬이 완성이 아닐 경우
                t += 1;
                s += 1;
                if(s==attackT){
                    break;
                }
                
                if(t<fullHealingT){
                    if(cur_health+perHeal<=health){
                        cur_health += perHeal;
                    }else{
                        cur_health = health;
                    }
                }
                // 스킬이 완성일 경우
                else if(t == fullHealingT){
                    if(cur_health+perHeal+plusHeal<=health){
                        cur_health += perHeal+plusHeal;
                    }else{
                        cur_health = health;
                    }
                    t = 0;
                }
               
                 
                // System.out.println(cur_health + " " + s+" "+t);
                
            }
           System.out.println(cur_health + " " + s+" "+t+"공격전");
            if(s==attackT){
                cur_health -= attackP;
                t = 0;
                if(cur_health <= 0){
                    return -1;
                }
                
            }
            // System.out.println(cur_health + " " + s+" "+t);
        }
        return cur_health;
    }
}