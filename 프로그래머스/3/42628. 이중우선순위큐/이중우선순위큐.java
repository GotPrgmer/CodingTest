import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // PriorityQueue를 사용하여 자동으로 정렬되도록 함
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String op : operations) {
            String[] s = op.split(" ");
            if (s[0].equals("I")) { // Insert operation
                int value = Integer.valueOf(s[1]);
                minPQ.add(value);
                maxPQ.add(value);
            } else {
                if (s[1].equals("1")) { // Delete maximum value
                    if (!maxPQ.isEmpty()) {
                        int max = maxPQ.poll();
                        minPQ.remove(max); // Remove the same value from minPQ
                    }
                } else { // Delete minimum value
                    if (!minPQ.isEmpty()) {
                        int min = minPQ.poll();
                        maxPQ.remove(min); // Remove the same value from maxPQ
                    }
                }
            }
        }
        
        // After all operations, return the max and min values
        if (minPQ.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int max = maxPQ.poll();
            int min = minPQ.poll();
            return new int[]{max, min};
        }
    }
}