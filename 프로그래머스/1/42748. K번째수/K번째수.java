import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int cmd=0;cmd<commands.length;cmd++){
            int i = commands[cmd][0];
            int j = commands[cmd][1];
            int k = commands[cmd][2];
            int[] tmp = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(tmp);
            result.add(tmp[k-1]);

        }
        return result.stream().mapToInt(i->i).toArray();
    }
}