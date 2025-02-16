import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        Set<Character> set = new HashSet<>();
        
        int answer = 0;
        //skill_tress돌면서 st를 하나씩 뺌
        for(int i=0;i<skill_trees.length;i++){
            Stack<Character> st = new Stack<>();
            //skill에 있는 문자 들어가기
            for(int k=skill.length()-1;k>-1;k--){
                st.push(skill.charAt(k));
                set.add(skill.charAt(k));
            }
            boolean flag = true;
            for(int j=0;j<skill_trees[i].length();j++){
                if(st.size()==0){
                    break;
                }
                if(set.contains(skill_trees[i].charAt(j))){
                    if(st.peek()==skill_trees[i].charAt(j)){
                        System.out.println(skill_trees[i].charAt(j));
                        st.pop();
                    }
                    else{
                        flag = false;
                        break;
                    }
                }

            }
            if(flag == true){
                answer += 1;
            }
        }
        return answer;
    }
}